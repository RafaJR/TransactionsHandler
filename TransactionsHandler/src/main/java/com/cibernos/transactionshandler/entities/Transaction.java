package com.cibernos.transactionshandler.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com Transaction entity for DB
 */

@Entity
@Table(name = "T_TRANSACTION")

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_REFERENCE")
	private Long reference;
	@Column(name = "ACCOUNT_IBAN")
	private String account_iban;
	@Column(name = "DATE")
	private LocalDateTime date;
	@Column(name = "AMOUNT")
	private Double amount;
	@Column(name = "FEE")
	private Double fee;
	@Column(name = "DESCRIPTION")
	private String description;

}