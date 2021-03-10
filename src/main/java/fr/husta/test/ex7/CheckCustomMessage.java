package fr.husta.test.ex7;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * See changes as of HV 6.2 : https://in.relation.to/2021/01/06/hibernate-validator-700-62-final-released/
 */
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckCustomMessageValidator.class)
@Documented
public @interface CheckCustomMessage
{

    /**
     * Useless in this case.
     * @return
     */
    String message() default "{fr.husta.test.validation.constraints.CheckCustomMessage.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
