package fr.husta.test.ex7;

import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * See changes as of HV 6.2 : https://in.relation.to/2021/01/06/hibernate-validator-700-62-final-released/
 */
public class CheckCustomMessageValidator
        implements ConstraintValidator<CheckCustomMessage, String> {

    @Override
    public void initialize(CheckCustomMessage constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if ("OK".equals(value)) {
            return true;
        } else {
            HibernateConstraintValidatorContext hibContext = context.unwrap(HibernateConstraintValidatorContext.class);
            hibContext.disableDefaultConstraintViolation();
            hibContext
                    .addExpressionVariable("name", value)
                    .buildConstraintViolationWithTemplate("{fr.husta.test.validation.constraints.CheckCustomMessage.message}")
                    .addConstraintViolation(); // method from ConstraintValidatorContext

            return false;
        }
    }

}
