package com.cibernos.transactionshandler;

import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.cibernos.transactionshandler.dao.AccountsDao;
import com.cibernos.transactionshandler.entities.Account;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com Application load listener to prepare
 *        initial data for testing.
 */
@Component
public class ApplicationStartUp implements ApplicationListener<ApplicationReadyEvent> {

	@Autowired
	private AccountsDao accountsDao;

	/**
	 * @param event Many Accounts load on DB for transaction handling & testing
	 */
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {

		IntStream.range(1, 20).forEach(n -> accountsDao.saveAccount(
				Account.builder().accountIban(String.format("ES%022d", n)).balance(Double.valueOf(n)).build()));

	}

}
