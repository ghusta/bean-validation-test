package fr.husta.test.validation.constraints.time.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import fr.husta.test.validation.constraints.time.AfterDate;

/**
 *
 */
public class AfterValidatorForDate
        implements ConstraintValidator<AfterDate, Date>
{

    private Date date;
    private DateFormat dateFormatter;
    private boolean inclusive;

    @Override
    public void initialize(AfterDate constraintAnnotation)
    {
        dateFormatter = new SimpleDateFormat(constraintAnnotation.dateTimeFormat());
        try
        {
            date = dateFormatter.parse(constraintAnnotation.date());
        }
        catch (ParseException e)
        {
            throw new ExceptionInInitializerError(e);
        }
        inclusive = constraintAnnotation.inclusive();
    }

    @Override
    public boolean isValid(Date value, ConstraintValidatorContext context)
    {
        // null values are valid
        if (value == null)
        {
            return true;
        }

        if (inclusive)
        {
            return value.compareTo(date) >= 0;
        }
        else
        {
            return value.compareTo(date) > 0;
        }
    }

}
