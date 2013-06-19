package fr.husta.test.ex3;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;

public class Driver extends Person
{

    @Min(value = 18, message = "You have to be 18 to drive a car", groups = DriverChecks.class)
    private int age;

    @AssertTrue(message = "You first have to pass the driving test", groups = DriverChecks.class)
    private boolean hasDrivingLicense;

    /**
     * 
     * @param name
     */
    public Driver(String name)
    {
        super(name);
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void passedDrivingTest(boolean b)
    {
        hasDrivingLicense = b;
    }

}
