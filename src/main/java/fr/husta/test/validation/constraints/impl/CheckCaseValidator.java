package fr.husta.test.validation.constraints.impl;

import fr.husta.test.validation.constraints.CaseMode;
import fr.husta.test.validation.constraints.CheckCase;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CheckCaseValidator implements ConstraintValidator<CheckCase, String>
{

    private CaseMode caseMode;

    @Override
    public void initialize(CheckCase constraintAnnotation)
    {
        this.caseMode = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String object, ConstraintValidatorContext constraintContext)
    {
        if (object == null)
            return true;

        if (caseMode == CaseMode.UPPER)
            return object.equals(object.toUpperCase());
        else
            return object.equals(object.toLowerCase());
    }

}
