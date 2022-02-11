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
 * @email rafael.jimenez.reina@gmail.com Interface for Description field
 *        validation
 * @implementations: DescriptionValidator
 */
@Documented
@Constraint(validatedBy = DescriptionValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface DescriptionConstraint {
	String message() default TransactionsHandlerConstants.DESCRIPTION_MAX_SIZE;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}