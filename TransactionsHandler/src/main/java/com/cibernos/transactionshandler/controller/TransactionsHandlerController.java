package com.cibernos.transactionshandler.controller;

import javax.validation.Valid;
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
import com.cibernos.transactionshandler.exceptions.InsufficienBalanceForTransaction;
import com.cibernos.transactionshandler.model.AccountInputDTO;
import com.cibernos.transactionshandler.model.TransactionInputDTO;
import com.cibernos.transactionshandler.service.TransactionService;
import com.cibernos.transactionshandler.validation.UnfasibleTransactionConstraint;

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
			@RequestBody @NotNull(message = TransactionsHandlerConstants.NOT_NULL_TRANSACTION) @Valid @UnfasibleTransactionConstraint TransactionInputDTO transactionInput) {

		log.info(TransactionsHandlerConstants.SAVING_TRANSACTION_CALL_STARTED, transactionInput.toString());

		boolean success = false;

		try {
			success = transactionService.saveTransaction(transactionInput);
		} catch (InsufficienBalanceForTransaction e) {
			e.printStackTrace();
		}

		return success
				? new ResponseEntity<String>(
						String.format(TransactionsHandlerConstants.TRANSACTION_SUCCESSFULLY_SAVED_RESPONSE,
								transactionInput.toString()),
						HttpStatus.OK)
				: new ResponseEntity<String>(
						String.format(TransactionsHandlerConstants.TRANSACTION_SAVING_FAILED_RESPONSE,
								transactionInput.toString()),
						HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping("/saveAccount")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> saveAccount(@NotNull @Valid AccountInputDTO accountInputDTO) {
		
		log.info(TransactionsHandlerConstants.SAVING_ACCOUNT_CALL_STARTED, accountInputDTO.toString());

		boolean success = false;
		
		return null;
	}
	
	@GetMapping("/getTransactionStatus")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> getTransactionStatus(@NotNull Long treference) {

		log.info("Query for transaction status with reference '{}' started.", treference);

		return new ResponseEntity("Started!.", HttpStatus.OK);

	}

}
