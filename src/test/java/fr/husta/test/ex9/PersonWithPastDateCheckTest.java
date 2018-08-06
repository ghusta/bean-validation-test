package fr.husta.test.ex9;

import org.apache.commons.lang.time.DateUtils;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Date;
import java.util.Locale;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonWithPastDateCheckTest
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
        Set<ConstraintViolation<PersonWithPastDateCheck>> constraintViolations = null;

        Date now = new Date();
        Date pastDate = DateUtils.addYears(now, -20);

        PersonWithPastDateCheck myPojo = new PersonWithPastDateCheck();
        myPojo.setName("TOTO");
        myPojo.setDob(pastDate);

        constraintViolations = validator.validate(myPojo);

        assertThat(constraintViolations).isEmpty();
    }

    @Test
    public void testDob_KO() throws Exception
    {
        Set<ConstraintViolation<PersonWithPastDateCheck>> constraintViolations = null;

        Date now = new Date();
        Date datePlus20Years = DateUtils.addYears(now, 20);

        PersonWithPastDateCheck myPojo = new PersonWithPastDateCheck();
        myPojo.setName("Too young");
        myPojo.setDob(datePlus20Years);

        constraintViolations = validator.validate(myPojo);

        assertThat(constraintViolations).isNotEmpty();
        String interpolatedMessage = constraintViolations.iterator().next().getMessage();
        assertThat(interpolatedMessage).startsWith("Must be in the past");
    }

    @Test
    public void testDob_KO_includeToday() throws Exception
    {
        Set<ConstraintViolation<PersonWithPastDateCheck>> constraintViolations = null;

        Date now = new Date();

        PersonWithPastDateCheck myPojo = new PersonWithPastDateCheck();
        myPojo.setName("TOTO");
        myPojo.setDob(now);

        constraintViolations = validator.validate(myPojo);

        assertThat(constraintViolations).isNotEmpty();
    }

    /**
     * TODO: corriger test fail aleatoire
     *
     * @throws Exception
     */
    @Test
    @Ignore("Bug ?")
    public void testDob_OK_excludeToday() throws Exception
    {
        Set<ConstraintViolation<PersonWithPastDateCheck>> constraintViolations = null;

        Date now = new Date();
        Date pastDate = DateUtils.addYears(now, -20);

        PersonWithPastDateCheck myPojo = new PersonWithPastDateCheck();
        myPojo.setName("TOTO");
        myPojo.setDob(pastDate);
        myPojo.setDateIncludingToday(now);

        constraintViolations = validator.validate(myPojo);

        assertThat(constraintViolations).isEmpty();
    }

    @Test
    public void testDob_OK_excludeToday_withOtherAnnotation() throws Exception
    {
        Set<ConstraintViolation<PersonWithPastDateCheck>> constraintViolations = null;

        Date now = new Date();
        Date pastDate = DateUtils.addYears(now, -20);

        PersonWithPastDateCheck myPojo = new PersonWithPastDateCheck();
        myPojo.setName("TOTO");
        myPojo.setDob(pastDate);
        myPojo.setOtherDateExcludingToday(now);

        constraintViolations = validator.validate(myPojo);

        assertThat(constraintViolations).isNotEmpty();
    }

}