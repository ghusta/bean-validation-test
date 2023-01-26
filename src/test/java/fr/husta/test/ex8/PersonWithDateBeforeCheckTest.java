package fr.husta.test.ex8;

import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Set;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

public class PersonWithDateBeforeCheckTest
{

    private static Validator validator;

    @BeforeClass
    public static void initGlobal()
    {
        // set default locale to FR -> UTF-8 problem with IntelliJ ?!?
        Locale.setDefault(Locale.ENGLISH);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testDob_OK() throws Exception
    {
        Set<ConstraintViolation<PersonWithDateBeforeCheck>> constraintViolations = null;

        PersonWithDateBeforeCheck myPojo = new PersonWithDateBeforeCheck();
        myPojo.setName("TOTO");
        myPojo.setDob(new GregorianCalendar(1995, GregorianCalendar.AUGUST, 31).getTime());

        constraintViolations = validator.validate(myPojo);

        assertTrue(constraintViolations.size() == 0);
    }

    @Test
    public void testDob_KO() throws Exception
    {
        Set<ConstraintViolation<PersonWithDateBeforeCheck>> constraintViolations = null;

        PersonWithDateBeforeCheck myPojo = new PersonWithDateBeforeCheck();
        myPojo.setName("Too young");
        myPojo.setDob(new GregorianCalendar(2015, GregorianCalendar.AUGUST, 31).getTime());

        constraintViolations = validator.validate(myPojo);

        assertTrue(constraintViolations.size() >= 1);
        String interpolatedMessage = constraintViolations.iterator().next().getMessage();
        assertTrue(interpolatedMessage.startsWith("Must be before "));
    }

    @Test
    public void testDob_inclusion() throws Exception
    {
        Set<ConstraintViolation<PersonWithDateBeforeCheck>> constraintViolations = null;

        final Date dateLimitConstraint = new GregorianCalendar(2000, GregorianCalendar.JANUARY, 1).getTime();

        PersonWithDateBeforeCheck myPojo = new PersonWithDateBeforeCheck();
        myPojo.setName("TOTO");
        myPojo.setDob(new GregorianCalendar(1995, GregorianCalendar.AUGUST, 31).getTime());
        myPojo.setOtherDateInclusive(dateLimitConstraint);

        constraintViolations = validator.validate(myPojo);

        assertTrue(constraintViolations.size() == 0);
    }

}