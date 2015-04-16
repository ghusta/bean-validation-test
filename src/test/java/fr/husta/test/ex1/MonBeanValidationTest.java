package fr.husta.test.ex1;

import static org.junit.Assert.assertTrue;

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
        monBean1.setFirstName(null);

        constraintViolations = validator.validate(monBean1);
        assertTrue("'age2' n'est pas >= 1", constraintViolations.size() == 1);

        System.out.println(constraintViolations);
        System.out.println(constraintViolations.iterator().next().getMessage());

        // TEST #2
        MonBean monBean2 = new MonBean();
        //        monBean2.setAge(2);
        monBean2.setAge2(1);
        //        monBean2.setName("toto");

        constraintViolations = validator.validate(monBean2);
        assertTrue("Nom obligatoire", constraintViolations.size() == 1);

        System.out.println(constraintViolations);

    }

    @Test
    public void testValidationWithGroups() throws Exception
    {
        Set<ConstraintViolation<MonBean>> constraintViolations = null;

        // TEST #3
        MonBean monBean3 = new MonBean();
        monBean3.setAge(2);
        monBean3.setAge2(2);
        monBean3.setName("toto");
        monBean3.setFirstName(null);

        constraintViolations = validator.validate(monBean3, Groupe1Checks.class);
        assertTrue("'firstName' ne peut pas être nul", constraintViolations.size() == 1);

        System.out.println(constraintViolations);

    }

}
