package com.cibernos.transactionshandler.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.cibernos.transactionshandler.model.TransactionInputDTO;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com Implementation for Fee field validation
 */
public class FeeValidator implements ConstraintValidator<FeeConstraint, TransactionInputDTO> {

	/**
	 * @param TransactionInputDTO Method to validate that the transaction fee is
	 *                            minor than it's amount
	 */
	@Override
	public boolean isValid(TransactionInputDTO transactionInputDTO, ConstraintValidatorContext context) {

		return Double.valueOf(transactionInputDTO.getFee()) < Double.valueOf(transactionInputDTO.getAmount());
	}

}