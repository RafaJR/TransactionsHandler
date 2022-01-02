package com.cibernos.transactionshandler.model;

import javax.validation.constraints.NotNull;

import com.cibernos.transactionshandler.validation.IbanConstraint;

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
	private String account_iban;
	private String amount;
	private String fee;
	private String description;

}
