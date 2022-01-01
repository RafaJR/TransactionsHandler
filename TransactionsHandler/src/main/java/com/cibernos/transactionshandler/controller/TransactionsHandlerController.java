package com.cibernos.transactionshandler.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cibernos.transactionshandler.constants.TransactionsHandlerConstants;
import com.cibernos.transactionshandler.model.TransactionInputDTO;
import com.cibernos.transactionshandler.service.TransactionService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com Main controller for Transactions
 *        Handler
 */
@RestController
@Validated
@RequestMapping("/transactions")
@Slf4j
public class TransactionsHandlerController {

	@Autowired
	private TransactionService transactionService;

	@PostMapping("/saveTransaction")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> saveTransaction(
			@RequestBody @NotNull(message = TransactionsHandlerConstants.NOT_NULL_TRANSACTION) TransactionInputDTO transactionInput) {

		log.info(TransactionsHandlerConstants.SAVING_TRANSACTION_CALL_STARTED, transactionInput.toString());

		boolean success = transactionService.saveTransaction(transactionInput);

		return success
				? new ResponseEntity<String>(String.format(TransactionsHandlerConstants.TRANSACTION_SUCCESSFULLY_SAVED_RESPONSE,
						transactionInput.toString()), HttpStatus.OK)
				: new ResponseEntity<String>(String.format(TransactionsHandlerConstants.TRANSACTION_SAVING_FAILED_RESPONSE,
						transactionInput.toString()), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/getTransactionStatus")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> getTransactionStatus(@NotNull Long treference) {

		log.info("Query for transaction status with reference '{}' started.", treference);

		return new ResponseEntity("Started!.", HttpStatus.OK);

	}

}
