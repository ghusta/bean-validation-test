package fr.husta.test.ex9;

import java.util.Date;

import javax.validation.constraints.NotNull;

import fr.husta.test.validation.constraints.time.PastDate;
import fr.husta.test.validation.constraints.time.PastDayExcludingToday;

/**
 *
 */
public class PersonWithPastDateCheck
{

    @NotNull
    private String name;

    private String firstName;

    @NotNull
    @PastDate(includeToday = false)
    private Date dob;

    @PastDate(includeToday = true)
    private Date dateIncludingToday;

    @PastDayExcludingToday
    private Date otherDateExcludingToday;

    public PersonWithPastDateCheck()
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

    public Date getDateIncludingToday()
    {
        return dateIncludingToday;
    }

    public void setDateIncludingToday(Date dateIncludingToday)
    {
        this.dateIncludingToday = dateIncludingToday;
    }

    public Date getOtherDateExcludingToday()
    {
        return otherDateExcludingToday;
    }

    public void setOtherDateExcludingToday(Date otherDateExcludingToday)
    {
        this.otherDateExcludingToday = otherDateExcludingToday;
    }
}
