package fr.husta.test.ex7;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;

/**
 *
 */
public class CheckCustomMessageValidator
        implements ConstraintValidator<CheckCustomMessage, String>
{

    @Override
    public void initialize(CheckCustomMessage constraintAnnotation)
    {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context)
    {
        if ("OK".equals(value))
        {
            return true;
        }
        else
        {
            context.disableDefaultConstraintViolation();

            // context.buildConstraintViolationWithTemplate("Hello ${you} !").addConstraintViolation();

            // Test : unwrap = impl of ConstraintValidatorContext
            // ConstraintValidatorContextImpl contextImpl = context.unwrap(ConstraintValidatorContextImpl.class);
            HibernateConstraintValidatorContext hibContext = context.unwrap(HibernateConstraintValidatorContext.class);

            // hibContext.addExpressionVariable("you", value);
            hibContext.addExpressionVariable("name", value);
            hibContext.buildConstraintViolationWithTemplate("{fr.husta.test.validation.constraints.CheckCustomMessage.message}").addConstraintViolation();

            return false;
        }
    }

}
