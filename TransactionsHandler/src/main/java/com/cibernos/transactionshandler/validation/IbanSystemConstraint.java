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
 * Interface for IBAN field system validation
 * @implementations: IbanValidator
 */
@Documented
@Constraint(validatedBy = IbanSystemValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IbanSystemConstraint {
    String message() default "The IBAN code of the transaction could not be fount in system.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}