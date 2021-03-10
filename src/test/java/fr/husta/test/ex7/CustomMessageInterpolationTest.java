package fr.husta.test.ex7;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Locale;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test for : HV-701 (closed) & BVAL-339 (open)
 *
 * Changes as of HV 6.2 : https://in.relation.to/2021/01/06/hibernate-validator-700-62-final-released/
 */
public class CustomMessageInterpolationTest
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
    public void testBasic() throws Exception
    {
        Set<ConstraintViolation<MyPojo>> constraintViolations = null;

        MyPojo myPojo = new MyPojo();
        myPojo.setName("FAIL");

        constraintViolations = validator.validate(myPojo);

        assertTrue(constraintViolations.size() >= 1);
        String interpolatedMessage = constraintViolations.iterator().next().getMessage();
        assertEquals("Invalid value : FAIL", interpolatedMessage);
    }

}
