package StepDefinitions;

import Application.signup;
import helpers.EmailOtpReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.cdimascio.dotenv.Dotenv;
import jakarta.mail.MessagingException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class signupstep {
    signup app;
    private helpers.EmailOtpReader emailHelper;
    private long firstNewUid;
    Dotenv dotenv = Dotenv.load();
    WebDriver driver;

    @Given("^user launches the authorized partner website$")
    public void openWebsite() {
        driver = new ChromeDriver();
        app = new signup(driver);
        app.launch();
    }

    @When("^user clicks on Login$")
    public void clickLoginButton() {
        app.clickOnLogin();
    }


    @And("user clicks on Sign Up")
    public void userClicksOnSignUp() {
        app.clickSignUp();
    }

    @And("user clicks on checkbox of Terms and conditions")
    public void userClicksOnCheckboxOfTermsAndConditions() {

        app.clicksOnCheckboxOfTermsAndConditions();
    }

    @And("user clicks on Continue")
    public void userClicksOnContinue() {
        app.clicksOnContinue();
    }

    @And("user enters registration details")
    public void userEntersRegistrationDetails(DataTable dataTable) {
        Map<String, String> details = dataTable.asMap(String.class, String.class);
        app.entersRegistrationDetails(
                details.get("firstname"),
                details.get("lastname"),
                details.get("email_address"),
                details.get("password"),
                details.get("confirm_password"),
                details.get("phone_number")
        );
    }

    @Given("user connect mail server using email and password")
    public void userConnectMailServerUsingEmailAndPassword() throws MessagingException {
        emailHelper = new EmailOtpReader(
                requiredValue(dotenv, "HOST_IMAP_HOST"),
                requiredValue(dotenv, "EMAIL_USERNAME"),
                requiredValue(dotenv, "EMAIL_APP_PASSWORD"));
        firstNewUid = emailHelper.captureNextUid();
    }

    private static String requiredValue(Dotenv dotenv, String key) {
        String value = dotenv.get(key);

        if (value==null || value.isBlank()) {
            throw new IllegalStateException("Missing configuration value: "+ key);
        }
        return value;
    }

    @And("user clicks on Next")
    public void userClicksOnNext() {
        app.clicksOnNext();
    }

    @And("user retrieves OTP from email and summit it")
    public void userRetrievesOTPFromEmail() {
        String otp = emailHelper.waitForOtp(
                firstNewUid,
                Duration.ofSeconds(90)
        );
        app.entersTheOTP(otp);
    }

    @And("user clicks on Verify Code")
    public void userClicksOnVerifyCode() {
        app.clicksOnVerifyCode();
    }

    @And("^user enters agency details$")
    public void userEntersAgencyDetails(DataTable dataTable) {
        Map<String, String> agency = dataTable.asMap(String.class, String.class);
        app.enterAgencyDetails(
                agency.get("Name"),
                agency.get("Role_in_Agency"),
                agency.get("Email_Address"),
                agency.get("Website"),
                agency.get("Address")
        );
    }

    @And("^user selects region of operation$")
    public void userSelectsRegionOfOperation(List<String> countries) {
        app.selectsRegionOfOperation(countries);

    }

    @And("user click on next")
    public void userClickOnNext() {
        app.clickOnNext();
    }

    @And("user enters professional experience")
    public void userEntersProfessionalExperience(DataTable dataTable) {

        Map<String, String> professionalExperience =
                dataTable.asMap(String.class, String.class);

        String years = professionalExperience.get("Years_of_Experience");
        String students = professionalExperience.get("Number_of_Students_Recruited_Annually");
        String focus = professionalExperience.get("Focus_Area");
        String metric = professionalExperience.get("Success_Metrics");

        app.enterProfessionalExperience(years, students, focus, metric);
    }
    @And("user click on all checkbox")
    public void userClickOnAllCheckbox() {
        app.ClickOnAllCheckbox();
    }
    @And("User click on Next")
    public void ClickNext() {
        app.clickNext();
    }

    @And("user enter business registration number")
    public void userEnterBusinessRegistrationNumber(DataTable dataTable) {

        Map<String, String> registrationDetails =
                dataTable.asMap(String.class, String.class);

        String number = registrationDetails.get("Business_Registration_Number");

        app.enterBusinessRegistrationNumber(number);
    }

    @And("user select preferred countries")
    public void userSelectPreferredCountries(List<String> country) {
        app.selectPreferredCountries(country);
    }

    @And("user select on all checkbox")
    public void userSelectAllCheckbox() {
        app.selectAllCheckbox();
    }

    @And("user uploads required document")
    public void userUploadsRequiredDocument() {
        app.uploadsRequiredDocument();
    }

    @And("user clicks on Submit")
    public void userClicksOnSubmit() {
        app.clicksOnSubmit();
    }

    @Then("user should be successfully registered")
    public void userShouldBeSuccessfullyRegistered() {
        app.shouldBeSuccessfullyRegistered();
    }

    @When("user click on logout")
    public void userClicksOnLogout() {
        app.clicksOnLogout();
    }

    @And("user confirms logout")
    public void userConfirmsLogout() {
        app.confirmsLogout();
    }

    @Then("user should be redirected to Login page")
    public void userShouldBeRedirectedToLoginPage() {
        app.shouldBeRedirectedToLoginPage();
    }

    @And("user closes the browser")
    public void userClosesTheBrowser() {
        app.closesTheBrowser();
    }
}


