package com.cibernos.transactionshandler.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com
 * Implementation for IBAN field validation
 */
public class IbanValidator implements ConstraintValidator<IbanConstraint, String> {
	
	private static final String SPANISH_IBAN_REGEX = "ES\\d{2}[\\s]?\\d{4}[\\s]?\\d{2}[\\s]?\\d{14}";

	@Override
	public boolean isValid(String IBAN, ConstraintValidatorContext context) {
		
		return !(IBAN != null && IBAN.trim().isEmpty()) && IBAN.matches(SPANISH_IBAN_REGEX);
	}

    

}