package fr.husta.test.ex4;

import javax.validation.constraints.NotNull;

import fr.husta.test.validation.constraints.CaseMode;
import fr.husta.test.validation.constraints.CheckCase;

public class PersonWithCaseCheck
{

    @NotNull
    @CheckCase(value = CaseMode.UPPER)
    private String name;

    @NotNull
    @CheckCase(value = CaseMode.LOWER)
    private String firstName;

    public PersonWithCaseCheck()
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
