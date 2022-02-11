package com.cibernos.transactionshandler.mappers;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.cibernos.transactionshandler.constants.TransactionsHandlerConstants;
import com.cibernos.transactionshandler.entities.Account;
import com.cibernos.transactionshandler.entities.Transaction;
import com.cibernos.transactionshandler.model.AccountInputDTO;
import com.cibernos.transactionshandler.model.TransactionInputDTO;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com Transactions Mapper Implementation
 */
@Component
public class TransactionMapperImpl implements ITransactionMapper {

	/**
	 * @param TransactionInputDTO
	 * @return Optional<Transaction> Mapping from TransactionInputDTO to Transaction
	 *         entity following these special rules: - The reference is an database
	 *         generated Id. - The data of the entity is updated to right now. - The
	 *         numeric values must be mapped form 'String' to 'Double' - The rest of
	 *         the entity's values ​​are set equal to their counterpart values
	 *         ​​from the input.
	 * 
	 */
	@Override
	public Optional<Transaction> mapFromTransactionInputDTO(TransactionInputDTO transactionInputDTO) {

		if (transactionInputDTO != null) {

			// Setting the fee to 0 if it's null.
			Double fee = transactionInputDTO.getFee() != null ? Double.valueOf(transactionInputDTO.getFee()) : 0D;

			return Optional.of(Transaction.builder().amount(Double.valueOf(transactionInputDTO.getAmount()))
					.description(transactionInputDTO.getDescription()).fee(fee).date(LocalDateTime.now()).build());

		} else {
			return Optional.empty();
		}

	}

	/**
	 * @param AccountInputDTO
	 * @return Optional<Account> Mapping from AccountInputDTO to Account
	 */
	@Override
	public Optional<Account> mapAccountFromAccountInputDTO(AccountInputDTO accountInputDTO) {

		if (accountInputDTO != null) {

			return Optional.of(Account.builder()
					.accountIban(accountInputDTO.getAccount_iban().replace(TransactionsHandlerConstants.SPACE,
							TransactionsHandlerConstants.BLANK))
					.balance(Double.valueOf(accountInputDTO.getBalance())).build());

		} else {
			return Optional.empty();
		}
	}

}
