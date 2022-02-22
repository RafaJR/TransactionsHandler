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
	 *                            positive and minor than it's amount absolute value
	 *                            (positive value of amount)
	 */
	@Override
	public boolean isValid(TransactionInputDTO transactionInputDTO, ConstraintValidatorContext context) {

		// If fee is a null value, it will be set to 0
		Double fee = transactionInputDTO.getFee() != null ? Double.valueOf(transactionInputDTO.getFee()) : 0;

		// fee must be set as a positive value
		boolean isValidFee = fee >= 0;

		if (isValidFee) {

			Double absAmount = Double.valueOf(transactionInputDTO.getAmount());
			absAmount = absAmount < 0 ? absAmount * -1 : absAmount;
			
			// Fee must me minor than the transaction amount absolute value
			isValidFee = fee < absAmount;
		}

		return isValidFee;

	}

}