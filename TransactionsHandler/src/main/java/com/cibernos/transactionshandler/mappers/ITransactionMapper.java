package com.cibernos.transactionshandler.mappers;

import java.util.Optional;

import org.mapstruct.Mapper;

import com.cibernos.transactionshandler.entities.Account;
import com.cibernos.transactionshandler.entities.Transaction;
import com.cibernos.transactionshandler.model.AccountInputDTO;
import com.cibernos.transactionshandler.model.TransactionInputDTO;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com Transactions Mapper Interface
 */
@Mapper
public interface ITransactionMapper {

	Optional<Transaction> mapFromTransactionInputDTO(TransactionInputDTO transactionInputDTO);
	Optional<Account> mapAccountFromAccountInputDTO(AccountInputDTO accountInputDTO);

}
