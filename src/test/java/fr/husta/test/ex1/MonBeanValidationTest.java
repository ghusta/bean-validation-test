package fr.husta.test.ex1;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import fr.husta.test.ex1.Groupe1Checks;
import fr.husta.test.ex1.MonBean;

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
        monBean1.setName("toto");

        constraintViolations = validator.validate(monBean1);
        Assert.assertTrue(constraintViolations.size() == 0);

        System.out.println(constraintViolations);

        // TEST #2
        MonBean monBean2 = new MonBean();
        //        monBean1.setAge(2);
        //        monBean1.setName("toto");

        constraintViolations = validator.validate(monBean2);
        Assert.assertTrue(constraintViolations.size() != 0);

        System.out.println(constraintViolations);

        
        // TEST #3
        MonBean monBean3 = new MonBean();
        monBean3.setAge(2);
        monBean3.setName("toto");
        monBean3.setFirstName(null);

        constraintViolations = validator.validate(monBean3, Groupe1Checks.class);
        Assert.assertTrue(constraintViolations.size() != 0);

        System.out.println(constraintViolations);

        
    }

}
