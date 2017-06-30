package fr.husta.test.ex12;

import javax.validation.constraints.Negative;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

/**
 * Test for @{@link Positive}, @{@link Negative} from Bean Validation 2.0.
 */
public class PojoWithPositiveNegative {

    @PositiveOrZero
    @NotNull
    private BigDecimal numberPos1;

    @Positive
    @NotNull
    private Long numberStrictlyPos2;

    @NegativeOrZero
    @NotNull
    private BigDecimal numberNeg1;

    public BigDecimal getNumberPos1() {
        return numberPos1;
    }

    public void setNumberPos1(BigDecimal numberPos1) {
        this.numberPos1 = numberPos1;
    }

    public Long getNumberStrictlyPos2() {
        return numberStrictlyPos2;
    }

    public void setNumberStrictlyPos2(Long numberStrictlyPos2) {
        this.numberStrictlyPos2 = numberStrictlyPos2;
    }

    public BigDecimal getNumberNeg1() {
        return numberNeg1;
    }

    public void setNumberNeg1(BigDecimal numberNeg1) {
        this.numberNeg1 = numberNeg1;
    }
}
