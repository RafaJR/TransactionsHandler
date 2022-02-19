package com.cibernos.transactionshandler.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.cibernos.transactionshandler.constants.TransactionsHandlerConstants;
import com.cibernos.transactionshandler.constants.TransactionsHandlerTestConstants;
import com.cibernos.transactionshandler.model.TransactionInputDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com TransactionsController end-points test
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@SqlGroup({
    @Sql(scripts = "/accounts.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD),
    @Sql(scripts = "/resetAccounts.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
})
@Slf4j
class TransactionsHandlerControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;

	@BeforeAll
	static void beforeAll() {

		log.info(TransactionsHandlerTestConstants.MAIN_CONTROLLER_TEST_START);

//		IntStream.range(1, 5).forEach(n -> accountsDao.saveAccount(
//				Account.builder().accountIban(String.format("ES%022d", n)).balance(Double.valueOf(n)).build()));
//		
//		log.info(TransactionsHandlerTestConstants.DB_LOAD_FOR_MAIN_CONGTROLER_END);
	}

	@BeforeEach
	void beforeEach(TestInfo testInfo) {

		log.info(TransactionsHandlerTestConstants.MAIN_CONTROLLER_TEST, testInfo.getDisplayName());
	}

	private static final String SAVE_TRANSACTION_FUNCTION = "/transactions/saveTransaction";
	private static final String CONTENT_TYPE = "application/json";

	/**
	 * @throws Exception Test for saving valid transaction due to not existent IBAN
	 * 
	 */
	@Test
	void saveValidPositiveTransaction() throws Exception {

		TransactionInputDTO transactionInputDTO = TransactionInputDTO.builder()
				.account_iban("ES10 1587 8494 12 8901538501").amount("10.50").fee("0.20")
				.description("Valid transaction for testing").build();

		mockMvc.perform(post(SAVE_TRANSACTION_FUNCTION).contentType(CONTENT_TYPE)
				.content(objectMapper.writeValueAsString(transactionInputDTO))).andExpect(status().is2xxSuccessful());

	}
	
	/**
	 * @throws Exception Test for saving a not valid transaction due to not existent
	 *                   IBAN
	 * 
	 */
	@Test
	void saveNotValidTransactionDueToNonExistentIBANTest() throws Exception {

		TransactionInputDTO transactionInputDTO = TransactionInputDTO.builder()
				.account_iban("ES00 0000 0000 00 0000000001").amount("0.50").fee("0.15")
				.description("Not valid transaction due to non existent IBAN test").build();

		String errorMessage = mockMvc
				.perform(post(SAVE_TRANSACTION_FUNCTION).contentType(CONTENT_TYPE)
						.content(objectMapper.writeValueAsString(transactionInputDTO)))
				.andExpect(status().isBadRequest()).andReturn().getResolvedException().getMessage();

		assertTrue(errorMessage.contains(TransactionsHandlerConstants.IBAN_CODE_NOT_FOUND));

	}

}
