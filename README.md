# myob-technical-test

This application is a java spring boot application which exposes a /v1/hello end point to display "Hello World"

Health and metadata information are exposed via /v1/health and /info end points. All the dependencies required for this
project are packages using maven.

Controller classes are the entry points for the Rest API's which internally invoke methods from service classes to 
return the required response. DAO classes are not included here since there is no dynamic data being populated.

#  Build and Run process for local

## By Cloning the Code
1. Clone the code from this GitHub repo
2. Use the maven wrapper classes provided with this repo to build and run the application by following the below
   mentioned steps
   
   a. cd into the root directory of the project
   
   b. use maven wrappers to execute the build process. mvnw is to be used for linux or macos and mvnw.cmd can be used for 
      windows machines.
      
   c. Run the below command to build and generate output jars into respective target folders.
      ``` 
      	./mvnw clean install
      ```
      
   d. Run either of the below commands to run the application.
   	  ```
   	  	./mvnw spring-boot:run
   	  ```
   
3. Unit tests can be executed using 
   ```
   	./mvnw test -Dtest=TechnicalTestApplicationTests
   ```
   
4. Integration tests cover the actual API call for /hello and it can be executed using 
   ```
   	./mvnw test -Dtest=TechnicalTestApplicationTestsIT
   ```

## By using the published artifact from GitHub

Download relevant jar file myob-demo-1.0.0.jar from https://github.com/akulad/myob-technical-test/packages

Execute the below command from the location where the jar is downloaded
	```
	java -jar myob-demo-1.0.0.jar
	```

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
     		 "statusCode":200
   		}
	}
	
## Metadata Info - GET

Metadata info is obtained from the below API. This is using actuator's /info end point but configured to return required
values

### Request
	
	curl http://localhost:8080/myobdemo/info
	
### Sample Response

	{
	   "myobdemoapp":{
	      "name":"technical-test",
	      "version":"1.0.0",
	      "artifactId":"myob.demo",
	      "description":"pre-interview technical test"
	   },
	   "git":{
	      "branch":"feature/technical-test",
	      "commit":{
	         "id":"83b9457",
	         "time":"2021-02-21T02:42:16Z"
	      }
	   }
	}

# Github Actions

Build pipelines for the above code has been implemented using GitHub Actions. Code related to pipelines are present under 
.github/workflows folder under the project Root folder. Note, that these workflows only create the deployable artifact (a jar file here).
But to test this application, code can be cloned and maven commands can be executed as mentioned in the "Build and Run process for local" section. 

There are 2 workflows created for this application. One is specific 
to feature branches which is for development purposes and usually does not cover all the scenarios present in the release 
version of the workflow. These workflows are triggered as soon as the code commit is done for respective branches.

Apart from the below build pipelines, deploy pipelines can be added which would be specific to deployment environment on 
which the applications would be running on. These pipelines can work based on the artifacts obtained out of the build 
pipelines.

## maven-feature.yml

Usually developers do not want the whole workflow to be executed during the development stages. Stages such as pushing the 
packages are usually not required during the development phase. Hence, it usually is a simpler version of the actual workflow.

This particular workflow does the following actions:
1. Condition to include only feature branches.
2. Checkout the code from repository from feature branch for which the code is committed.
3. Sets up java version
4. Executes maven commands to clean and run the unit tests.

## maven-release.yml

This is the actual version of the workflow which is being used here for develop and master branches. Also, any release branches
would come under this workflow.

This particular workflow does the following actions:
1. Condition to exclude only feature branches.
2. Checkout the code from repository from the branch for which the code is committed.
3. Sets up java version
4. Executes maven commands to clean and run the integration tests.
5. Steps for Code quality scan such as Sonar are written but currently commented out as it requires specific accounts with Sonar Cloud.
   Secrets need to be created under Github secrets and used. In ideal scenarios, these should be enabled to find any bugs during
   the build phase.
6. Final step is to publish the artifact to GitHub packages	

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
new feature branch or a user story branch if a feature consists of multiple user stories. 

Once the changes in feature branch are completed, these can be deployed, tested and then merged back to develop branch. 
Develop branch should always be in working condition. Any tests on the application should always be first performed in the feature branches. 

Release branches can be created out of develop branches when the final version of the code required for the release is present
in the develop branch.

Release branch deployed into production can safely be merged back to master as soon as the deployments are completed.

This is a high level view of the branching strategy and more scenarios such as bugfix or hotfixes would be involved during the actual execution.
