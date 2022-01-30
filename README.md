# TransactionsHandler
Simple microservice API for bank transactions handling
## Table of Contents
- [Instructions for execution](#instructions-for-execution)
- [Instructions for testing](#instructions-for-testing)


## Instructions for execution

### System requirements
- JDK 1.8 or later version.
- Maven 1.5 or later version.

### Execution
Download source code form Github:
	
	https://github.com/RafaJR/TransactionsHandler.git
Compile the source code using maven.
Execute this command at the project main folder, where the "pom.xml" file is set.

	mvn clean install
Execute the generated ".jar" java executable package at the "target" folder of the project.
Use this command at the "target" folder:

	 java -jar TransactionsHandler-0.0.1-SNAPSHOT.jar
So when the application charge process ends you will can use any "Http" client, like "Postman", to try the "API" end-points.
#### End-points
These are the functionalities or end-points offered by the API
##### Save Transaction
Enable to create a new transaction and save it at the system database.

Http Request description:

- URL:
	
	http://localhost:8081/transactions/saveTransaction
- Body:
	Json input with fields:
	
	- [Optional]reference: if indicated, the transaction is updated. Else, a new transaction is created.
		* Constraints:
			- Must be an integer number.
	- [Mandatory]account_iban: The IBAN number of the account where the transaction has happened.		
		* Constraints:2* 4* 4* 2* 10*
			- It must me introduced with a valid Spanish IBAN number format:
				In Spain, the IBAN has 24 digits and is made up of 2 country digits (ES), 2 control digits,
				4 digits to indicate the bank entity, 4 digits to indicate the account branch, 2 more control digits
				and 10 digits to indicate the bank account number.
				Font:
					https://es.wikipedia.org/wiki/International_Bank_Account_Number
					https://www.iban.es/estructura-del-iban.html
			- The digits groups can stay separated by blank space or not.
			Valid IBAN input examples:
				ES00 0000 0000 00 0000000000
				ES000000 0000 00 0000000000
				ES0000000000 00 0000000000
				ES000000000000 0000000000
				ES0000000000000000000000			
	- [Optional]date: it's set to the time that the transaction is created at, so it's not expected to be introduced.
	
	- [Mandatory]amount: the money amount that the transaction has moved.
		* Constraints:
			- Must be a real number with two decimals or with no decimals.
			- Decimal separator must be ".".
		Valid "amount" input examples:
			1500
			10.50
	- [Optional]fee: fee that will be deducted from the amount.
		If not indicated, it will be set to "0".
		* Constraints:
			- Must be a real positive number with two decimals or with no decimals.
			- Decimal separator must be ".".
			- Must be minor than the transaction amount.
		Valid "fee" input examples for a "100" transaction amount:
			10.50
			12.15
	- [Optional]description: the description of the transaction.
		* Constraints:
			- It must no contain more than 150 characters.
	General Constraint:
		If the transaction is negative, the account must have balance enough to support it, taking care that the fee must be deduced too.

Examples of valid transaction inputs for saving:

		{
		    "account_iban":"ES0000000000000000000000",
		    "amount":"1000000.50",
		    "fee":"20.58",
		    "description":"Simple transaction"
		}
		
		{
		    "account_iban":"ES00 0000 0000 00 0000000000",
		    "amount":"-100",
		    "fee":"20.58",
		    "description":"Deduction transaction"
		}

## Instructions for testing