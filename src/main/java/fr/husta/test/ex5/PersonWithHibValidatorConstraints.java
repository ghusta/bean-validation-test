package fr.husta.test.ex5;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


/**
 * Uses Hibernate Validator custom constraints : @NotEmpty and @NotBlank.
 * 
 * @author HUSTA
 *
 * @deprecated Not anymore Hibernate Validator custom constraints
 */
@Deprecated
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
