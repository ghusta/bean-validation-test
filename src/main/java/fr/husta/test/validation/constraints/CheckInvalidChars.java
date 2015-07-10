package fr.husta.test.validation.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import fr.husta.test.validation.constraints.impl.CheckInvalidCharsValidator;

/**
 *
 */
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckInvalidCharsValidator.class)
@Documented
public @interface CheckInvalidChars
{

    String message() default "{fr.husta.test.validation.constraints.CheckInvalidChars.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * Caracteres a exclure.
     *
     * @return
     */
    String value() default "";

}
