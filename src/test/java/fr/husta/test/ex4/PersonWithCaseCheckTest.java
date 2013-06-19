package fr.husta.test.ex4;

import java.util.Locale;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

public class PersonWithCaseCheckTest
{

    private static Validator validator;

    @BeforeClass
    public static void initGlobal()
    {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testValidation() throws Exception
    {
        Set<ConstraintViolation<PersonWithCaseCheck>> constraintViolations = null;
        String interpolatedMessage = null;

        // set default locale to EN
        Locale.setDefault(Locale.ENGLISH);

        // TEST #1
        PersonWithCaseCheck bean1 = new PersonWithCaseCheck();
        bean1.setName("TOTO");
        bean1.setFirstName("tutu");

        constraintViolations = validator.validate(bean1);
        Assert.assertTrue(constraintViolations.size() == 0);

        // TEST #2
        PersonWithCaseCheck bean2 = new PersonWithCaseCheck();
        bean2.setName("TOTO");
        bean2.setFirstName("TUTU");

        constraintViolations = validator.validate(bean2);
        Assert.assertTrue(constraintViolations.size() == 1);
        interpolatedMessage = constraintViolations.iterator().next().getMessage();
        // Assert.assertEquals("Case mode must be LOWER.", interpolatedMessage);
        Assert.assertEquals("La casse doit être positionnée à LOWER.", interpolatedMessage);

        // TEST #3
        PersonWithCaseCheck bean3 = new PersonWithCaseCheck();
        bean3.setName("tutu");
        bean3.setFirstName("TUTU");

        constraintViolations = validator.validate(bean3);
        Assert.assertTrue(constraintViolations.size() == 2);

    }

}
