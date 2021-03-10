package fr.husta.test.ex6;

import jakarta.validation.constraints.NotNull;

import fr.husta.test.validation.constraints.CheckInvalidChars;

public class PersonWithInvalidCharsCheck
{

    @NotNull
    @CheckInvalidChars(value = ";?")
    private String name;

    @NotNull
    private String firstName;

    public PersonWithInvalidCharsCheck()
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

}
