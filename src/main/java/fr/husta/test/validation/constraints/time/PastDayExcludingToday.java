package fr.husta.test.validation.constraints.time;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;

/**
 * Similar to Bean Validation's @Past, excluding today.
 *
 */
@PastDate(excludeToday = true)
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
