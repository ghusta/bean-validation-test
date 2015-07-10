package fr.husta.test.ex6;

import java.util.Locale;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class PersonWithInvalidCharsCheckTest
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
    public void testValidation() throws Exception
    {
        Set<ConstraintViolation<PersonWithInvalidCharsCheck>> constraintViolations = null;
        String interpolatedMessage = null;

        // TEST #1
        PersonWithInvalidCharsCheck bean1 = new PersonWithInvalidCharsCheck();
        bean1.setName("TOTO");
        bean1.setFirstName("tutu");

        constraintViolations = validator.validate(bean1);
        Assert.assertTrue(constraintViolations.size() == 0);

        // TEST #2
        PersonWithInvalidCharsCheck bean2 = new PersonWithInvalidCharsCheck();
        bean2.setName("TO;TO?");
        bean2.setFirstName("TUTU");

        constraintViolations = validator.validate(bean2);
        Assert.assertTrue(constraintViolations.size() == 1);
        interpolatedMessage = constraintViolations.iterator().next().getMessage();
        // Assert.assertEquals("Caractères invalides.", interpolatedMessage);
        Assert.assertEquals("Invalid characters (must not contain [;?]).", interpolatedMessage);

        // TEST #3
        PersonWithInvalidCharsCheck bean3 = new PersonWithInvalidCharsCheck();
        bean3.setName("tu?tu");
        bean3.setFirstName("TUTU");

        constraintViolations = validator.validate(bean3);
        Assert.assertTrue(constraintViolations.size() == 1);

    }

}
