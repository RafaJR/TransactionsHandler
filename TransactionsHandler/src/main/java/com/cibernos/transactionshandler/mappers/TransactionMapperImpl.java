package com.cibernos.transactionshandler.mappers;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.mapstruct.Mapper;

import com.cibernos.transactionshandler.entities.Transaction;
import com.cibernos.transactionshandler.model.TransactionInputDTO;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com Transactions Mapper Implementation
 */
public class TransactionMapperImpl implements TransactionMapper {

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
	public Optional<Transaction> mapFromTransactionInputDTO(@NotNull TransactionInputDTO transactionInputDTO) {

		return transactionInputDTO != null
				? Optional.of(Transaction.builder().account_iban(transactionInputDTO.getAccount_iban())
						.amount(Double.valueOf(transactionInputDTO.getAmount()))
						.description(transactionInputDTO.getDescription())
						.fee(Double.valueOf(transactionInputDTO.getFee())).date(LocalDateTime.now()).build())
				: Optional.empty();
	}

}
