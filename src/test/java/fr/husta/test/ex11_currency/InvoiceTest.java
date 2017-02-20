package fr.husta.test.ex11_currency;

import org.javamoney.moneta.Money;
import org.javamoney.moneta.RoundedMoney;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import javax.money.Monetary;
import javax.money.MonetaryContext;
import javax.money.MonetaryContextBuilder;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class InvoiceTest
{

    private static Validator validator;

    @BeforeClass
    public static void initGlobal()
    {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testOK() throws Exception
    {
        Set<ConstraintViolation<Invoice>> constraintViolations = null;

        Invoice invoice = new Invoice();
        invoice.setTotalAmount(Money.of(990.999, "EUR"));

        constraintViolations = validator.validate(invoice);

        assertTrue(constraintViolations.size() == 0);
    }

    @Test
    public void testKO_currency() throws Exception
    {
        Set<ConstraintViolation<Invoice>> constraintViolations = null;

        Invoice invoice = new Invoice();
        invoice.setTotalAmount(Money.of(990.999, "USD"));

        constraintViolations = validator.validate(invoice);

        assertTrue(constraintViolations.size() > 0);
    }

    @Test
    @Ignore("Rounding problem")
    public void testKO_max_with_rounding() throws Exception
    {
        Set<ConstraintViolation<Invoice>> constraintViolations = null;

        Invoice invoice = new Invoice();
        invoice.setTotalAmount(Money.of(new BigDecimal("1000.0000000000000001"), "EUR"));

        constraintViolations = validator.validate(invoice);

        assertTrue(constraintViolations.size() > 0);
    }

    @Test
    @Ignore
    public void testKO_max() throws Exception
    {
        Set<ConstraintViolation<Invoice>> constraintViolations = null;

        Invoice invoice = new Invoice();
        MonetaryContext monetaryContext = MonetaryContextBuilder.of().setMaxScale(2).setPrecision(2).build();
        MathContext mc = new MathContext(2, RoundingMode.HALF_EVEN);
        invoice.setTotalAmount(RoundedMoney.of(new BigDecimal(" 1000.0000000000000001"),
                Monetary.getCurrency("EUR"), mc));

        constraintViolations = validator.validate(invoice);

        assertTrue(constraintViolations.size() > 0);
    }

}