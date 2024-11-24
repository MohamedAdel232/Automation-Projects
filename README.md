# Automation Testing Projects

Welcome to the **Automation Testing Projects** repository! This repository showcases a variety of automation testing projects that cover a wide range of applications, including web, desktop, mobile, and APIs. Each project is built using modern tools, frameworks, and best practices to ensure scalability, maintainability, and efficiency.

---

## Table of Contents

1. [Overview](#overview)
2. [Projects](#projects)
   - [1. Website Automation using Selenium WebDriver](https://github.com/MohamedAdel232/Automation-Projects/tree/master/SeleniumProject)
   - [2. Desktop Automation using Appium Windows Driver](https://github.com/MohamedAdel232/Automation-Projects/tree/master/WindowsProject)
   - [3. Website Automation using BDD with Cucumber Framework](https://github.com/MohamedAdel232/Automation-Projects/tree/master/CucumberProject)
   - [4. Mobile Automation using Appium](https://github.com/MohamedAdel232/Automation-Projects/tree/master/AppiumProject)
   - [5. API Testing](#5-api-testing)
3. [Setup and Installation](#setup-and-installation)
4. [Reports and Logs](#reports-and-logs)
5. [Contributing](#contributing)
6. [License](#license)

---

## Overview

This repository contains practical projects built to automate various types of applications. Each project demonstrates the following:

- Comprehensive test coverage for web, desktop, mobile, and API applications.
- Usage of industry-standard tools and frameworks.
- Modular, reusable, and scalable code architecture.
- Emphasis on real-world scenarios to ensure the quality of applications.

---

## Projects

### 1. Website Automation using Selenium WebDriver

This project automates various website functionalities using the powerful Selenium WebDriver. It implements advanced techniques such as the Page Object Model (POM) and integrates various tools for reporting, logging, and custom test handling.

- **Features**:
  - Functional test cases for login, registration, search, and form submission workflows.
  - Utilizes **TestNG** for parameterized tests and flexible test execution.
  - Integrates **Allure Reports** to visualize test execution details.
  - **Log4j** for capturing debug, info, warning, and error logs.
  - Implements **TestNG Listeners** for real-time event handling during test execution.
  - The **Page Object Model** ensures that test code is clean and maintainable.

- **Technology Stack**:
  - **Programming Language**: Java
  - **Frameworks**: Selenium, TestNG
  - **Reports**: Allure Reports
  - **Logging**: Log4j
  - **Design Pattern**: Page Object Model (POM)

- **Use Cases**:
  - Automating e-commerce workflows such as product search, adding to cart, and checkout.
  - Validating form validations for login and signup pages.
  - Cross-browser testing on Chrome and Firefox.

---

### 2. Desktop Automation using Appium Windows Driver

This project automates Windows desktop applications using Appium Windows Driver. It demonstrates automation of desktop applications with reusable components and detailed reporting.

- **Features**:
  - Automated workflows for Windows-based applications such as file management or utility tools.
  - Incorporates **Allure Reports** for interactive reporting.
  - Logs test activities using **Log4j** for better debugging.
  - Custom event handling with **TestNG Listeners**.
  - Modularized design with **Page Object Model (POM)**.

- **Technology Stack**:
  - **Programming Language**: Java
  - **Frameworks**: Appium Windows Driver, TestNG
  - **Reports**: Allure Reports
  - **Logging**: Log4j
  - **Design Pattern**: Page Object Model (POM)

- **Use Cases**:
  - Automating workflows in desktop tools like Notepad or Calculator.
  - Verifying file operations (open, save, edit) in custom desktop applications.

---

### 3. Website Automation using BDD with Cucumber Framework

This project employs a Behavior-Driven Development (BDD) approach to automate website functionalities. It leverages the power of the Cucumber framework and Selenium WebDriver for clear, concise, and user-friendly test scenarios.

- **Features**:
  - Uses **Gherkin Syntax** for writing human-readable test scenarios.
  - Executes scenarios with **Cucumber** and integrates **JUnit** for assertion handling.
  - Generates detailed **HTML Reports** for test results.
  - Organizes code with the **Page Object Model** for modularity.

- **Technology Stack**:
  - **Programming Language**: Java
  - **Frameworks**: Selenium, Cucumber, JUnit
  - **Reports**: HTML Reports
  - **Design Pattern**: Page Object Model (POM)

- **Use Cases**:
  - User-centric scenarios such as login, searching, and adding items to a cart.
  - End-to-end workflows in an e-commerce website.

---

### 4. Mobile Automation using Appium

This project automates mobile applications on Android and iOS devices using Appium. It focuses on comprehensive testing of mobile app functionalities with detailed reporting and logging.

- **Features**:
  - End-to-end automation of mobile app workflows.
  - Integration with **Allure Reports** for rich visual test insights.
  - Uses **Log4j** for structured logging.
  - Implements **TestNG Listeners** for test lifecycle events.
  - Modular architecture with the **Page Object Model**.

- **Technology Stack**:
  - **Programming Language**: Java
  - **Frameworks**: Appium, TestNG
  - **Reports**: Allure Reports
  - **Logging**: Log4j
  - **Design Pattern**: Page Object Model (POM)

- **Use Cases**:
  - Automating mobile app features like login, navigation, and data entry.
  - Testing cross-platform compatibility on Android and iOS.

---

### 5. API Testing

This project focuses on manual and automated API testing using Postman and the REST Assured framework. It also implements serialization and deserialization for complex data structures.

- **Features**:
  - Manual testing with Postman for quick validation of API endpoints.
  - Automated testing with **REST Assured** for scalable API tests.
  - Uses **POJO Classes** for structured data handling.
  - Implements **Cucumber Framework** for BDD-style API testing.
  - Generates **HTML Reports** for test summaries.

- **Technology Stack**:
  - **Tools**: Postman, REST Assured
  - **Frameworks**: Cucumber, JUnit
  - **Design Pattern**: POJO Classes for API data handling

- **Use Cases**:
  - Testing RESTful APIs for GET, POST, PUT, and DELETE requests.
  - Validating JSON and XML responses.

---

## Setup and Installation

### Prerequisites
- Java (JDK 8 or above)
- Maven for dependency management
- Appium Server (for mobile and desktop automation)
- IDE (e.g., IntelliJ IDEA, Eclipse)

### Installation Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/MohamedAdel232/Automation-Projects.git
   cd Automation-Projects
   ```

2. Navigate to the desired project directory.

3. Install dependencies:
   ```bash
   mvn clean install
   ```

4. Run tests:
   ```bash
   mvn test
   ```

---

## Reports and Logs

- **Allure Reports**: For visual and interactive test execution reports. To view, run:
  ```bash
  allure serve target/allure-results
  ```
- **HTML Reports**: Found in the `target` directory for Cucumber-based projects.
- **Logs**: Logs are stored in the `logs` folder for each project.

---

## Contributing

Contributions are welcome! Please fork the repository and open a Pull Request with your changes.

---

Happy Testing! 
