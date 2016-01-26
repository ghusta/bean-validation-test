package fr.husta.test.ex9;

import java.util.Date;

import javax.validation.constraints.NotNull;

import fr.husta.test.validation.constraints.time.PastDate;

/**
 *
 */
public class PersonWithPastDateCheck
{

    @NotNull
    private String name;

    private String firstName;

    @NotNull
    @PastDate(excludeToday = true)
    private Date dob;

    @PastDate(excludeToday = false)
    private Date dateIncludingToday;

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
}
