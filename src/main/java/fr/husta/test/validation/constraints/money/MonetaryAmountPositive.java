package fr.husta.test.validation.constraints.money;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Check monetary amount : 16 integer digits, 2 decimal max; must be positive.
 */
@MonetaryAmount
@DecimalMin("0.00")
@ReportAsSingleViolation
@Target({METHOD, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {})
public @interface MonetaryAmountPositive {

    String message() default "{fr.husta.test.validation.constraints.MonetaryAmountPositive.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
