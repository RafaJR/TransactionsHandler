package com.cibernos.transactionshandler.validation;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com Monetary ciphers validation constraint
 */
public class DoubleValueAsStringValidator implements ConstraintValidator<DoubleValueAsStringConstraint, String> {
	
	// Regular expression to check the 'integer convertible format' of a String
    private static final String regexInteger = "(^(-|\\+)?\\d+$)";
    // Regular expression to check the 'real number convertible format' of a String
    private static final String regexDecimal = "^(-|\\+)?\\d*(\\.)\\d{2}";
    // Regular expression to check the 'integer or real number convertible format' of a String
    private static final String regexDouble = regexDecimal + "|" + regexInteger;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// Support method call for operators validation
		return value == null || Pattern.compile(regexDouble).matcher(value).matches();
	}

}