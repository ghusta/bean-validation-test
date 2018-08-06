package fr.husta.test.ex12;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.math.BigDecimal;
import java.util.Locale;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class PojoWithPositiveNegativeTest {

    private static Validator validator;

    @BeforeClass
    public static void initGlobal()
    {
        // set default locale to FR -> UTF-8 problem with IntelliJ ?!?
        Locale.setDefault(Locale.ENGLISH);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testOK() throws Exception
    {
        Set<ConstraintViolation<PojoWithPositiveNegative>> constraintViolations = null;

        PojoWithPositiveNegative pojo = new PojoWithPositiveNegative();
        pojo.setNumberPos1(new BigDecimal("10.0"));
        pojo.setNumberStrictlyPos2(2L);
        pojo.setNumberNeg1(new BigDecimal("-10.0"));

        constraintViolations = validator.validate(pojo);

        assertThat(constraintViolations).isEmpty();
    }

}