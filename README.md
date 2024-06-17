# Rest Assured and TestNG API Automation

This project automates the verification of user tasks using Rest Assured and TestNG. The scenario involves checking that all users from the city `FanCode` have completed more than half of their todo tasks.

## Scenario

- **Given**: User has todo tasks
- **And**: User belongs to the city `FanCode`
- **Then**: User's completed task percentage should be greater than 50%

`FanCode` city can be identified by latitude between `-40` to `5` and longitude between `5` to `100` in the users API.

## Prerequisites

- Java 8 or higher
- Maven
- Git

## Setup

1. Clone the repository:
   ```sh
   git clone https://github.com/SumitPrajap/FanCode.git
   cd FanCode

2. Install the dependencies:

```mvn clean install```

## Running the Tests

To execute the tests, use the following command:

```mvn clean test```


## Files
**TodoController.java,UserController.java,Users.java,Todo.java**
Contains Reusable methods and Provides utility methods for making API calls to fetch users and todos.

**FanCodeUsersTest.java**
Contains the test scenarios for verifying the users' todos completion percentage.


## Dependencies
Ensure the following dependencies are included in your pom.xml:

```
<dependencies>
		<dependency>
			<groupId>org.testng</groupId>
			<artifactId>testng</artifactId>
			<version>6.14.3</version>
		</dependency>
		<dependency>
			<groupId>io.rest-assured</groupId>
			<artifactId>rest-assured</artifactId>
			<version>5.3.0</version>
		</dependency>
		<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-databind</artifactId>
			<version>2.13.1</version> <!-- Replace with the latest version -->
		</dependency>
</dependencies>
  ```

## Test Execution
The test verifies the following:

1. Fetches users from the city FanCode based on latitude and longitude conditions and verifies the status code and response.
2. Checks that all users from FanCode city have completed more than 50% of their todos.


## License
This project is licensed under the MIT License.

This `README.md` file provides comprehensive instructions for setting up and running the tests, including a description of the scenario, project structure, dependencies, and how to generate the test report.
