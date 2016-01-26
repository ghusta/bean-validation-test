package fr.husta.test.validation.constraints.time.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import fr.husta.test.validation.constraints.time.AfterDate;

/**
 *
 */
public class AfterValidatorForDate
        implements ConstraintValidator<AfterDate, Date>
{

    private Date date;
    private DateFormat dateFormatter;

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
    }

    @Override
    public boolean isValid(Date value, ConstraintValidatorContext context)
    {
        // null values are valid
        if (value == null)
        {
            return true;
        }

        return value.after(date);
    }

}
