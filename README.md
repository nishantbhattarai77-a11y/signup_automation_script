## 1. Prerequisites

Install the following software before running the project:

- Java JDK 26
- IntelliJ IDEA
- Apache Maven
- Google Chrome Browser
- Git

## 2. Technology Stack

The project uses the following technologies and dependencies:

| Technology | Version |
|---|---|
| Java | 26 |
| Selenium WebDriver | 4.43.0 |
| Cucumber Java | 7.33.0 |
| Cucumber TestNG | 7.32.0 |
| TestNG | 7.11.0 |
| WebDriverManager | 6.2.0 |
| dotenv-java | 3.2.0 |
| Jakarta Mail | 2.0.3 |
| Jsoup | 1.10.2 |

## 3. Project Setup

Follow the steps below to set up and run the project.

### Step 1: Clone the Repository

Open your terminal and execute the following command:

```bash
git clone https://github.com/nishantbhattarai77-a11y/signup_automation_script.git
```

### Step 2: Open the Project

- Open IntelliJ IDEA.
- Select **Open**.
- Navigate to the cloned `signup_automation_script` folder.
- Open the project.

### Step 3: Configure Java and Maven

- Make sure Java JDK 26 is installed.
- Configure JDK 26 as the Project SDK in IntelliJ IDEA.
- Ensure Maven is properly configured.

### Step 4: Install Dependencies

Open the terminal in the project root directory and execute:

```bash
mvn clean install
```

This command compiles the project, downloads the required dependencies, and prepares the project for test execution.

### Step 5: Run the Automation Tests

Execute the following command:

```bash
mvn test
```

This command runs the configured automation test cases.

## 4. Environment Configuration

The automation script uses environment variables to access the test email account and retrieve OTP verification codes automatically.

### Step 1: Create a `.env` File

Create a file named `.env` in the project root directory.

### Step 2: Configure Environment Variables

Add the following variables to your `.env` file:

```env
EMAIL_USERNAME=your_email@gmail.com
EMAIL_APP_PASSWORD=your_email_app_password
OTP_EMAIL_SENDER=sender_email
OTP_EMAIL_SUBJECT=OTP_email_subject
HOST_IMAP_HOST=imap.gmail.com
```

### Security Note

- Use a dedicated test email account for automation.
- Never upload your actual email password or sensitive credentials to GitHub.
- Add `.env` to your `.gitignore` file to prevent accidental commits.
- Share a `.env.example` file with placeholder values if other users need to configure the project.



