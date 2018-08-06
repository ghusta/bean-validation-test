package fr.husta.test.ex3;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class DriverValidationTest
{

    private static Validator validator;

    @BeforeClass
    public static void initGlobal()
    {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    /**
     * Test Car with Driver.
     * 
     * @throws Exception
     */
    @Test
    public void testValidation() throws Exception
    {
        Set<ConstraintViolation<Car>> constraintViolations = null;

        Car car = null;
        Driver driver = null;

        // TEST #1
        car = new Car("Peugeot", "AA-BB-123", 5);
        car.setPassedVehicleInspection(true);
        driver = new Driver("Bob");
        driver.setAge(18);
        driver.passedDrivingTest(true);
        car.setDriver(driver);

        constraintViolations = validator.validate(car);
        Assert.assertTrue(constraintViolations.size() == 0);

        constraintViolations = validator.validate(car, CarChecks.class, DriverChecks.class);
        Assert.assertTrue(constraintViolations.size() == 0);

    }

}
