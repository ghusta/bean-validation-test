package fr.husta.test.ex10_jodatime;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Locale;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonWithJodaTimeTest {

    private static Validator validator;

    @BeforeClass
    public static void initGlobal() {
        // set default locale to FR -> UTF-8 problem with IntelliJ ?!?
        Locale.setDefault(Locale.ENGLISH);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testDob_OK() throws Exception {
        Set<ConstraintViolation<PersonWithJodaTime>> constraintViolations = null;

        PersonWithJodaTime myPojo = new PersonWithJodaTime();
        myPojo.setName("TOTO");
        myPojo.setDob(LocalDate.parse("1995-08-31"));
        myPojo.setDateTime(DateTime.now().plusDays(15));

        constraintViolations = validator.validate(myPojo);

        assertThat(constraintViolations).isEmpty();
    }

    @Test
    public void testDob_KO() throws Exception {
        Set<ConstraintViolation<PersonWithJodaTime>> constraintViolations = null;

        PersonWithJodaTime myPojo = new PersonWithJodaTime();
        myPojo.setName("Too young");
        myPojo.setDob(LocalDate.parse("2015-08-31"));
        myPojo.setDateTime(DateTime.now().minusMinutes(10));

        constraintViolations = validator.validate(myPojo);

        assertThat(constraintViolations).isNotEmpty();
    }

}