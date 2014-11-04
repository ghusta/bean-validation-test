package fr.husta.test.ex1;

import java.math.BigDecimal;

import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Range;

public class MonBean
{

    @Range(min = 0, max = 200)
    private int age;

    @Min(1)
    @Max(200)
    private int age2;

    @NotNull
    @Min(value = 10L)
    @Max(value = 999999999999999999L)
    private Long longNumber;

    @NotNull(groups = { DecimalChecks.class })
    @DecimalMin(value = "1.0", groups = { DecimalChecks.class })
    @DecimalMax(value = "100.0", groups = { DecimalChecks.class })
    private BigDecimal decimalNumber;

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

    public Long getLongNumber()
    {
        return longNumber;
    }

    public void setLongNumber(Long longNumber)
    {
        this.longNumber = longNumber;
    }

    public void setAge2(int age2)
    {
        this.age2 = age2;
    }

    public int getAge2()
    {
        return age2;
    }

    public BigDecimal getDecimalNumber()
    {
        return decimalNumber;
    }

    public void setDecimalNumber(BigDecimal decimalNumber)
    {
        this.decimalNumber = decimalNumber;
    }
}
