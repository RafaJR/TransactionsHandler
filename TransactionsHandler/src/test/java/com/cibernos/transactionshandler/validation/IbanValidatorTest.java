package com.cibernos.transactionshandler.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com
 * IBAN validation test.
 */
class IbanValidatorTest {

	IbanValidator ibanValidator = new IbanValidator();
	
	@Test
	void ibanValidatorTest1() {
		
		// Validation passed if 
		assertTrue(ibanValidator.isValid("ES00 0000 00 00000000000000", null));
		assertTrue(ibanValidator.isValid("ES000000 00 00000000000000", null));
		assertTrue(ibanValidator.isValid("ES00000000 00000000000000", null));
		assertTrue(ibanValidator.isValid("ES0000000000000000000000", null));
		
		assertFalse(ibanValidator.isValid("Any", null));
		assertFalse(ibanValidator.isValid("ES000000000000000000 0000", null));
		assertFalse(ibanValidator.isValid("ES00000000000000000000001", null));
		assertFalse(ibanValidator.isValid("ES000000000000000000000", null));
		assertFalse(ibanValidator.isValid("ES00 0000 001 00000000000000", null));
	}

}
