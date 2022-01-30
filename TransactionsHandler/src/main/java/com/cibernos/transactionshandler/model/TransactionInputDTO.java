package com.cibernos.transactionshandler.model;

import javax.validation.constraints.NotNull;

import com.cibernos.transactionshandler.constants.TransactionsHandlerConstants;
import com.cibernos.transactionshandler.validation.DescriptionConstraint;
import com.cibernos.transactionshandler.validation.DoubleValueAsStringConstraint;
import com.cibernos.transactionshandler.validation.IbanConstraint;
import com.cibernos.transactionshandler.validation.IbanSystemConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com Transaction input data
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TransactionInputDTO {

	@NotNull
	@IbanConstraint
	@IbanSystemConstraint
	private String account_iban;
	@NotNull(message = TransactionsHandlerConstants.NOT_NULL_AMOUNT)
	@DoubleValueAsStringConstraint
	private String amount;
	@DoubleValueAsStringConstraint
	private String fee;
	@DescriptionConstraint
	private String description;

}
