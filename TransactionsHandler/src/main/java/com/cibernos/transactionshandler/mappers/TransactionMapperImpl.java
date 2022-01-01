package com.cibernos.transactionshandler.mappers;

import java.time.LocalDateTime;
import java.util.Optional;

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
	 *         entity
	 */
	@Override
	public Optional<Transaction> mapFromTransactionInputDTO(TransactionInputDTO transactionInputDTO) {

		return transactionInputDTO != null
				? Optional.of(Transaction.builder().account_iban(transactionInputDTO.getAccount_iban())
						.amount(Double.valueOf(transactionInputDTO.getAmount()))
						.description(transactionInputDTO.getDescription())
						.fee(Double.valueOf(transactionInputDTO.getFee())).date(LocalDateTime.now()).build())
				: Optional.empty();
	}

}
