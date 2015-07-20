package fr.husta.test.validation.constraints.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang.StringUtils;

import fr.husta.test.validation.constraints.CheckInvalidChars;

/**
 *
 */
public class CheckInvalidCharsValidator
        implements ConstraintValidator<CheckInvalidChars, CharSequence>
{

    private String invalidChars;

    @Override
    public void initialize(CheckInvalidChars constraintAnnotation)
    {
        this.invalidChars = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context)
    {
        if (value == null)
        {
            return true;
        }

        if (invalidChars != null)
        {
            char[] liste = invalidChars.toCharArray();
            for (char c : liste)
            {
                if (StringUtils.contains(value.toString(), c))
                {
                    return false;
                }
            }
            return true;
        }
        else
        {
            return true;
        }
    }

}
