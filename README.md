# OrangeHRM Automation Framework

## Project Overview

This project is an end-to-end QA Automation Framework developed using Java, Selenium WebDriver, TestNG, and Maven following the Page Object Model (POM) design pattern.

The framework automates major functionalities of the OrangeHRM application and includes reporting, screenshots on failure, reusable utilities, and cross-browser support.

---

## Features

- Login with valid credentials
- Logout functionality
- Add Employee
- Search Employee
- Update Employee Details
- Delete Employee
- Update My Info
- Cross Browser Testing (Chrome & Firefox)
- Explicit Waits
- Screenshot on Test Failure
- Extent Reports

---

## Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- WebDriverManager
- Extent Reports
- Git
- GitHub

---

## Project Structure

- **src/main/java**
  - `com.orangehrm.pages`
    - DashboardPage
    - LoginPage
    - MyInfoPage
    - PIMPage
  - `com.orangehrm.utilities`
    - ConfigReader
    - ExcelUtility
    - ExtentManager
    - ScreenshotUtility
    - WaitUtility

- **src/test/java**
  - `com.orangehrm.base`
    - BaseTest
  - `com.orangehrm.tests`
    - LoginTest
    - LogoutTest
    - MyInfoTest
    - PIMTest

- **src/test/resources**
  - config.properties

- **Other Files**
  - pom.xml
  - testng.xml
  - test-output
  - Screenshots
---

## Automated Test Scenarios

### Authentication

- Login with valid credentials
- Logout successfully

### PIM Module

- Add Employee
- Search Employee
- Update Employee Details
- Delete Employee
- Verify successful operations

### My Info Module

- Update Personal Details
- Verify successful update

---

## Framework Highlights

- Page Object Model (POM)
- Reusable Utility Classes
- Explicit Wait Implementation
- External Configuration File
- Screenshot Capture on Failure
- HTML Execution Report using Extent Reports
- Easy Test Execution using TestNG

---

## Reports

After execution, an Extent Report is generated inside the project.

Screenshots are automatically captured whenever a test fails.

---

## Prerequisites

- Java 17+
- Eclipse IDE
- Maven
- Google Chrome / Mozilla Firefox

---

## How to Run

1. Clone the repository

```
git clone https://github.com/darshsherasiya27/OrangeHRM_Automation.git
```

2. Open the project in Eclipse.

3. Update Maven dependencies.

4. Execute the test suite using **testng.xml**.

---

## Author

**Darsh Sherasiya**

QA Automation Engineer

GitHub: https://github.com/darshsherasiya27