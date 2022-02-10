package com.cibernos.transactionshandler.model;

import javax.validation.constraints.NotNull;

import com.cibernos.transactionshandler.constants.TransactionsHandlerConstants;
import com.cibernos.transactionshandler.validation.DoubleValueAsStringConstraint;
import com.cibernos.transactionshandler.validation.IbanConstraint;

public class AccountInputDTO {
	
	@NotNull
	@IbanConstraint
	private String account_iban;
	@NotNull(message = TransactionsHandlerConstants.NOT_NULL_BALANCE)
	@DoubleValueAsStringConstraint
	private String amount;

}
