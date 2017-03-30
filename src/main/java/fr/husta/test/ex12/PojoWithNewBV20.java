package fr.husta.test.ex12;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * New constraints in Bean Validation 2.0.
 */
public class PojoWithNewBV20 {

    @NotBlank
    @NotNull
    private String field1;

    @NotEmpty
    @NotNull
    private String field2;

    @Email
    @NotNull
    private String field3;

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }
}
