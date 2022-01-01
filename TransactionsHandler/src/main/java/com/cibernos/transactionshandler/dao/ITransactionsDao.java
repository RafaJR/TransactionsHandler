package com.cibernos.transactionshandler.dao;

import org.springframework.data.repository.CrudRepository;

import com.cibernos.transactionshandler.entities.Transaction;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com Transactions DAO Interface
 */

public interface ITransactionsDao extends CrudRepository<Transaction, Long> {

}
