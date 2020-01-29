# SeleniumFrameworkCodeChallengeAK

This repository contains [Selenium](http://seleniumhq.org/) tests for the online calculator [https://www.online-calculator.com/full-screen-calculator/].

## Dependencies

1. Make sure you have [Java](http://www.java.com/) installed on your system, if not follow the vendor instructions for installing them on your operating system.

2. Upon opening project, please click on "enable auto-import" so all dependencies are imported to the project. 

## Running Tests

The following steps should get you set up for running Selenium tests locally on your machine:

1. Clone this repository to your local machine
2. Import depenecies (available in pom.xml file)
3. Go-to CalculatorFunctionality.java class
4. Click the green button parallel to '@test()' :)

## Approach

The online calculator is embeded in a canvas thus unable to locate any of the elements, a turn around has been made by sending key strokes directly from keyboard (including the clear aka CE button).
At the start of the test we take a screenshot of the canvas and save it as String base64 -> We do our calculations -> then we take another screenshot and save it as String base64 and compare both Strings.
Case comparison returns false (images are different-expected), we consider the test as pass, else fail.

### Browsers

Compatible with:

* FF
* CHROME


## Reading Logs

Most tests write logs and take screenshots while they run which provide further information about what happened if they failed. These files reside in the `./report` directory and can be viewed locally in your browser by navigating to that folder.
