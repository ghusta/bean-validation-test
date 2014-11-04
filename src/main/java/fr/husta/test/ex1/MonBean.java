package fr.husta.test.ex1;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

public class MonBean
{

    @Range(min = 0, max = 200)
    private int age;

    @Min(value = 1)
    @Max(value = 200)
    private int age2;

    @NotNull(message = "Nom obligatoire")
    @Size(min = 1, max = 10)
    private String name;

    @NotNull(groups = { Groupe1Checks.class })
    private String firstName;

    public MonBean()
    {
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

    public int getAge2()
    {
        return age2;
    }

    public void setAge2(int age2)
    {
        this.age2 = age2;
    }
}
