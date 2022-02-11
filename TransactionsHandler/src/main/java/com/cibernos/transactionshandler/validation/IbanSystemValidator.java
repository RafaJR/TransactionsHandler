package com.cibernos.transactionshandler.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.cibernos.transactionshandler.constants.TransactionsHandlerConstants;
import com.cibernos.transactionshandler.dao.AccountsDao;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com Implementation for IBAN field system
 *        validation
 */
public class IbanSystemValidator implements ConstraintValidator<IbanSystemConstraint, String> {

	@Autowired
	private AccountsDao accountsDao;

	/**
	 * @return (true if IBAN is exists in DB, false in any other case.)
	 */
	@Override
	public boolean isValid(String iban, ConstraintValidatorContext context) {

		return iban != null && accountsDao.existsAccountByAccountIban(
				iban.replace(TransactionsHandlerConstants.SPACE, TransactionsHandlerConstants.BLANK));
	}

}