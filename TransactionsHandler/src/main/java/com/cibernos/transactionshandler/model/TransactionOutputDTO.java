package com.cibernos.transactionshandler.model;

import java.time.LocalDateTime;

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
public class TransactionOutputDTO {

	private String reference;
	private String account_iban;
	private String date;
	private String amount;
	private String fee;
	private String description;

}
