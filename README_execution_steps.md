# README_Execution Steps

## 1. Project Overview

This project contains automated test scenarios for the authorized partner signup and logout functionality using Selenium WebDriver, Java, and Cucumber BDD.

The automation covers:
- Partner registration
- Email OTP verification
- Form field validation
- File upload
- Checkbox selection
- Successful signup verification
- Logout functionality


## 2. Prerequisites

Install the following before running the project:

- Java JDK 26
- IntelliJ IDEA
- Maven
- Google Chrome browser
- Git

## 3. Technology Stack

| Technology | Version |
|---|---|
| Java | 26 |
| Selenium WebDriver | 4.43.0 |
| Cucumber Java | 7.33.0 |
| Cucumber TestNG | 7.32.0 |
| TestNG | 7.11.0 |
| WebDriverManager | 6.2.0 |
| dotenv-java | 3.2.0 |

Additional libraries:
- Jakarta Mail – 2.0.3
- Jsoup – 1.10.2

## 4. Project Setup

**Step 1: Clone the repository**

```bash
git clone https://github.com/nishantbhattarai77-a11y/signup_automation_script.git
```

**Step 2: Open the project**

Open the cloned project in IntelliJ IDEA.

**Step 3: Configure Java and Maven**

Make sure Java JDK 26 is configured as the project SDK.

**Step 4: Install dependencies**

Open the terminal in the project root directory and execute:

```bash
mvn clean install
```

## 5. Environment Configuration

The project uses a .env file to securely store email configuration details required for automated OTP (One-Time Password) retrieval.

Create a .env file in the root directory of the project and add the following environment variables:

EMAIL_USERNAME=your_email@gmail.com
EMAIL_APP_PASSWORD=your_app_password
OTP_EMAIL_SENDER=sender_email@gmail.com
OTP_EMAIL_SUBJECT=Your OTP Subject
HOST_IMAP_HOST=imap.gmail.com

Replace the example values with your actual email credentials, enable IMAP access if required,
and use a Gmail App Password instead of your regular password. Add .env to .gitignore to ensure sensitive credentials are not uploaded or shared on GitHub.



## 6. Test Data

The project uses a dummy PDF file for the document upload functionality.

Location:

```text
src/test/resources/testdatafile/automation_dummy_document.pdf
```

The test data file is included in the repository and is used during automation execution.

## 7. Test Execution

**Option 1: Using IntelliJ IDEA**

1. Open the Cucumber TestNG runner class.
2. Right-click the runner class.
3. Select Run.
4. Monitor the execution in the Run console.

## 8. Test Reports

After execution, check the generated test reports.

The reports provide information about:
- Project Information
- Test Scenario and coverage
- Test Execution Details
- Execution Observation

The submitted test report and demo video are available in the repository.

## 9. Troubleshooting

- Ensure Java and Maven are correctly configured.
- Verify that Chrome is installed.
- Check email credentials and OTP access.
- Ensure the `.env` file contains the required configuration.
- Check the execution logs for Selenium or Cucumber errors.

## 10. Important Notes

- Use valid test credentials where required.
- Ensure the test email account can receive OTP messages.
- The automation uses WebDriverManager to manage the browser driver.
- Do not commit private credentials to the repository.