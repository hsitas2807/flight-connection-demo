# Rest-Assured Complete Assignment

* [Required Software](#required-software)
* [How to execute the tests](#how-to-execute-the-tests)
   * [Running the test suites](#running-the-test-suites)
   * [Generating the test report](#generating-the-test-report)
* [About the Project Structure](#about-the-project-structure)
* [Libraries](#libraries)

This project was created to test Promotion REST API using Rest-Assured.
It tests the API: 
API Endpoint: http://api.intigral-ott.net/popcorn-api-rs-7.9.10/v1/promotions


## Required software
* Intellij IDEA/Eclipse
* Java JDK 8+
* JDK and Maven installed and Set in your classpath
* Clone/download the samplerestassureddemo project (https://github.com/eliasnogueira/combined-credit-api)

## How to execute the tests
Import the project into Intellij IDEA/Eclipse.
You can open the test class(PromotionApiTest) on `src\test\java\com\intigral\api` and execute it.
Or we can test it using testng.xml as well which is placed inside directory structure "samplerestassureddemo\testng.xml"

We can also run it from command prompt.

### Running the test suites
The test suites can be run directly by your IDE or by command line.
If you run `mvn test` all the tests will execute because it's the regular Maven lifecycle to run all the tests.

### Generating the test report
Pre-requsites to enable IntelliJ report generation:
Form Edit configurations
1. On the “Listeners tab”, Use default listeners should be checked.
2. And Output directory should be set correctly.
3. Check on Use default reporters option which will create test-output folder in your root folder with all reports.
4. In addition to above steps if you still face the issue, you can even add Listener like “EmailableReporter” or “FailedReporter” in the “Run Configurations”, it will generate test-output directory in your workspace.

This project uses testng reports to automatically generate the test report.

You can access the reports at '\samplerestassureddemo\test-output\emailable-report.html'
* Right click on the emailable-report.html, select 'Open in Browser' and the select the browser.

## About the Project Structure

### src/main/java/com/intigral/api

#### pojo
Contains pojo for all the objects present in the API response

#### utils
util package contains promotion API constants, helper and validator class for getting and setting the initial aspects to make the requests using RestAssured.

### src/test/java/com/intigral/api

#### PromotionApiTest
Test that verifies successful and error API response, its validation and presence.

## Libraries
* [RestAssured](http://rest-assured.io/) library to test REST APIs
* [testng]
* [jackson-databind]
