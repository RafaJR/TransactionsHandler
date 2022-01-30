package com.cibernos.transactionshandler.validation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com Monetary ciphers validation
 */
class DoubleValueAsStringValidatorTest {

	private final DoubleValueAsStringValidator doubleValueAsStringValidator = new DoubleValueAsStringValidator();

	/**
	 * Test for monetary ciphers validation. Monetary ciphers (transaction amount,
	 * transactions fee or account balance) must be set as a real number with no
	 * more than two decimals.
	 */
	@Test
	public void isValidTest() {

		assertTrue(doubleValueAsStringValidator.isValid("5", null));
		assertTrue(doubleValueAsStringValidator.isValid("-5", null));
		assertTrue(doubleValueAsStringValidator.isValid("+5", null));
		assertTrue(doubleValueAsStringValidator.isValid("0.75", null));
		assertTrue(doubleValueAsStringValidator.isValid("-0.75", null));
		assertTrue(doubleValueAsStringValidator.isValid("+0.75", null));
		assertTrue(doubleValueAsStringValidator.isValid("0.75", null));
		assertTrue(doubleValueAsStringValidator.isValid("9837458972397856875467464534523465344534.98", null));

		assertFalse(doubleValueAsStringValidator.isValid("+0.000000000000001", null));
		assertFalse(doubleValueAsStringValidator.isValid("a", null));
		assertFalse(doubleValueAsStringValidator.isValid("5 5", null));
		assertFalse(doubleValueAsStringValidator.isValid("", null));
		assertFalse(doubleValueAsStringValidator.isValid(null, null));

	}

}
