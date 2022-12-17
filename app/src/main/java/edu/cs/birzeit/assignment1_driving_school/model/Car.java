package edu.cs.birzeit.assignment1_driving_school.model;

public class Car {
    private String carName;
    private String fuelType ;
    private String typeLicense;

    public Car(String carName, String fuelType, String typeLicense) {
        this.carName = carName;
        this.fuelType = fuelType;
        this.typeLicense = typeLicense;
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

    @Override
    public String toString() {
        return "CarData{" +
                "carName='" + carName + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", typeLicense='" + typeLicense + '\'' +
                '}';
    }
}
