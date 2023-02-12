package edu.cs.birzeit.assignment1_driving_school.model;

public class Car {
    private String carName;
    private String fuelType ;
    private String typeLicense;
    private String plateNo;
    private int year;

    public Car() {
        // Empty constructor
    }
    public Car(String carName, String fuelType, String plateNo, String typeLicense, int year) {
        this.carName = carName;
        this.fuelType = fuelType;
        this.typeLicense = typeLicense;
        this.plateNo = plateNo;
        this.year = year;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getTypeLicense() {
        return typeLicense;
    }

    public void setTypeLicense(String typeLicense) {
        this.typeLicense = typeLicense;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    @Override
    public String toString() {
        return
                "Car Name='" + carName + '\n' +
                "Fuel Type='" + fuelType + '\n' +
                "Type License='" + typeLicense + '\n' +
                "Plate Number='" + plateNo + '\n'+" "+year;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
