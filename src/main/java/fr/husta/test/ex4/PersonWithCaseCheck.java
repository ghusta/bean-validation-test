package fr.husta.test.ex4;

import jakarta.validation.constraints.NotNull;

import fr.husta.test.validation.constraints.CaseMode;
import fr.husta.test.validation.constraints.CheckCase;
import fr.husta.test.validation.constraints.money.MonetaryAmountPositive;

import java.math.BigDecimal;

public class PersonWithCaseCheck {

    @NotNull
    @CheckCase(value = CaseMode.UPPER)
    private String name;

    @NotNull
    @CheckCase(value = CaseMode.LOWER)
    private String firstName;

    @MonetaryAmountPositive
    private BigDecimal amount;

    public PersonWithCaseCheck() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}
