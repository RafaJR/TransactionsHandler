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
 * Interface for IBAN field validation
 * @implementations: IbanValidator
 */
@Documented
@Constraint(validatedBy = IbanValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IbanConstraint {
    String message() default "The IBAN for a bank account is made up of two capital letters and ten numeric characters.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}