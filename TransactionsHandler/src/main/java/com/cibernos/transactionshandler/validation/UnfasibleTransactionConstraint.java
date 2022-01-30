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
 * Interface for unfeasible transactions
 * @implementations: UnfeasibleTransactionValidation
 */
@Documented
@Constraint(validatedBy = UnfeasibleTransactionValidation.class)
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface UnfasibleTransactionConstraint {
    String message() default "The account has no balance enough for the transaction, so it's unfeasible.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}