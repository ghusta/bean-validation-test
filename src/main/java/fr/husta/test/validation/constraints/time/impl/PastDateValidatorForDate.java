package fr.husta.test.validation.constraints.time.impl;

import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang.time.DateUtils;

import fr.husta.test.validation.constraints.time.PastDate;

/**
 *
 */
public class PastDateValidatorForDate
        implements ConstraintValidator<PastDate, Date>
{

    private boolean excludeToday;

    @Override
    public void initialize(PastDate constraintAnnotation)
    {
        excludeToday = constraintAnnotation.excludeToday();
    }

    @Override
    public boolean isValid(Date value, ConstraintValidatorContext context)
    {
        // null values are valid
        if (value == null)
        {
            return true;
        }

        Date now = new Date();

        if (!excludeToday)
        {
            return value.before(now);
        }
        else
        {
            if (DateUtils.isSameDay(now, value))
            {
                return false;
            }
            else
            {
                return value.before(now);
            }
        }
    }

}
