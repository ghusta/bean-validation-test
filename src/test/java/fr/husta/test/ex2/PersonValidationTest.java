package fr.husta.test.ex2;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Checks that validation with groups are not overlapping.
 * 
 * @author HUSTA
 *
 */
public class PersonValidationTest
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
        Set<ConstraintViolation<Person>> constraintViolations = null;

        // TEST #1 - no group
        Person person1 = new Person();
        person1.setAge(20);

        constraintViolations = validator.validate(person1);
        Assert.assertTrue(constraintViolations.size() == 0);

    }

    @Test
    public void testValidationChecksPart1() throws Exception
    {
        Set<ConstraintViolation<Person>> constraintViolations = null;

        // TEST #2 - group 1
        Person person2 = new Person();
        person2.setAge(20);
        person2.setName("Toto");

        constraintViolations = validator.validate(person2, PersonChecksPart1.class);
        Assert.assertTrue(constraintViolations.size() == 0);

        // TEST #3 - group 1 / 1 violation
        Person person3 = new Person();
        person3.setAge(20);
        person3.setName(null);

        constraintViolations = validator.validate(person3, PersonChecksPart1.class);
        Assert.assertTrue(constraintViolations.size() == 1);

    }

    @Test
    public void testValidationChecksPart2() throws Exception
    {
        Set<ConstraintViolation<Person>> constraintViolations = null;

        // TEST #4 - group 2
        Person person4 = new Person();
        person4.setAge(20);
        person4.setName(null);
        person4.setFirstName("Tutu");

        constraintViolations = validator.validate(person4, PersonChecksPart2.class);
        Assert.assertTrue(constraintViolations.size() == 0);

        // TEST #5 - group 2 / 1 violation
        Person person5 = new Person();
        person5.setAge(20);
        person5.setName(null);
        person4.setFirstName(null);

        constraintViolations = validator.validate(person5, PersonChecksPart2.class);
        Assert.assertTrue(constraintViolations.size() == 1);

    }

    @Test
    public void testValidationChecksPart1AndChecksPart2() throws Exception
    {
        Set<ConstraintViolation<Person>> constraintViolations = null;

        // TEST #6 - groups 1 & 2
        Person person6 = new Person();
        person6.setAge(20);
        person6.setName("Hello");
        person6.setFirstName("Boy");

        constraintViolations = validator.validate(person6, PersonChecksPart1.class, PersonChecksPart2.class);
        Assert.assertTrue(constraintViolations.size() == 0);

        // TEST #7 - groups 1 & 2 / 1 violation
        Person person7 = new Person();
        person7.setAge(20);
        person7.setName(null);
        person7.setFirstName(null);

        constraintViolations = validator.validate(person7, PersonChecksPart1.class, PersonChecksPart2.class);
        Assert.assertTrue(constraintViolations.size() == 2);

    }

}
