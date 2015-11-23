package fr.husta.test.ex8;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import fr.husta.test.validation.constraints.time.Before;

/**
 *
 */
public class PersonWithDateBeforeCheck
{

    @NotNull
    private String name;

    private String firstName;

    @NotNull
    @Past
    @Before(date = "2000-01-01", dateTimeFormat = "yyyy-MM-dd")
    private Date dob;

    public PersonWithDateBeforeCheck()
    {
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public Date getDob()
    {
        return dob;
    }

    public void setDob(Date dob)
    {
        this.dob = dob;
    }
}
