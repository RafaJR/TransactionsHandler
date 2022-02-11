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
	public static final String SAVING_ACCOUNT_SERVICE_STARTED = "The service to save the account '{}' has started.";
	public static final String INPUT_TO_ENTITY_TRANSACTION_SUCCESS = "The input transaction '{}' has been successfully mapped to entity transaction.";
	public static final String INPUT_TO_ENTITY_TRANSACTION_FAILED = "An error happened when trying to map the input transaction '{}' to entity transaction.";
	public static final String TRANSACTION_SUCCESSFULLY_SAVED = "The transaction '{}' has been successfully saved and its account '{}' has been updated.";
	public static final String TRANSACTION_SAVING_FAILED = "An error happened when trying to save the transaction '{}'.";
	public static final String SAVING_TRANSACTION_CALL_STARTED = "Endpoint call to save transaction '{}' done.";
	public static final String SAVING_ACCOUNT_CALL_STARTED = "Endpoint call to save account '{}' done.";
	public static final String ACCOUNT_BY_IBAN_QUERY = "Throwing query to find the account through its IBAN code '{}'.";
	public static final String CHECKING_ACCOUNT_EXISTENCE = "Checking if account wit IBAN '{}' exists in DB.";

	// http response messages
	public static final String TRANSACTION_SUCCESSFULLY_SAVED_RESPONSE = "The transaction '%s' has been successfully saved.";
	public static final String TRANSACTION_SAVING_FAILED_RESPONSE = "An error happened when trying to save the transaction '%s'.";
	public static final String ACCOUNT_SUCCESSFULLY_SAVED_RESPONSE = "The account '%s' has been successfully saved.";
	public static final String ACCOUNT_SAVING_FAILED_RESPONSE = "An error happened when trying to save the account '%s'.";

	// Input constraints messages
	public static final String NOT_NULL_TRANSACTION = "The transaction to save can't be null.";
	public static final String NOT_NULL_AMOUNT = "The transaction amount to save can't be null.";
	public static final String NOT_NULL_BALANCE = "The account balance to save can't be null.";
	public static final String NOT_NULL_ACCOUNT = "The account to save can't be null.";
	public static final String POSITIVE_ACCOUNT_BALANCE = "The initial account balance must be possitive.";
	public static final String IBAN_CODE_NOT_FOUND = "The IBAN code of the transaction could not be fount in system.";
	public static final String IBAN_CODE_FORMAT = "The IBAN for a bank account is made up of two capital letters and twenty numeric characters.";
	public static final String TRANSACTION_LESS_THAN_AMOUNT = "The transaction fee must be less than it's amount.";
	public static final String MONETARY_CIPHER = "A monetary cipher must be set as a real number with no more than two decimals.";
	public static final String DESCRIPTION_MAX_SIZE = "The transaction description can't no contain more than 150 characters.";
	public static final String UNFEASIBLE_TRANSACTION = "The account has no balance enough for the transaction, so it's unfeasible.";

	// Useful values for data format
	public static final String BLANK = "";
	public static final String SPACE = " ";

}
