package com.cibernos.transactionshandler.model;

import javax.validation.constraints.NotNull;

import com.cibernos.transactionshandler.constants.TransactionsHandlerConstants;
import com.cibernos.transactionshandler.model.TransactionInputDTO.TransactionInputDTOBuilder;
import com.cibernos.transactionshandler.validation.DoubleValueAsStringConstraint;
import com.cibernos.transactionshandler.validation.IbanConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com Account input data
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AccountInputDTO {

	@NotNull
	@IbanConstraint
	private String account_iban;
	@NotNull(message = TransactionsHandlerConstants.NOT_NULL_BALANCE)
	@DoubleValueAsStringConstraint
	private String balance;

}
