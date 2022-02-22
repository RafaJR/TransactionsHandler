package com.cibernos.transactionshandler.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.cibernos.transactionshandler.model.TransactionInputDTO;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com monetary ciphers validation
 *        for "fee" transaction field
 */
class FeeValidatorTest {

	private static final String IBAN = "ES0000000000000000000001";
	private static final String AMOUNT = "10";
	private static final String NEGATIVE_AMOUNT = "-10";

	FeeValidator feeValidator = new FeeValidator();

	/**
	 * Test for monetary ciphers validation. Monetary ciphers (transaction amount,
	 * transactions fee or account balance) must be set as a real number with no
	 * more than two decimals.
	 */
	@Test
	public void isValidTest() {

		assertTrue(feeValidator.isValid(
				TransactionInputDTO.builder().account_iban(IBAN).amount(AMOUNT).fee("1").build(), null));
		assertTrue(feeValidator.isValid(
				TransactionInputDTO.builder().account_iban(IBAN).amount(NEGATIVE_AMOUNT).fee("1").build(), null));
		
		assertFalse(feeValidator.isValid(
				TransactionInputDTO.builder().account_iban(IBAN).amount(AMOUNT).fee("100").build(), null));
		assertFalse(feeValidator.isValid(
				TransactionInputDTO.builder().account_iban(IBAN).amount(AMOUNT).fee("10").build(), null));
		assertFalse(feeValidator.isValid(
				TransactionInputDTO.builder().account_iban(IBAN).amount(AMOUNT).fee("10.10").build(), null));
		assertFalse(feeValidator.isValid(
				TransactionInputDTO.builder().account_iban(IBAN).amount(NEGATIVE_AMOUNT).fee("10").build(), null));
		assertFalse(feeValidator.isValid(
				TransactionInputDTO.builder().account_iban(IBAN).amount(NEGATIVE_AMOUNT).fee("10.1").build(), null));

	}

}