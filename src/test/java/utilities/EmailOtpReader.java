package helpers;

import jakarta.mail.*;
import jakarta.mail.internet.MimeMultipart;
import org.jsoup.Jsoup;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class EmailOtpReader implements AutoCloseable {

    private static final String OTP_SUBJECT =
            "Signup Confirm OTP";

    private static final Pattern OTP_PATTERN = Pattern.compile(
            "To complete your email verification, please use the code below:\\s*(\\d+)\\s*This code",
            Pattern.CASE_INSENSITIVE | Pattern.DOTALL
    );

    private final Store store;

    public EmailOtpReader(
            String host,
            String username,
            String password
    ) throws MessagingException {
        Properties properties = new Properties();
        properties.setProperty("mail.store.protocol", "imaps");
        properties.setProperty("mail.imaps.ssl.enable", "true");
        properties.setProperty("mail.imaps.ssl.checkserveridentity", "true");
        properties.setProperty("mail.imaps.connectiontimeout", "10000");
        properties.setProperty("mail.imaps.timeout", "10000");

        Session session = Session.getInstance(properties);
        store = session.getStore("imaps");
        store.connect(host, 993, username, password);
    }

    // Call immediately before triggering the OTP email.
    public long captureNextUid() throws MessagingException {
        Folder inbox = store.getFolder("INBOX");

        try {
            inbox.open(Folder.READ_ONLY);
            long nextUid = ((UIDFolder) inbox).getUIDNext();

            if (nextUid < 1) {
                throw new MessagingException(
                        "Mail server did not provide UIDNEXT"
                );
            }

            return nextUid;
        } finally {
            if (inbox.isOpen()) {
                inbox.close(false);
            }
        }
    }

    public String waitForOtp(long firstNewUid, Duration timeout) {
        return new FluentWait<>(this)
                .withTimeout(timeout)
                .pollingEvery(Duration.ofSeconds(2))
                .withMessage("No new matching OTP email arrived")
                .until(helper -> {
                    try {
                        return helper.findOtp(firstNewUid);
                    } catch (Exception exception) {
                        // Fail with context instead of hiding connection/parsing errors.
                        throw new IllegalStateException(
                                "Failed to read OTP mailbox", exception
                        );
                    }
                });
    }

    private String findOtp(long firstNewUid) throws Exception {
        Folder inbox = store.getFolder("INBOX");

        try {
            inbox.open(Folder.READ_ONLY);
            UIDFolder uidFolder = (UIDFolder) inbox;

            Message[] messages = uidFolder.getMessagesByUID(
                    firstNewUid, UIDFolder.LASTUID
            );

            // Prefer the latest matching email.
            for (int index = messages.length - 1; index >= 0; index--) {
                Message message = messages[index];

                if (message == null
                        || uidFolder.getUID(message) < firstNewUid
                        || !OTP_SUBJECT.equalsIgnoreCase(message.getSubject())) {
                    continue;
                }

                Matcher matcher = OTP_PATTERN.matcher(readText(message));

                if (matcher.find()) {
                    return matcher.group(1);
                }
            }

            return null; // FluentWait will poll again.
        } finally {
            if (inbox.isOpen()) {
                inbox.close(false);
            }
        }
    }

    private static String readText(Part part) throws Exception {
        if (part.isMimeType("text/plain")) {
            return String.valueOf(part.getContent());
        }

        if (part.isMimeType("text/html")) {
            return Jsoup.parse(String.valueOf(part.getContent())).text();
        }

        if (part.isMimeType("multipart/*")) {
            MimeMultipart multipart = (MimeMultipart) part.getContent();
            StringBuilder text = new StringBuilder();

            for (int index = 0; index < multipart.getCount(); index++) {
                BodyPart bodyPart = multipart.getBodyPart(index);

                if (!Part.ATTACHMENT.equalsIgnoreCase(
                        bodyPart.getDisposition())) {
                    text.append(readText(bodyPart)).append('\n');
                }
            }

            return text.toString();
        }

        if (part.isMimeType("message/rfc822")) {
            return readText((Part) part.getContent());
        }

        return "";
    }

    @Override
    public void close() throws MessagingException {
        if (store.isConnected()) {
            store.close();
        }
    }
}