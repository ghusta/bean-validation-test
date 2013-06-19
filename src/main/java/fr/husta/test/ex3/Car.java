package fr.husta.test.ex3;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Car
{

    @NotNull
    private String manufacturer;

    @NotNull
    @Size(min = 2, max = 14)
    private String licensePlate;

    @Min(2)
    private int seatCount;

    @AssertTrue(message = "The car has to pass the vehicle inspection first", groups = CarChecks.class)
    private boolean passedVehicleInspection;

    @Valid
    private Driver driver;

    /**
     * 
     * @param manufacturer
     * @param licencePlate
     * @param seatCount
     */
    public Car(String manufacturer, String licencePlate, int seatCount)
    {
        this.manufacturer = manufacturer;
        this.licensePlate = licencePlate;
        this.seatCount = seatCount;
    }

    public String getManufacturer()
    {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer)
    {
        this.manufacturer = manufacturer;
    }

    public String getLicensePlate()
    {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate)
    {
        this.licensePlate = licensePlate;
    }

    public int getSeatCount()
    {
        return seatCount;
    }

    public void setSeatCount(int seatCount)
    {
        this.seatCount = seatCount;
    }

    public boolean isPassedVehicleInspection()
    {
        return passedVehicleInspection;
    }

    public void setPassedVehicleInspection(boolean passedVehicleInspection)
    {
        this.passedVehicleInspection = passedVehicleInspection;
    }

    public Driver getDriver()
    {
        return driver;
    }

    public void setDriver(Driver driver)
    {
        this.driver = driver;
    }

}
