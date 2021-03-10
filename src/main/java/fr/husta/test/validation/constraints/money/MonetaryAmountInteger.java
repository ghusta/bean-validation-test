package fr.husta.test.validation.constraints.money;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.Digits;

/**
 * Check monetary amount : 16 integer digits, 0 decimal.
 * <p/>
 * See also <a href="https://jcp.org/en/jsr/detail?id=354">JSR 354: Money and Currency API</a>.
 */
@Digits(integer = 16, fraction = 0)
@ReportAsSingleViolation
@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {})
public @interface MonetaryAmountInteger
{

    String message() default "{fr.husta.test.validation.constraints.MonetaryAmountInteger.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
