package fr.husta.test.ex10_jodatime;

import fr.husta.test.validation.constraints.CaseMode;
import fr.husta.test.validation.constraints.CheckCase;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

public class PersonWithJodaTime {

    private String name;

    private String firstName;

    @Past
    private LocalDate dob;

    @Future
    private DateTime dateTime;


    public PersonWithJodaTime() {
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

}


