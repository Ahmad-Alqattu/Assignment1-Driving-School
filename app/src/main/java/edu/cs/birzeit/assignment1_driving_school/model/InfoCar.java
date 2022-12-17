package edu.cs.birzeit.assignment1_driving_school.model;

import java.util.List;

public interface InfoCar {
    List<String> getCategories();
    List<Car> getItems(String cat);
}
