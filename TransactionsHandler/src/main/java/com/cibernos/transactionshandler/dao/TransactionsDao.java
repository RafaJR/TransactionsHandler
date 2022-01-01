package com.cibernos.transactionshandler.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cibernos.transactionshandler.constants.TransactionsHandlerConstants;
import com.cibernos.transactionshandler.entities.Transaction;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com Transactions DAO implementation
 */
@Slf4j
@Repository
public class TransactionsDao {

	@Autowired
	private ITransactionsDao transactionsDao;

	/**
	 * @param transaction
	 * @return (true if success, false in other case) Method to save a transaction
	 *         in DB.
	 */
	public boolean saveTransaction(Transaction transaction) {

		log.info(TransactionsHandlerConstants.SAVING_TRANSACTION, transaction.toString());

		Optional<Transaction> savedTransaction = Optional.ofNullable(transactionsDao.save(transaction));

		return savedTransaction.isPresent();
	}

}
