package com.cibernos.transactionshandler;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.cibernos.transactionshandler.constants.TransactionsHandlerConstants;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com Application load listener to prepare
 *        initial data for testing.
 */
@Slf4j
@Component
public class ApplicationStartUp implements ApplicationListener<ApplicationReadyEvent> {

	/**
	 * @param event Many Accounts load on DB for transaction handling & testing
	 */
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {

		log.info(TransactionsHandlerConstants.TRANSACTIONS_HANDLER_READY);		

	}

}
