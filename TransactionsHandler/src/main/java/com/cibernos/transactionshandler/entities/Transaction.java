package com.cibernos.transactionshandler.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

@Entity(name = "Transaction")
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
	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "FK_ACCOUNT", nullable = false)
	private Account fk_account;
	@Column(name = "DATE")
	private LocalDateTime date;
	@Column(name = "AMOUNT")
	private Double amount;
	@Column(name = "FEE")
	private Double fee;
	@Column(name = "DESCRIPTION")
	private String description;

}