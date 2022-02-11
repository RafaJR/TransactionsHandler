package com.cibernos.transactionshandler.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.cibernos.transactionshandler.constants.TransactionsHandlerConstants;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com Interface for operators (decimal
 *        numbers) validation constraint.
 * @implementations: DoubleValueAsStringValidator
 */
@Documented
@Constraint(validatedBy = PositiveDoubleValueAsStringValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PositiveDoubleValueAsStringConstrain {
	String message() default TransactionsHandlerConstants.POSITIVE_ACCOUNT_BALANCE;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}