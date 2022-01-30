package com.cibernos.transactionshandler.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com Implementation for Description field
 *        validation
 */
public class DescriptionValidator implements ConstraintValidator<DescriptionConstraint, String> {

	/**
	 * Regular expression to test a transaction description format.
	 * It must no contain more than 150 characters.
	 */
	private static final String DESCRIPTION_REGEX = ".{0,150}";

	/**
	 * @return (true if the description contains less than 151 characters or false in any other case.)
	 */
	@Override
	public boolean isValid(String description, ConstraintValidatorContext context) {

		return description == null || description.matches(DESCRIPTION_REGEX);
	}

}