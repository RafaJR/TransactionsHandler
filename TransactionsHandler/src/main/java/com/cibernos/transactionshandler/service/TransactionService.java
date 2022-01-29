package com.cibernos.transactionshandler.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibernos.transactionshandler.constants.TransactionsHandlerConstants;
import com.cibernos.transactionshandler.dao.AccountsDao;
import com.cibernos.transactionshandler.dao.TransactionsDao;
import com.cibernos.transactionshandler.entities.Account;
import com.cibernos.transactionshandler.entities.Transaction;
import com.cibernos.transactionshandler.exceptions.InsufficenBalanceForTransaction;
import com.cibernos.transactionshandler.mappers.TransactionMapper;
import com.cibernos.transactionshandler.model.TransactionInputDTO;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com Transactions Mapper Implementation
 */
@Service
@Slf4j
public class TransactionService implements ITransactionsService {

	private TransactionMapper transactionMapper = Mappers.getMapper(TransactionMapper.class);
	@Autowired
	private TransactionsDao transactionsDao;
	@Autowired
	private AccountsDao accountsDao;

	/**
	 * @param transactionInputDTO
	 * @return (true if success, false in other case) Service method to save a
	 *         transaction in DB.
	 * @throws InsufficenBalanceForTransaction
	 */
	@Override
	@Transactional
	public boolean saveTransaction(TransactionInputDTO transactionInputDTO) throws InsufficenBalanceForTransaction {

		log.info(TransactionsHandlerConstants.SAVING_TRANSACTION_SERVICE_STARTED, transactionInputDTO.toString());

		Transaction transaction = null;
		boolean success = false;

		// Mapping the transaction entity from it's input DTO
		Optional<Transaction> optTransaction = transactionMapper.mapFromTransactionInputDTO(transactionInputDTO);
		// Finding the transaction account
		Optional<Account> optAccount = accountsDao.findAccountByIban(transactionInputDTO.getAccount_iban()
				.replace(TransactionsHandlerConstants.SPACE, TransactionsHandlerConstants.BLANK));

		// Checking the transaction mapping and the account to save the entity
		if (optTransaction.isPresent() && optAccount.isPresent()) {

			// Setting the transaction account and the account new balance.
			transaction = optTransaction.get();
			Account account = optAccount.get();			
			account.setBalance(transaction);
			transaction.setFk_account(account);
			
			log.info(TransactionsHandlerConstants.INPUT_TO_ENTITY_TRANSACTION_SUCCESS, transactionInputDTO.toString(),
					transaction.toString());
			
			// Saving the transaction with it's account
			optTransaction = transactionsDao.saveTransaction(transaction);
			
			// Checking transaction saving process to save the account too. If all it's OK, the entire saving process is successful.
			success = optTransaction.isPresent() && accountsDao.saveAccount(account);

		} else {

			// If any error happens during the mapping process or finding the account, the
			// saving service returns 'false'
			log.error(TransactionsHandlerConstants.INPUT_TO_ENTITY_TRANSACTION_FAILED, transactionInputDTO.toString());
			success = false;
		}

		// Logging the transaction saving process result
		if (success) {
			log.info(TransactionsHandlerConstants.TRANSACTION_SUCCESSFULLY_SAVED, transaction.toString());
		} else {
			log.error(TransactionsHandlerConstants.TRANSACTION_SAVING_FAILED, transaction.toString());
		}

		return success;

	}

}
