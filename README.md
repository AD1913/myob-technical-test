# myob-technical-test

This application is a java spring boot application which exposes a /v1/hello end point to display "Hello World"

Health and metadata information are exposed via /v1/health and /info end points. All the dependencies required for this
project are packages using maven.

Controller classes are the entry points for the Rest API's which internally invoke methods from service classes to 
return the required response. DAO classes are not included here since there is no dynamic data being populated.

#  Build and Run process

1. Clone the code from this GitHub repo
2. Use the maven wrapper classes provided with this repo to build and run the application by following the below
   mentioned steps
   
   a. cd into the root directory of the project
   b. use maven wrappers to execute the build process. mvnw is to be used for linux or macos and mvnw.cmd can be used for 
      windows machines.
   c. Run the command "./mvnw clean install" to build and generate output jars into respective target folders.
   d. Run "./mvnw spring-boot:run" to run the application.
   
3. Unit tests can be executed using "./mvnw test -Dtest=TechnicalTestApplicationTests".
   Unit tests does not cover the actual API call.
   
4. Integration tests cover the actual API call for /hello and it can be executed using 
   "./mvnw test -Dtest=TechnicalTestApplicationTestsIT"
   

# API's

Following are the API's that can be verified as part of this project.

## Hello API - GET

### Request

	curl http://localhost:8080/myobdemo/v1/hello
	
### Response
	
	{
   		"status":"Success",
   		"data":{
      		"response":"Hello World"
  	 	}
	}
 
 ## Health API - GET
 
 Health API can be obtained from the actuator health API exposed but a custom health API has been developed for the 
 showcase
 
 ### Request
 
 	curl http://localhost:8080/myobdemo/v1/health
 	
 ### Response
 
 	{
   		"status":"UP",
  		 "details":{
     		 "HTTP Status Code":200
   		}
	}
	
## Metadata Info - GET

Metadata info is obtained from the below API. This is using actuator's /info end point but configured to return required
values

### Request
	
	curl http://localhost:8080/myobdemo/info
	
### Response

	{
	   	"myobdemoapp":{
		      "name":"technical-test",
		      "version":"1.0.0",
		      "description":"pre-interview technical test"
	   	}
	}
	

# Risks Associated

All the dependencies within maven pom.xml uses the latest available dependencies from maven central. Any change in one of the
latest dependencies might affect the application. In an ideal scenario, specific versioned dependencies can be used.

Security has not been implemented for this application and it can be accessed by anyone. Certificates has to be implemented
and API's need to be exposed using https. To make it more secure, either Mutual authentication with connecting applications
 or OAuth can be implemented.

There are no environment specific variables in the current application, hence the properties specified in application.properties
would be similar to all the environments. Environment specific variables need to be externalized and obtained during runtime.


# Branching Strategy

There are 3 branches master, develop and feature branches created for this project.

All the new development features can be developed using a feature branch. Every new jira story can be associated with a 
new feature branch. 

Once the changes in feature branch are completed, these can be merged back to develop branch. Develop branch should 
always be in running status. Any tests on the application should always be performed in the feature branches. 

Release branches can be created out of develop branches when the final version of the code required for the release is present
in the develop branch.

Release branch deployed into production can be safely merged back to master as soon as the deployments are completed.

This is a high level view of the branching strategy and more scenarios would be involved during the actual execution.
