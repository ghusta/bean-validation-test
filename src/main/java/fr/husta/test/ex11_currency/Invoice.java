package fr.husta.test.ex11_currency;

import org.hibernate.validator.constraints.Currency;

import javax.money.MonetaryAmount;
import jakarta.validation.constraints.DecimalMax;

/**
 * For {@link MonetaryAmount}, see classes <i>*ValidatorForMonetaryAmount</i>,
 * like {@link org.hibernate.validator.internal.constraintvalidators.bv.money.CurrencyValidatorForMonetaryAmount}
 * or {@link org.hibernate.validator.internal.constraintvalidators.bv.money.MaxValidatorForMonetaryAmount}.
 */
public class Invoice
{

    @DecimalMax("1000.00")
    @Currency("EUR")
    private MonetaryAmount totalAmount;

    public Invoice()
    {
    }

    public MonetaryAmount getTotalAmount()
    {
        return totalAmount;
    }

    public void setTotalAmount(MonetaryAmount totalAmount)
    {
        this.totalAmount = totalAmount;
    }

}
