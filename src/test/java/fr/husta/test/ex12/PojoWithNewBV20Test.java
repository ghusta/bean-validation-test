package fr.husta.test.ex12;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Locale;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class PojoWithNewBV20Test {

    private static Validator validator;

    @BeforeClass
    public static void initGlobal() {
        // set default locale to FR -> UTF-8 problem with IntelliJ ?!?
        Locale.setDefault(Locale.ENGLISH);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testOK() throws Exception {
        Set<ConstraintViolation<PojoWithNewBV20>> constraintViolations = null;

        PojoWithNewBV20 pojo = new PojoWithNewBV20();
        pojo.setField1("hello");
        pojo.setField2("hello");
        pojo.setField3("hello@yahoo.com");

        constraintViolations = validator.validate(pojo);

        assertThat(constraintViolations).isEmpty();
    }

}