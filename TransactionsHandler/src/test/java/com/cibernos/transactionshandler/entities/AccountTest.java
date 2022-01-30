package com.cibernos.transactionshandler.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.cibernos.transactionshandler.exceptions.InsufficienBalanceForTransaction;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com Test of recalculation & set method for
 *        the account when it's receives a new transaction.
 */
class AccountTest {

	private static final String INSUFFICENT_BALANCE_FOR_TRANSACTION = "The account balance '%s' is insufficent for the transaction '%s'.";
	private static final String IBAN = "ES0000000000000000000001";
	private static final Double BALANCE = 1000D;

	/**
	 * @throws InsufficienBalanceForTransaction Test for account balance update due
	 *                                         to a valid positive transaction.
	 */
	@Test
	void setBalanceTestValidPositiveTransaction() throws InsufficienBalanceForTransaction {

		Account account = Account.builder().accountIban(IBAN).balance(BALANCE).build();

		Transaction transaction = Transaction.builder().amount(10D).fee(1D).fk_account(account).build();

		account.setBalance(transaction);

		assertTrue(account.getBalance() == 1009D);
	}

	/**
	 * @throws InsufficienBalanceForTransaction Test for account balance update due
	 *                                         to a valid positive transaction with
	 *                                         no fee
	 */
	@Test
	void setBalanceTestValidPositiveTransactionWithNoFee() throws InsufficienBalanceForTransaction {

		Account account = Account.builder().accountIban(IBAN).balance(BALANCE).build();

		Transaction transaction = Transaction.builder().amount(10D).fk_account(account).build();

		account.setBalance(transaction);

		assertTrue(account.getBalance() == 1010D);
	}

	/**
	 * @throws InsufficienBalanceForTransaction Test for account balance update due
	 *                                         to a valid negative transaction.
	 */
	@Test
	void setBalanceTestValidNegativeTransaction() throws InsufficienBalanceForTransaction {

		Account account = Account.builder().accountIban(IBAN).balance(BALANCE).build();

		Transaction transaction = Transaction.builder().amount(-10D).fee(1D).fk_account(account).build();

		account.setBalance(transaction);

		assertTrue(account.getBalance() == 989D);
	}

	/**
	 * @throws InsufficienBalanceForTransaction Test for account balance update due
	 *                                         to a valid negative transaction with
	 *                                         no fee
	 */
	@Test
	void setBalanceTestValidNegativeTransactionWithNoFee() throws InsufficienBalanceForTransaction {

		Account account = Account.builder().accountIban(IBAN).balance(BALANCE).build();

		Transaction transaction = Transaction.builder().amount(-10D).fk_account(account).build();

		account.setBalance(transaction);

		assertTrue(account.getBalance() == 990D);
	}

	/**
	 * @throws InsufficienBalanceForTransaction Test to check exception thrown
	 *                                         because the account does not have
	 *                                         balance enough for the transaction.
	 */
	@Test()
	void setBalanceTestNotValidNegativeTransaction() throws InsufficienBalanceForTransaction {

		Account account = Account.builder().accountIban(IBAN).balance(BALANCE).build();

		Transaction transaction = Transaction.builder().amount(-980D).fee(21D).fk_account(account).build();

		InsufficienBalanceForTransaction insufficienBalanceForTransaction = assertThrows(
				InsufficienBalanceForTransaction.class, () -> {
					account.setBalance(transaction);
				});

		assertTrue(
				insufficienBalanceForTransaction.getMessage().equals(String.format(INSUFFICENT_BALANCE_FOR_TRANSACTION,
						String.format("%1$,.2f", account.getBalance()), transaction.toString())));

	}

	/**
	 * @throws InsufficienBalanceForTransaction Test to check exception thrown
	 *                                         because the account does not have
	 *                                         balance enough for the transaction
	 *                                         even thought no fee is applied.
	 */
	@Test()
	void setBalanceTestNotValidNegativeTransactionWithNoFee() throws InsufficienBalanceForTransaction {

		Account account = Account.builder().accountIban(IBAN).balance(BALANCE).build();

		Transaction transaction = Transaction.builder().amount(-1001D).fk_account(account).build();

		InsufficienBalanceForTransaction insufficienBalanceForTransaction = assertThrows(
				InsufficienBalanceForTransaction.class, () -> {
					account.setBalance(transaction);
				});

		assertTrue(
				insufficienBalanceForTransaction.getMessage().equals(String.format(INSUFFICENT_BALANCE_FOR_TRANSACTION,
						String.format("%1$,.2f", account.getBalance()), transaction.toString())));

	}

}
