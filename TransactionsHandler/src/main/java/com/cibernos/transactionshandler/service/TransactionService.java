package com.cibernos.transactionshandler.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibernos.transactionshandler.constants.TransactionsHandlerConstants;
import com.cibernos.transactionshandler.dao.AccountsDao;
import com.cibernos.transactionshandler.dao.TransactionsDao;
import com.cibernos.transactionshandler.entities.Account;
import com.cibernos.transactionshandler.entities.Transaction;
import com.cibernos.transactionshandler.exceptions.InsufficienBalanceForTransaction;
import com.cibernos.transactionshandler.mappers.TransactionMapperImpl;
import com.cibernos.transactionshandler.model.AccountInputDTO;
import com.cibernos.transactionshandler.model.TransactionInputDTO;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com Transactions Mapper Implementation
 */
@Service
@Slf4j
public class TransactionService implements ITransactionsService {

	@Autowired
	private TransactionMapperImpl transactionMapper;
	@Autowired
	private TransactionsDao transactionsDao;
	@Autowired
	private AccountsDao accountsDao;

	/**
	 * @param transactionInputDTO
	 * @return (true if success, false in other case) Service method to save a
	 *         transaction in DB.
	 * @throws InsufficienBalanceForTransaction
	 */
	@Override
	@Transactional
	public boolean saveTransaction(TransactionInputDTO transactionInputDTO) throws InsufficienBalanceForTransaction {

		log.info(TransactionsHandlerConstants.SAVING_TRANSACTION_SERVICE_STARTED, transactionInputDTO.toString());

		Transaction transaction = null;
		Account account = null;
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
			account = optAccount.get();
			account.setBalance(transaction);
			transaction.setFk_account(account);

			log.info(TransactionsHandlerConstants.INPUT_TO_ENTITY_TRANSACTION_SUCCESS, transactionInputDTO.toString(),
					transaction.toString());

			// Saving the transaction with it's account
			optTransaction = transactionsDao.saveTransaction(transaction);

			// Checking transaction saving process to save the account too. If all it's OK,
			// the entire saving process is successful.
			success = optTransaction.isPresent() && accountsDao.saveAccount(account);

		} else {

			// If any error happens during the mapping process or finding the account, the
			// saving service returns 'false'
			log.error(TransactionsHandlerConstants.INPUT_TO_ENTITY_TRANSACTION_FAILED, transactionInputDTO.toString());
			success = false;
		}

		// Logging the transaction saving process result
		if (success) {
			log.info(TransactionsHandlerConstants.TRANSACTION_SUCCESSFULLY_SAVED, transaction.toString(),
					account.toString());
		} else {
			log.error(TransactionsHandlerConstants.TRANSACTION_SAVING_FAILED, transaction.toString());
		}

		return success;

	}

	/**
	 * @param accountInputDto
	 * @return (true if success, false in other case) Service method to save an
	 *         account in DB.
	 */
	@Override
	public boolean saveAccount(AccountInputDTO accountInputDto) {
		
		log.info(TransactionsHandlerConstants.SAVING_ACCOUNT_SERVICE_STARTED, accountInputDto.toString());

		// Mapping the account entity from it's input DTO
		Optional<Account> optAccount = transactionMapper.mapAccountFromAccountInputDTO(accountInputDto);
		
		// Checking account entity and saving it
		return optAccount.isPresent() && accountsDao.saveAccount(optAccount.get());
	}

}
