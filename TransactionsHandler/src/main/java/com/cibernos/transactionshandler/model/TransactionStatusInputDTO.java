package com.cibernos.transactionshandler.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com Data input for transaction status query
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionStatusInputDTO {

	private String reference;
	private Channel channel;

}
