package com.cibernos.transactionshandler.service;

import com.cibernos.transactionshandler.model.TransactionInputDTO;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com Transactions service interface
 */
public interface ITransactionsService {

	/**
	 * @param transactionInputDTO
	 * @return (true if success, false in other case) Service method to save a
	 *         transaction in DB.
	 */
	public boolean saveTransaction(TransactionInputDTO transactionInputDTO);

}
