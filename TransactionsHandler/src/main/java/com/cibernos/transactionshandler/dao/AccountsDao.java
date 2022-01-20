package com.cibernos.transactionshandler.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cibernos.transactionshandler.constants.TransactionsHandlerConstants;
import com.cibernos.transactionshandler.entities.Account;
import com.cibernos.transactionshandler.entities.Transaction;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com Accounts DAO implementation
 */
@Slf4j
@Repository
public class AccountsDao {

	@Autowired
	private IAccountsDao accountsDao;

	/**
	 * @param account
	 * @return (true if success, false in other case) Method to save an account in
	 *         DB.
	 */
	public boolean saveAccount(Account account) {

		log.info(TransactionsHandlerConstants.SAVING_ACCOUNT, account.toString());

		Optional<Account> savedTransaction = Optional.ofNullable(accountsDao.save(account));

		return savedTransaction.isPresent();
	}

	/**
	 * @param iban
	 * @return (true if success, false in other case) Method to get an account by
	 *         it's IBAN code.
	 */
	public Optional<Account> findAccountByIban(String iban) {

		log.info(TransactionsHandlerConstants.ACCOUNT_BY_IBAN_QUERY, iban);

		return Optional.ofNullable(accountsDao.findAccountByAccountIban(iban));
	}

	/**
	 * @param iban
	 * @return true if any account with the IBAN code indicated by parameter exists
	 *         or false in other case.
	 */
	public boolean existsAccountByAccountIban(String iban) {

		log.info(TransactionsHandlerConstants.CHECKING_ACCOUNT_EXISTENCE, iban);
		return accountsDao.existsAccountByAccountIban(iban);
	}

}
