# E-Commerce Website Test Automation Suite
## Overview
This project is a comprehensive Test Automation Suite for an e-commerce website. It covers a wide range of test cases, including user authentication, cart management, product verification, and more. The suite is implemented using Selenium WebDriver with Java, TestNG for test execution, Log4j for logging, and Allure for detailed reporting.

## Features
- **Automated Test Cases:** 26 test cases covering core e-commerce functionalities.
- **Test Framework:** Built using Selenium and TestNG for robust test execution.
- **Reporting:** Generates detailed Allure reports for test execution and Log4j logs for debugging.
- **Reusable Components:** Modular design for easy test maintenance and scalability.
- **Cross-Browser Testing:** Configured for execution across multiple browsers.

## Test Cases
1- Register User <br>
2- Login User with correct email and password <br>
3- Login User with incorrect email and password <br>
4- Logout User <br>
5- Register User with existing email <br>
6- Contact Us Form <br>
7- Verify Test Cases Page <br>
8- Verify All Products and Product Detail Page <br>
9- Search Product <br>
10- Verify Subscription on Home Page <br>
11- Verify Subscription on Cart Page <br>
12- Add Products in Cart <br>
13- Verify Product Quantity in Cart <br>
14- Place Order: Register during Checkout <br>
15- Place Order: Register before Checkout <br>
16- Place Order: Login before Checkout <br>
17- Remove Products From Cart <br>
18- View Category Products <br>
19- View & Cart Brand Products <br>
20 Search Products and Verify Cart After Login <br>
21- Add Review on Product <br>
22- Add to Cart from Recommended Items <br>
23- Verify Address Details on Checkout Page <br>
24- Download Invoice After Purchase Order <br>
25- Verify Scroll Up using 'Arrow' Button and Scroll Down Functionality <br>
26- Verify Scroll Up without 'Arrow' Button and Scroll Down Functionality <br>

## Tools & Technologies
- **Programming Language:** Java
- **Automation Framework:** Selenium WebDriver
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
