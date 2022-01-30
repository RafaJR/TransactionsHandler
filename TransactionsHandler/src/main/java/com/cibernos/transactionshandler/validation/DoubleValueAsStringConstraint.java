package com.cibernos.transactionshandler.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com
 * Interface for operators (decimal numbers) validation constraint.
 * @implementations: DoubleValueAsStringValidator
 */
@Documented
@Constraint(validatedBy = DoubleValueAsStringValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DoubleValueAsStringConstraint {
    String message() default "There is an error in at least one input operator. The input operators must be real numbers. You can use point or comma as decimal separator.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}