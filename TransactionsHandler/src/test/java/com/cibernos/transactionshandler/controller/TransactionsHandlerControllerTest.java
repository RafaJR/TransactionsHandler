package com.cibernos.transactionshandler.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.cibernos.transactionshandler.model.TransactionInputDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class TransactionsHandlerControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void saveTransactionForAValidTransactionTest() throws Exception {

		TransactionInputDTO transactionInputDTO = TransactionInputDTO.builder()
				.account_iban("ES00 0000 0000 00 0000000001").amount("0.50").fee("0.15")
				.description("Valid transaction for testing").build();

		mockMvc.perform(post("/transactions/saveTransaction").contentType("application/json")
				.content(objectMapper.writeValueAsString(transactionInputDTO))).andExpect(status().isOk());

//		assertTrue(true);
	}

}
