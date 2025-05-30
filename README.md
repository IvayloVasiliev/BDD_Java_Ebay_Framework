# BDD_Java_Ebay_Framework

## Overview
BDD_Java_Ebay_Framework is a Behavior-Driven Development (BDD) testing framework designed automation testing. It leverages **Cucumber**, **TestNG**, and **Selenium** to provide a structured and efficient test automation approach. The framework is built using **IntelliJ IDEA** and utilizes **Log4j** for logging. WebDriver version management is handled automatically.

## Tech Stack
- **Java**: v21.0.3
- **Maven**: v3.9.5
- **Cucumber**: v7.18 (For BDD scenarios)
- **TestNG**: v7.8 (For test execution and reporting)
- **Selenium**: v4.2 (For UI automation)
- **Log4j**: (For logging)
- **IntelliJ IDEA**: (Development Environment)


## Features
- **BDD-Based Test Structure**: Uses Gherkin syntax for writing test scenarios.
- **Automatic WebDriver Management**: No need to manually handle WebDriver versions.
- **Parallel Execution**: Supports multi-threaded test execution.
- **Detailed Logging**: Log4j integration for structured logging.
- **Test Reports**: Generates comprehensive reports using TestNG.

## Project Structure
```
BDD_MobileBG_Framework/
│-- src/
│   ├── test/
│   │   ├── java/
│   │   │   ├── pages/      # Page Object Model (POM) classes
│   │   │   ├── stepDefinitions/  # Step definitions for Cucumber
│   │   │   ├── runner/          # Cucumber TestNG runners
│   │   ├── resources/
│   │   │   ├── features/   # Cucumber feature files
│   │   │   ├── log4j.properties # Log4j configuration
│-- pom.xml (Maven dependencies)
```

## Installation & Setup
1. **Clone the repository**
   ```sh
   git clonehttps://github.com/IvayloVasiliev/BDD_Java_Ebay_Framework.git
   ```

2. **Install dependencies**
   Ensure that Maven is installed, then run:
   ```sh
   mvn clean install
   ```

3. **Run Tests**
    - Run all tests using Maven:
      ```sh
      mvn test
      ```
    - Run specific tests via TestNG:
      ```sh
      mvn test -DsuiteXmlFile=testng.xml
      ```
    - Execute Cucumber tests via TestNG runner.

## Logging & Reporting
- **Log4j** is used for structured logging.


## Contribution
1. Fork the repository.
2. Create a new branch (`feature-branch`).
3. Commit your changes.
4. Open a pull request.

## License
This project is licensed under the MIT License.

## Contact
For queries, contact: ivailo_vasiliev@hotmail.com


