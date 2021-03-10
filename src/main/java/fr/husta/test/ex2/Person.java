package fr.husta.test.ex2;

import jakarta.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

public class Person
{

    @Range(min = 0, max = 200)
    private int age;

    @NotNull(groups = { PersonChecksPart1.class })
    private String name;

    @NotNull(groups = { PersonChecksPart2.class })
    private String firstName;

    public Person()
    {
    }

    /**
     * 
     * @param name
     */
    public Person(String name)
    {
        this.name = name;
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
