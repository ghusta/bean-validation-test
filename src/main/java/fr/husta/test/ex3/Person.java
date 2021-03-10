package fr.husta.test.ex3;

import jakarta.validation.constraints.NotNull;

public class Person
{

    @NotNull
    private String name;

    private String firstName;

    /**
     * 
     * @param name
     */
    public Person(String name)
    {
        this.name = name;
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
