package fr.husta.test.ex8;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import fr.husta.test.validation.constraints.time.BeforeDate;

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
    @BeforeDate(date = "2000-01-01", dateTimeFormat = "yyyy-MM-dd")
    private Date dob;

    @Past
    @BeforeDate(date = "2000-01-01", dateTimeFormat = "yyyy-MM-dd", inclusive = true)
    private Date otherDateInclusive;

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

    public Date getOtherDateInclusive()
    {
        return otherDateInclusive;
    }

    public void setOtherDateInclusive(Date otherDateInclusive)
    {
        this.otherDateInclusive = otherDateInclusive;
    }

}
