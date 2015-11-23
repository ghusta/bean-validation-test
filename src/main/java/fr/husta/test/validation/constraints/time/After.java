package fr.husta.test.validation.constraints.time;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Date;

import javax.validation.Constraint;
import javax.validation.Payload;

import fr.husta.test.validation.constraints.time.impl.AfterValidatorForDate;

/**
 * Similar to Bean Validation's @Future.
 * <br/>
 * Can be confusing with JUnit's @After ?
 *
 * <p>
 * Use method : {@link Date#after(Date)}.
 * </p>
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { AfterValidatorForDate.class })
public @interface After
{

    String message() default "Must be after {date}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * Date specified in string (can't use type {@link Date}).
     * <br/>
     * Use the date format of {@link #dateTimeFormat()}.
     * <br/>
     * See <a href="https://docs.oracle.com/javase/specs/jls/se8/html/jls-9.html#jls-9.6.1">9.6.1. Annotation Type Elements</a>.
     */
    String date();

    /**
     * Default : ISO-8601.
     * <br/>
     * See https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#ISO_DATE_TIME
     */
    String dateTimeFormat() default "yyyy-MM-dd'T'HH:mm:ss'Z'";

}
