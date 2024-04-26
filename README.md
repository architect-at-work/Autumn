# An Overview of the Convention-Based API Automation Testing Framework

The Autumn codebase is a convention-based API automation testing framework, designed to streamline and simplify the
testing process. It is built using Java and leverages the Spring Boot framework and Gradle build tool. The key advantage
of this framework is that it allows Quality Assurance (QA) teams to run tests based on a YAML file, eliminating the need
for repetitive test writing.

## Key Components

### 1. TestCase Class

The `TestCase` class is a data model that encapsulates a test case. It consists of two nested static classes, `Act`
and `Assert`. The `Act` class represents the action to be performed, including the URL, HTTP method, and body of the
request. The `Assert` class represents the expected outcome of the action, including the expected status and body of the
response.

### 2. Response Class

The `Response` class is a data model that represents an HTTP response. It contains the HTTP status code and the response
body.

### 3. HttpRequestExecutor Class

The `HttpRequestExecutor` class is responsible for executing HTTP requests. It uses the `RestTemplate` class from the
Spring framework to send HTTP requests and receive responses. The `execute` method takes a `TestCase` object as an
argument, makes an HTTP request based on the `Act` part of the `TestCase`, and returns a `Response` object.

## Convention-Based Testing

The framework uses a convention-based approach to testing. Test cases are defined in YAML files, following a specific
format. The `TestCase` class is used to load these YAML files. This approach allows QA teams to define a large number of
test cases quickly and efficiently, without having to write repetitive code.

## Data Processing

The framework uses the Jackson library to process both JSON and YAML data. The `ObjectMapper` class from the Jackson
library is used to convert JSON and YAML data to and from `JsonNode` objects.

## Dynamic Test Execution

The framework leverages the dynamic test capabilities of the JUnit library. Each YAML file is treated as a separate
test, allowing for efficient execution and reporting of test results.

## Build Configuration

The build configuration is defined in the `build.gradle` file. The project uses the Spring Boot Gradle plugin, the
Spring Dependency Management Gradle plugin, and the Test Logger Gradle plugin. The project's dependencies include the
Spring Boot Starter, Jackson Databind, Jackson Dataformat YAML, and Lombok.

## Conclusion

The Autumn codebase is a powerful tool for API automation testing.
Its convention-based approach, combined with the dynamic test capabilities of JUnit,
allows QA teams to define and run a large number of tests quickly and efficiently,
without having to write repetitive code. It provides a good example of how to use the Spring Boot framework,
the Jackson library, and the JUnit library in a Java project effectively.