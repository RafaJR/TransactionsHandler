package com.cibernos.transactionshandler.dao;

import org.springframework.data.repository.CrudRepository;

import com.cibernos.transactionshandler.entities.Account;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com Account DAO Interface
 */

public interface IAccountsDao extends CrudRepository<Account, Long> {

	/**
	 * @param iban
	 * @return Account Method find an account by it's IBAN code.
	 */
	public Account findAccountByAccountIban(String iban);

	/**
	 * @param iban
	 * @return true if any account with the IBAN code indicated by parameter exists
	 *         or false in other case.
	 */
	public boolean existsAccountByAccountIban(String iban);

}
