Feature: Authorized Partner Signup

  As a new user
  I want to register as an authorized partner
  So that I can access the partner platform

  Background:
    Given user launches the authorized partner website
    When user clicks on Login
    And user clicks on Sign Up
    And user clicks on checkbox of Terms and conditions
    And user clicks on Continue

  Scenario: Successful authorized partner signup
    Given user connect mail server using email and password
    And user enters registration details
      | firstname        | Nishant                     |
      | lastname         | Bhattarai                   |
      | email_address    | testgmail12223333+random@gmail.com |
      | password         | Test@1234                   |
      | confirm_password | Test@1234                   |
      | phone_number     | randomNumber                |
    And user clicks on Next
    And user retrieves OTP from email and summit it
    And user clicks on Verify Code
    And user enters agency details
      | Name           | ABC Agency         |
      | Role_in_Agency | Manager            |
      | Email_Address  | agency@example.com |
      | Website        | nepop.com          |
      | Address        | Kathmandu          |
    And user selects region of operation
      | Nepal   |
      | United Kingdom |
    And user click on next
    And user enters professional experience
      | Years_of_Experience                   | 2 years     |
      | Number_of_Students_Recruited_Annually | 50        |
      | Focus_Area                            | Education |
      | Success_Metrics                       | 50%       |
    And user click on all checkbox
    And User click on Next
    And user enter business registration number
      | Business_Registration_Number | 78965478 |
    And user select preferred countries
      | India     |
      | Australia |
    And user select on all checkbox
    And user uploads required document
    And user clicks on Submit
    Then user should be successfully registered
    When user click on logout
    And user confirms logout
    Then user should be redirected to Login page
    And user closes the browser