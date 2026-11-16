package Application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobjects.signuppage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class signup {
    public signuppage signup;

    WebDriver driver;
    WebDriverWait wait;

    public signup(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        this.signup = new signuppage(driver);
    }

    public void launch() {
        driver.manage().window().maximize();
        driver.get("https://authorized-partner.vercel.app/");
    }

    // Click Login
    public void clickOnLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(signup.loginButton)).
                click();
    }

    // Click Sign Up
    public void clickSignUp() {
        wait.until(ExpectedConditions.elementToBeClickable(signup.signupButton)).
                click();
    }

    // Click Remember Checkbox
    public void clicksOnCheckboxOfTermsAndConditions() {
        wait.until(ExpectedConditions.elementToBeClickable(signup.checkboxOfTermsAndConditions))
                .click();
    }

    // Click Continue
    public void clicksOnContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(signup.continueButton))
                .click();
    }

    // Enter Credentials
    public void entersRegistrationDetails(String firstname, String lastname,
                                          String emailAddress, String password,
                                          String confirmPassword, String phoneNumber) {
        String randomNumber = generateRandomNumber();
        String email = emailAddress.replace("random", randomNumber);
        String number = "";
        if (Objects.equals(phoneNumber, "randomNumber")) {
            number = "98422" + randomNumber;
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(signup.firstName)).sendKeys(firstname);
        wait.until(ExpectedConditions.visibilityOfElementLocated(signup.lastName)).sendKeys(lastname);
        wait.until(ExpectedConditions.visibilityOfElementLocated(signup.email)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(signup.password)).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(signup.confirmPassword)).sendKeys(confirmPassword);
        wait.until(ExpectedConditions.visibilityOfElementLocated(signup.phoneNumber)).sendKeys(number);
        ;
    }
    //using randomNumber email and phoneNumber
    public String generateRandomNumber() {
        return String.valueOf(
                ThreadLocalRandom.current().nextInt(10000, 100000)
        );
    }

    // Click Next
    public void clicksOnNext() {
        wait.until(ExpectedConditions.elementToBeClickable(signup.nextButton))
                .click();
    }



    // Enter OTP
    public void entersTheOTP(String OTP) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signup.OTPField))
                .sendKeys(OTP);
    }

    // Click Verify Code
    public void clicksOnVerifyCode() {
        wait.until(ExpectedConditions.elementToBeClickable(signup.verifyCodeButton))
                .click();
    }

    // Enter Agency Details
    public void enterAgencyDetails(String name, String roleinagency,
                                   String emailAddress, String website,
                                   String address) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(signup.agencyName))
                .sendKeys(name);

        wait.until(ExpectedConditions.visibilityOfElementLocated(signup.roleInAgency))
                .sendKeys(roleinagency);

        wait.until(ExpectedConditions.visibilityOfElementLocated(signup.agencyEmail))
                .sendKeys(emailAddress);

        wait.until(ExpectedConditions.visibilityOfElementLocated(signup.agencyWebsite))
                .sendKeys(website);

        wait.until(ExpectedConditions.visibilityOfElementLocated(signup.agencyAddress))
                .sendKeys(address);
    }

    // Select Region from Dropdown
    public void selectsRegionOfOperation(List<String> countries) {

        countries.forEach(country -> {
            wait.until(ExpectedConditions.elementToBeClickable(signup.regionDropdown))
                    .click();
            By regionOption = By.xpath(
                    "//*[normalize-space()='" + country + "']"
            );
            wait.until(ExpectedConditions.elementToBeClickable(regionOption))
                    .click();

        });
    }

    // Click Next
    public void clickOnNext() {
        wait.until(ExpectedConditions.elementToBeClickable(signup.nextButton))
                .click();
    }

    // Enter Professional Experience

    public void enterProfessionalExperience(
            String yearsOfExperience,
            String numberOfStudentsRecruited,
            String focusArea,
            String successMetrics) {


        wait.until(ExpectedConditions.elementToBeClickable(
                signup.experienceLevelDropdown)).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                signup.experienceLevelOption(yearsOfExperience))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                        signup.studentsRecruited))
                .sendKeys(numberOfStudentsRecruited);

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                        signup.focusArea))
                .sendKeys(focusArea);

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                        signup.successMetrics))
                .sendKeys(successMetrics);
    }

    //click on all checkboxes
    public void ClickOnAllCheckbox() {

        List<WebElement> checkboxes = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        signup.professionalExperienceCheckbox));

        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }
    }

    //click on next
    public void clickNext() {
        wait.until(ExpectedConditions.elementToBeClickable(signup.nextButton))
                .click();
    }

    // fill up  Verification and Preferences

    public void enterBusinessRegistrationNumber(String number) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                        signup.businessRegistrationNumber))
                .sendKeys(number);
    }

    // Select Preferred Countries
    public void selectPreferredCountries(List<String> country) {
        wait.until(ExpectedConditions.elementToBeClickable(
                signup.preferredCountries)).click();
        for (String countryName : country) {

            By countryOption = By.xpath(
                    "//*[normalize-space()='" + countryName + "']"
            );
            wait.until(ExpectedConditions.elementToBeClickable(countryOption))
                    .click();
        }
    }
    //click on all checkboxes
    public void selectAllCheckbox() {

        List<WebElement> checkboxes = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        signup.verificationPreferenceCheckboxes));

        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }
    }

    //Upload the file
    public void uploadsRequiredDocument() {
        String filePath = System.getProperty("user.dir")
                + "/src/test/resources/testdatafile/automation_dummy_document.pdf";

        WebElement fileInput = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        signup.uploadFile));

        fileInput.sendKeys(filePath);
    }

    //click summit
    public void clicksOnSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(signup.submitButton))
                .click();
    }

    // Verify successful registration
    public void shouldBeSuccessfullyRegistered() {

        wait.until(ExpectedConditions.urlContains("/admin/profile"));
    }

    //Logout the page
    public void clicksOnLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(signup.logoutButton))
                .click();
    }
     // Confirm Logout
     public void confirmsLogout() {

         wait.until(ExpectedConditions.elementToBeClickable(
                 signup.confirmLogout)).click();
     }
    // Verify Logout
    public void shouldBeRedirectedToLoginPage() {

        wait.until(ExpectedConditions.urlContains("login"));
    }
    // Close Browser
    public void closesTheBrowser() {
        driver.quit();
    }

}



