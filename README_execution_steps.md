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
git clone YOUR_GITHUB_REPOSITORY_URL
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

Create a `.env` file in the project root directory.

Add the required email account configuration:

```env
EMAIL_USERNAME=your_email
EMAIL_PASSWORD=your_app_password
```

Use the actual environment variable names defined in the project.

Do not upload the `.env` file or real email credentials to GitHub.

## 6. Test Data

The project uses a dummy PDF file for the document upload functionality.

Location:

```text
src/test/resources/testdata/dummy_upload.pdf
```

The test data file is included in the repository and is used during automation execution.

## 7. Test Execution

**Option 1: Using IntelliJ IDEA**

1. Open the Cucumber TestNG runner class.
2. Right-click the runner class.
3. Select Run.
4. Monitor the execution in the Run console.

**Option 2: Using Maven**

```bash
mvn clean test
```

Make sure the Maven Surefire configuration is set up to execute the Cucumber TestNG runner.

## 8. Test Reports

After execution, check the generated test reports.

The reports provide information about:
- Passed scenarios
- Failed scenarios
- Skipped scenarios
- Execution details

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