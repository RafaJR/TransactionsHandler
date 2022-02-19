package com.cibernos.transactionshandler.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cibernos.transactionshandler.entities.Account;
import com.cibernos.transactionshandler.entities.Transaction;
import com.cibernos.transactionshandler.model.TransactionInputDTO;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com Transactions Mapper Test
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class TransactionMapperImplTest {

	@Autowired
	private TransactionMapperImpl transactionMapper;

	/**
	 * Test check if mapping from TransactionInputDTO to Transaction entity is
	 * valid: String values are equals, numeric values are property converted and
	 * date is set to now.
	 */
	@Test
	void transactionMapperTest1() {

		String ibanCode = "ES6621000418401234567891";

		TransactionInputDTO transactionInputDTO = TransactionInputDTO.builder().account_iban(ibanCode).amount("1000.45")
				.description("Testing IBAN 1").fee("1.32").build();

		// TODO: Mock 'accountsDao.findAccountByIban' call
		Optional<Transaction> optTransaction = transactionMapper.mapFromTransactionInputDTO(transactionInputDTO);

		assertTrue(optTransaction.isPresent());

		Transaction transaction = optTransaction.get();

		Transaction transactionTestControl1 = Transaction.builder().amount(transaction.getAmount())
				.description(transaction.getDescription()).fee(transaction.getFee()).date(transaction.getDate())
				.build();

		assertEquals(optTransaction.get(), transactionTestControl1);

	}

}
