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
 * @email rafael.jimenez.reina@gmail.com Interface for Fee field validation. The
 *        fee can't be major than the transaction ammount
 * @implementations: FeeValidator
 */
@Documented
@Constraint(validatedBy = FeeValidator.class)
@Target({ ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface FeeConstraint {
	String message() default TransactionsHandlerConstants.TRANSACTION_LESS_THAN_AMOUNT;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}