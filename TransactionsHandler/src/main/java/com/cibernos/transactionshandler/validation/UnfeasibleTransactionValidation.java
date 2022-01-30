package com.cibernos.transactionshandler.validation;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.cibernos.transactionshandler.constants.TransactionsHandlerConstants;
import com.cibernos.transactionshandler.dao.AccountsDao;
import com.cibernos.transactionshandler.entities.Account;
import com.cibernos.transactionshandler.model.TransactionInputDTO;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com Implementation unfeasible transaction
 *        validation
 */
public class UnfeasibleTransactionValidation
		implements ConstraintValidator<UnfasibleTransactionConstraint, TransactionInputDTO> {

	@Autowired
	private AccountsDao accountsDao;

	/**
	 * @return (true if the account has balance enough for the transaction or else
	 *         in any other case)
	 */
	@Override
	public boolean isValid(TransactionInputDTO transactionInputDTO, ConstraintValidatorContext context) {
		
		boolean validTransaction = false;
		
		// Getting the transaction account to check the balance
		Optional<Account> optAccount = accountsDao.findAccountByIban(transactionInputDTO.getAccount_iban()
				.replace(TransactionsHandlerConstants.SPACE, TransactionsHandlerConstants.BLANK));
		
		if(optAccount.isPresent()) {
			
			// Values to calculate the new balance
			Double balance = optAccount.get().getBalance();
			Double amount = Double.valueOf(transactionInputDTO.getAmount());
			Double fee = Double.valueOf(transactionInputDTO.getFee());
			
			// Calculating the new balance to validate the current one
			validTransaction = balance + amount	- (fee != null ? fee : 0L) >= 0;
		}

		return validTransaction;
	}

}