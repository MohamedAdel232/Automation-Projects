# Calculator Desktop Application Test Automation Suite
## Overview
This project is a Test Automation Suite for the Windows Calculator desktop application. It focuses on automating basic calculator operations and validating its core functionalities. The suite is implemented using the Appium Windows Driver, Java for scripting, and TestNG for test execution and reporting.
## Features
- **Automated Test Cases:** Covers essential calculator operations such as addition, subtraction, multiplication, and verification of application launch.
- **Test Framework**: Built using Appium Windows Driver with TestNG for efficient test execution.
- **Reusable Components:** Modular and maintainable code structure for scalability.
- **Detailed Reporting:** TestNG provides structured test result reports.

## Test Cases
1- Verify the Calculator application opens successfully. <br>
2- Perform and validate addition of two numbers. <br>
3- Perform and validate subtraction of two numbers. <br>
4- Perform and validate multiplication of two numbers. <br>

## Tools & Technologies
- **Programming Language:** Java
- **Automation Framework:** Appium Windows Driver
- **Test Framework:** TestNG
- **Log4j:** Detailed logs for execution tracking.
- **Allure Reports:** Rich visual reports for test results.
- **Dependency Management:** Maven
- **Build Tool:** Maven

## Prerequisites
1- Java Development Kit (JDK): Version 8 or later <br>
2- Maven: Installed and configured <br>
3- Allure: Installed for report generation <br>
4- Browser Drivers: WebDriver binaries for Chrome, Firefox, etc. <br>
5- IDE: IntelliJ IDEA/Eclipse (recommended) <br>

## Project Structure
```
src/
├── main/
│   └── java/
│       └── com.ecommerce.automation/  # Core framework and utilities
├── test/
│   └── java/
│       └── com.ecommerce.tests/      # Test cases implementation
resources/
├── config.properties                 # Browser and environment configurations
├── log4j.xml                         # Log4j configuration file
reports/
└── allure-results/                   # Allure report files

```
## Contributing
Feel free to fork this repository, make your changes, and submit a pull request. Contributions are welcome!
