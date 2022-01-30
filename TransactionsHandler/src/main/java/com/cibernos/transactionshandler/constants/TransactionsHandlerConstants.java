package com.cibernos.transactionshandler.constants;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com General constants for the API.
 */

public class TransactionsHandlerConstants {

	// Process trace messages
	public static final String SAVING_TRANSACTION = "A new transaction is being saved: '{}'.";
	public static final String SAVING_ACCOUNT = "A new account is being saved: '{}'.";
	public static final String SAVING_TRANSACTION_SERVICE_STARTED = "The service to save the transaction '{}' has started.";
	public static final String INPUT_TO_ENTITY_TRANSACTION_SUCCESS = "The input transaction '{}' has been successfully mapped to entity transaction.";
	public static final String INPUT_TO_ENTITY_TRANSACTION_FAILED = "An error happened when trying to map the input transaction '{}' to entity transaction.";
	public static final String TRANSACTION_SUCCESSFULLY_SAVED = "The transaction '{}' has been successfully saved and its account '{}' has been updated.";
	public static final String TRANSACTION_SAVING_FAILED = "An error happened when trying to save the transaction '{}'.";
	public static final String SAVING_TRANSACTION_CALL_STARTED = "Endpoint call to save transaction '{}' done.";
	public static final String ACCOUNT_BY_IBAN_QUERY = "Throwing query to find the account through its IBAN code '{}'.";
	public static final String CHECKING_ACCOUNT_EXISTENCE = "Checking if account wit IBAN '{}' exists in DB.";

	// http response messages
	public static final String TRANSACTION_SUCCESSFULLY_SAVED_RESPONSE = "The transaction '%s' has been successfully saved.";
	public static final String TRANSACTION_SAVING_FAILED_RESPONSE = "An error happened when trying to save the transaction '%s'.";

	// Input constraints messages
	public static final String NOT_NULL_TRANSACTION = "The transaction to save can't be null.";
	public static final String NOT_NULL_AMOUNT = "The transaction amount to save can't be null.";

	// Usefull values for data format
	public static final String BLANK = "";
	public static final String SPACE = " ";

}
