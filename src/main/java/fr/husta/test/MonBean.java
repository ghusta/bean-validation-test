package fr.husta.test;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MonBean
{

    // @NotNull(message = "Age ne doit pas etre null")
    private int age;

    @NotNull(message = "Nom obligatoire")
    @Size(min = 1, max = 10)
    private String name;

    @NotNull(groups = { Groupe1Checks.class })
    private String firstName;

    public MonBean()
    {
        // TODO Auto-generated constructor stub
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
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
