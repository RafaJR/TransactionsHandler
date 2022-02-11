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
 * @email rafael.jimenez.reina@gmail.com Interface for IBAN field system
 *        validation
 * @implementations: IbanValidator
 */
@Documented
@Constraint(validatedBy = IbanSystemValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface IbanSystemConstraint {
	String message() default TransactionsHandlerConstants.IBAN_CODE_NOT_FOUND;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}