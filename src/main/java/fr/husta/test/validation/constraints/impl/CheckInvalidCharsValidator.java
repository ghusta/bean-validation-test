package fr.husta.test.validation.constraints.impl;

import fr.husta.test.validation.constraints.CheckInvalidChars;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 */
public class CheckInvalidCharsValidator
        implements ConstraintValidator<CheckInvalidChars, CharSequence> {

    private String invalidChars;

    @Override
    public void initialize(CheckInvalidChars constraintAnnotation) {
        this.invalidChars = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        if (invalidChars != null) {
            char[] liste = invalidChars.toCharArray();
            for (char c : liste) {
                if (StringUtils.contains(value.toString(), c)) {
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }

}
