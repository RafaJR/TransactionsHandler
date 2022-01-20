package com.cibernos.transactionshandler.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com Account entity for DB
 */

@Entity(name = "Account")
@Table(name = "T_ACCOUNT")

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ACCOUNT")
	private Long idAccount;
	@Column(name = "ACCOUNT_IBAN", unique = true, nullable = false)
	private String accountIban;
	@OneToMany(mappedBy = "fk_account", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Transaction> listTransaction = new ArrayList<Transaction>();

}
