package com.cibernos.transactionshandler.constants;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com General constants for the API.
 */

public class TransactionsHandlerConstants {

	// Process trace messages
	public static final String SAVING_TRANSACTION = "A new transaction is being saved: '{}'.";
	public static final String SAVING_TRANSACTION_SERVICE_STARTED = "The service to save the transaction '{}' has started.";
	public static final String INPUT_TO_ENTITY_TRANSACTION_SUCCESS = "The input transaction '{}' has been successfully mapped to entity transaction '{}'.";
	public static final String INPUT_TO_ENTITY_TRANSACTION_FAILED = "An error happened when trying to map the input transaction '{}' to entity transaction.";
	public static final String TRANSACTION_SUCCESSFULLY_SAVED = "The transaction '{}' has been successfully saved.";
	public static final String TRANSACTION_SAVING_FAILED = "An error happened when trying to save the transaction '{}'.";
	public static final String TRANSACTION_SUCCESSFULLY_SAVED_RESPONSE = "The transaction '%s' has been successfully saved.";
	public static final String TRANSACTION_SAVING_FAILED_RESPONSE = "An error happened when trying to save the transaction '%s'.";
	public static final String SAVING_TRANSACTION_CALL_STARTED = "Endpoint call to save transaction '{}' done.";
	
	// Input constraints messages
	public static final String NOT_NULL_TRANSACTION = "The transaction to save can't be null.";

}
