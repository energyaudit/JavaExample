# QA Framework

This project is used for API/front-end testing of applications. It uses Selenium/RestAssured Framework_ in order to simulate API/front-end tests, as per test specifications.

## How to use

Clone this repository using a git client as a first step, build project

### Running Locally UI test
- All browser-related tests are runnable whatever you laptop operation system mac or windows.  If the test case is web browser-related and your pc  is windows please use the code line :
  driver=new BrowserSetup().Setup("chrome","windows");
  If mac  then comments out above line choose following:
  driver=new BrowserSetup().Setup("chrome","mac");
 
### Running Locally API test
- For test use :http://localhost:3000.Splease install JSON Server:_**npm install -g json-server**_.tart JSON Server:json-server --watch db.json
  This command will create an initial db.jon in any current folder you running now.
- For test use :http://localhost:7000,please install JSON Server:_**npm install -g json-server**_. It’s a great tool to create mock JSON based web services, all it requires is a sample JSON file. It automatically creates GET, POST, PUT, DELETE API endpoints for us. 
- **json-server --port 7000 --routes routes.json --watch db1.json ** 
- For test use :http://localhost:8080,please install JSON Server:_**npm install -g json-server**_. It’s a great tool to create mock JSON based web services, all it requires is a sample JSON file. It automatically creates GET, POST, PUT, DELETE API endpoints for us. 
- **json-server --port 8080 --routes routes.json --watch db.json ** 
- or you can download from my repo: https://github.com/energyaudit/typicodeJsonSeverBilly  then start server by json-server --port 8080 --routes routes.json --watch db.json