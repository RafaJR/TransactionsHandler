#TransactionsHandler
Simple microservice API for bank transactions handling
##Table of Contents
- [Instructions for execution and testing](#instructions-for-execution-and-testing)
- [](#)


##Instructions for execution and testing
-
###System requirements
- JDK 1.8 or later version.
- Maven 1.5 or later version.

###Execution
Download source code form Githut:
	
	https://github.com/RafaJR/TransactionsHandler.git
Compile the source code using maven.
Execute this command at the project main folder, where the "pom.xml" file is set.

	mvn clean install
Execute the generated ".jar" java executable package at the "target" folder of the project.
Use this command at the "target" folder:

	 java -jar TransactionsHandler-0.0.1-SNAPSHOT.jar
So when the application charge process ends you will can use any "Http" client, like "Postman", to try the "API" end-points.
####End-points
These are the functionalities or end-points offered by the API
#####Save Transaction
Enable to create a new transaction and save it at the system database.
Http Request description:
	URL:
	
	http://localhost:8081/transactions/saveTransaction

