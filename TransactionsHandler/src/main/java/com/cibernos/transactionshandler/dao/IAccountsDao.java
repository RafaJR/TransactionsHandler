package com.cibernos.transactionshandler.dao;

import org.springframework.data.repository.CrudRepository;

import com.cibernos.transactionshandler.entities.Account;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com Account DAO Interface
 */

public interface IAccountsDao extends CrudRepository<Account, Long> {
	
	public Account findAccountByAccountIban(String iban);

}
