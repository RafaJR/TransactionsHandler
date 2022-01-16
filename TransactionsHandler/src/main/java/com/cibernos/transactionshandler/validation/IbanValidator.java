package com.cibernos.transactionshandler.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com Implementation for IBAN field
 *        validation
 */
public class IbanValidator implements ConstraintValidator<IbanConstraint, String> {

	/**
	 * Regular expression to test a Spanish IBAN code: 'ES' + [Two digits] +
	 * [(optional)space] + [Four digits] + [(optional)space] + [Four digits] +
	 * [(optional)space] + [Two digits] + [(optional)space] + [Ten digits]
	 */
	private static final String SPANISH_IBAN_REGEX = "ES\\d{2}[\\s]?\\d{4}[\\s]?\\d{4}[\\s]?\\d{2}[\\s]?\\d{10}";

	// ES31 1465 01 00911708732169
	/**
	 * @return (true if IBAN is valid, false in any other case.)
	 */
	@Override
	public boolean isValid(String IBAN, ConstraintValidatorContext context) {

		return !(IBAN != null && IBAN.trim().isEmpty()) && IBAN.matches(SPANISH_IBAN_REGEX);
	}

}