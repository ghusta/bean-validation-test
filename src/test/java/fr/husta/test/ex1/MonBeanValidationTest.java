package fr.husta.test.ex1;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Simple validation tests.
 *
 * @author HUSTA
 *
 */
public class MonBeanValidationTest
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
        Set<ConstraintViolation<MonBean>> constraintViolations = null;

        // TEST #1
        MonBean monBean1 = new MonBean();
        monBean1.setAge(2);
        monBean1.setAge2(0);
        monBean1.setName("toto");

        constraintViolations = validator.validate(monBean1);
        System.out.println(constraintViolations);
        assertTrue(constraintViolations.size() == 2);

        // TEST #2
        MonBean monBean2 = new MonBean();
        //        monBean2.setAge(2);
        monBean2.setAge2(1);
        //        monBean2.setName("toto");

        constraintViolations = validator.validate(monBean2);
        assertTrue(constraintViolations.size() == 2);

        System.out.println(constraintViolations);

        // TEST #3
        MonBean monBean3 = new MonBean();
        monBean3.setAge(2);
        monBean3.setAge2(2);
        monBean3.setName("toto");
        monBean3.setFirstName(null);

        constraintViolations = validator.validate(monBean3, Groupe1Checks.class);
        assertTrue(constraintViolations.size() == 1);

        System.out.println(constraintViolations);
    }

    @Test
    public void testValidationDecimal() throws Exception
    {
        Set<ConstraintViolation<MonBean>> constraintViolations = null;

        // TEST #1
        MonBean monBean1 = new MonBean();
        monBean1.setAge(10);
        monBean1.setName("bob");
        monBean1.setDecimalNumber(new BigDecimal("100.1"));

        constraintViolations = validator.validate(monBean1, DecimalChecks.class);
        System.out.println(constraintViolations);
        assertTrue(constraintViolations.size() == 1);
    }

    @Test
    public void testValidation_MonetaryAmountInteger() throws Exception
    {
        Set<ConstraintViolation<MonBean>> constraintViolations = null;

        // TEST #1
        MonBean monBean1 = new MonBean();
        monBean1.setAge(10);
        monBean1.setAge2(10);
        monBean1.setName("bob");
        monBean1.setLongNumber(123456L);
        monBean1.setDecimalNumber(new BigDecimal("50.0"));
        monBean1.setIntegerAmount(new BigDecimal("10.99"));

        constraintViolations = validator.validate(monBean1);
        assertTrue(constraintViolations.size() >= 1);
    }

}
