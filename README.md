# QA Framework

This project is used for API/front-end testing of applications. It uses Selenium/RestAssured Framework_ in order to simulate API/front-end tests, as per test specifications.

## How to use

Clone this repository using a git client as a first step, build project

### Running Locally
- All browser-related tests are runnable whatever you laptop operation system mac or windows.  If the test case is web browser-related and your pc  is windows please use the code line :
  driver=new BrowserSetup().Setup("chrome","windows");
  If mac  then comments out above line choose following:
  driver=new BrowserSetup().Setup("chrome","mac");