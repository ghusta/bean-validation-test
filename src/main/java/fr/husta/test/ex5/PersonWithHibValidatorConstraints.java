package fr.husta.test.ex5;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


/**
 * Uses Hibernate Validator custom constraints : @NotEmpty and @NotBlank.
 * 
 * @author HUSTA
 *
 */
public class PersonWithHibValidatorConstraints
{

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotBlank
    private String firstName;

    public PersonWithHibValidatorConstraints()
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
