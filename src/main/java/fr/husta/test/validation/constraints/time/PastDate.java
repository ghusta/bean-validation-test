package fr.husta.test.validation.constraints.time;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Date;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import fr.husta.test.validation.constraints.time.impl.PastDateValidatorForDate;

/**
 * Similar to Bean Validation's @Past, but has the option to exclude today.
 *
 * <p>
 * Use method : {@link Date#before(Date)}.
 * </p>
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { PastDateValidatorForDate.class /*, PastDateValidatorForReadablePartial.class */ })
public @interface PastDate
{

    String message() default "Must be in the past - excluding today : {includeToday}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * Include today in comparison.
     */
    boolean includeToday() default false;

}
