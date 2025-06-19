Employee Onboarding API Automation Framework

The Project

This project automates testing for the **Employee Onboarding API** using Java, RestAssured, and TestNG. The goal is to ensure critical endpoints are fun
working as expected

Technologies Used

| Tool            | Purpose                             |
|-----------------|-------------------------------------|
| Java 17         | Programming language                |
| TestNG          | Test framework                      |
| RestAssured     | HTTP client for API automation      |
| Maven           | Dependency & build management       |
| GitHub Actions  | CI/CD pipeline to auto-run tests    |


Framework Structure

onboarding-api-tests/
├── pom.xml - Project dependencies
├── .github/workflows/api-tests.yml CI/CD GitHub Actions workflow
└── src/
└── test/
├── java/
│ ├── base/
│ │ └── BaseTest.java - Base class to initialize RestAssured
│ └── tests/
│ ├── AccountCreationTest.java
│ ├── LoginTest.java
│ ├── ProfileUpdateTest.java
│ └── DelayTest.java
│ ├── utils/
│ │ └── AuthHelper.java





Covered Scenarios

| Test Case                 | Endpoint               | Method | Status Code |
|--------------------------|------------------------|--------|-------------|
| Account Creation         | /api/users           | POST   | 201         |
| Successful Login         | /api/login           | POST   | 200         |
| Failed Login             | /api/login           | POST   | 400         |
| Profile Update           | /api/users/2         | PUT    | 200         |
| Delayed System Response  | /api/users?delay=3   | GET    | 200         |


Strategy & Approach

1.Design
BaseTest.java has common setup (base URI), reused by all test classes.

2.Test 
- Each class represents one API endpoint and its related tests.
- All tests use try-catch to ensure graceful failure and detailed debug logs.

3.Exception Handling
- Wrapped in try-catch blocks with meaningful error messages.
- Ensures test failure reasons are captured clearly.

4.Assertions
- HTTP status code validation
- Response body field assertions using Hamcrest matchers

5.CI/CD Integration
- GitHub Actions configured to:
  - Checkout repo
  - Install Java 17
  - Run mvn clean test
