package com.cibernos.transactionshandler.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import com.cibernos.transactionshandler.entities.Account;
import com.cibernos.transactionshandler.entities.Transaction;
import com.cibernos.transactionshandler.model.TransactionInputDTO;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com Transactions Mapper Test
 */
class TransactionMapperImplTest {

	private TransactionMapper transactionMapper = Mappers.getMapper(TransactionMapper.class);

	/**
	 * Test check if mapping from TransactionInputDTO to Transaction entity is
	 * valid: String values are equals, numeric values are property converted and
	 * date is set to now.
	 */
	//@Test
	void transactionMapperTest1() {

		String ibanCode = "ES6621000418401234567891";

		TransactionInputDTO transactionInputDTO = TransactionInputDTO.builder().account_iban(ibanCode).amount("1000.45")
				.description("Testing IBAN 1").fee("1.32").build();
		
		// TODO: Mock 'accountsDao.findAccountByIban' call
		Optional<Transaction> optTransaction = transactionMapper.mapFromTransactionInputDTO(transactionInputDTO);

		assertTrue(optTransaction.isPresent());

		Transaction transaction = optTransaction.get();

		Transaction transactionTestControl1 = Transaction.builder()
				.fk_account(Account.builder().idAccount(1L).accountIban(ibanCode).build()).amount(transaction.getAmount())
				.description(transaction.getDescription()).fee(transaction.getFee()).date(transaction.getDate())
				.build();

		assertEquals(optTransaction.get(), transactionTestControl1);

	}

	/**
	 * Test to check if mapper returns an empty Optional when receives a null
	 * parameter
	 */
	@Test
	void transactionMapperTest2() {

		Optional<Transaction> optTransaction = transactionMapper.mapFromTransactionInputDTO(null);

		assertTrue(optTransaction.isEmpty());

	}

}
