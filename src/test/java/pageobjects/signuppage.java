package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class signuppage {
    WebDriver driver;

    public signuppage(WebDriver driver) {
        this.driver = driver;
    }

    //locators
    public By loginButton = By.xpath("//p[text()='Login']");
    public  By signupButton = By.xpath("//a[normalize-space()='Sign Up']");
    public By checkboxOfTermsAndConditions = By.xpath("//button[@role='checkbox']");
    public By continueButton = By.xpath("//button[normalize-space()='Continue']");
    public By firstName = By.xpath("//input[@name='firstName']");
    public By lastName = By.xpath("//input[@name='lastName']");
    public By email = By.xpath("//input[@name='email']");
    public By phoneNumber = By.xpath("//input[@name='phoneNumber']");
    public By password = By.xpath("//input[@name='password' and @type='password']");
    public By confirmPassword = By.xpath("//input[@name='confirmPassword' and @type='password']");
    public By nextButton = By.xpath("//button[@type='submit' and text()='Next']");
    public By OTPField = By.xpath("//input[@autocomplete='one-time-code' and @maxlength='6']");
    public By verifyCodeButton = By.xpath("//button[@type='submit' and text()='Verify Code']");
    public By agencyName = By.xpath("//input[@name='agency_name']");
    public By roleInAgency = By.xpath("//input[@name='role_in_agency']");
    public By agencyEmail = By.xpath("//input[@name='agency_email' and @type='email']");
    public By agencyWebsite = By.xpath("//input[@name='agency_website']");
    public By agencyAddress = By.xpath("//input[@name='agency_address']");
    public By regionDropdown = By.xpath("//button[@role='combobox']");
    public By experienceLevelOption(String value) {return By.xpath("//*[@role='option' and normalize-space()='" + value + "']");}
    public By experienceLevelDropdown = By.xpath("//button[@role='combobox' and .//span[contains(text(),'Select Your Experience Level')]]");
    public By studentsRecruited = By.xpath("//input[@name='number_of_students_recruited_annually']");
    public By focusArea = By.xpath("//input[@name='focus_area']");
    public By successMetrics = By.xpath("//input[@name='success_metrics']");
    public By professionalExperienceCheckbox =  By.xpath("//button[@role='checkbox']");
    public By businessRegistrationNumber = By.xpath("//input[@name='business_registration_number']");
    public By preferredCountries = By.xpath("//button[@role='combobox' and .//span[contains(text(),'Select Your Preferred Countries')]]");
    public By verificationPreferenceCheckboxes = By.xpath("//button[@role='checkbox']");
    public By uploadFile = By.xpath("//input[@type='file']");
    public By submitButton = By.xpath("//button[text()='Submit']");
    public By logoutButton = By.xpath("//div[text()='Logout']");
    public By confirmLogout = By.xpath("//button[normalize-space()='Logout']"
    );
}
