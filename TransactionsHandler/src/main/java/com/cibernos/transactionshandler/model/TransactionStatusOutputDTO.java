package com.cibernos.transactionshandler.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com Data input for transaction status query
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TransactionStatusOutputDTO {

	private String reference;
	private Status status;
	private String amount;
	private String fee;
}