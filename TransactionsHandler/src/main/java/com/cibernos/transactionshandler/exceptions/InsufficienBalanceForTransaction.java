package com.cibernos.transactionshandler.exceptions;

import com.cibernos.transactionshandler.entities.Account;
import com.cibernos.transactionshandler.entities.Transaction;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com Exception for infeasible transactions.
 */
public class InsufficienBalanceForTransaction extends Exception {

	private static final long serialVersionUID = 8229945091808821687L;
	// Custom Exception message
	private static final String INSUFFICENT_BALANCE_FOR_TRANSACTION = "The account balance '%s' is insufficent for the transaction '%s'.";

	/**
	 * @param errorMessage
	 */
	public InsufficienBalanceForTransaction(Account account, Transaction transaction) {

		super(String.format(INSUFFICENT_BALANCE_FOR_TRANSACTION, String.format("%1$,.2f", account.getBalance()),
				transaction.toString()));
	}
}
