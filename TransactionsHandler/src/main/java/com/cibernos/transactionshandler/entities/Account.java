package com.cibernos.transactionshandler.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.cibernos.transactionshandler.exceptions.InsufficienBalanceForTransaction;

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
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID_ACCOUNT")
	private Long idAccount;
	@Column(name = "ACCOUNT_IBAN", unique = true, nullable = false, length = 24)
	@Size(min = 24, max = 24)
	private String accountIban;
//	@OneToMany(mappedBy = "fk_account", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<Transaction> listTransaction = new ArrayList<Transaction>();
	@Column(name = "BALANCE", nullable = false)
	private Double balance;

	/**
	 * @param transaction
	 * @throws InsufficienBalanceForTransaction Overloaded 'setBalance' method to
	 *                                         calculate the new balance after the
	 *                                         last transaction. Since a transaction
	 *                                         is not allowed to result in a
	 *                                         negative balance, an exception will
	 *                                         be thrown in this case.
	 */
	public void setBalance(Transaction transaction) throws InsufficienBalanceForTransaction {

		Double newBalance = this.balance + transaction.getAmount()
				- (transaction.getFee() != null ? transaction.getFee() : 0L);

		if (newBalance < 0) {
			throw new InsufficienBalanceForTransaction(this, transaction);
		} else {
			this.balance = newBalance;
		}
	}

}
