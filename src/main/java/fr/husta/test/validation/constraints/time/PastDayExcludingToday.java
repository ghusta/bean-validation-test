package fr.husta.test.validation.constraints.time;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;

/**
 * Similar to Bean Validation's @Past, excluding today.
 *
 */
@PastDate(includeToday = false)
@ReportAsSingleViolation
@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {})
public @interface PastDayExcludingToday
{

    String message() default "Must be in the past - excluding today";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
