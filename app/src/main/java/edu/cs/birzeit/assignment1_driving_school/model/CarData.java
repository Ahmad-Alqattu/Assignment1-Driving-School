package edu.cs.birzeit.assignment1_driving_school.model;

import java.util.ArrayList;
import java.util.List;

    public class CarData implements  InfoCar{

    List<Car> item;

    public CarData(){
        item = new ArrayList<>();
        item.add(new Car("Hyundai Accent","diesel","gear"));
        item.add(new Car("Hyundai Accent","benzin","automatic"));

        item.add(new Car("Skoda","diesel","gear"));
        item.add(new Car("skoda","benzin","automatic"));

        item.add(new Car("kia","diesel","gear"));
        item.add(new Car("kia","benzin","automatic"));

        item.add(new Car("Motorcycle","benzin","gear"));

        item.add(new Car("bus","diesel","gear"));

    }


        @Override
        public List<String> getCategories() {
            List<String> cat = new ArrayList<>();
            cat.add("Hyundai Accent");
            cat.add("Skoda");
            cat.add("kia");
            cat.add("Motorcycle");
            cat.add("bus");
            return  cat;
        }

        @Override
        public List<Car> getItems(String cat) {
            List<Car> result = new ArrayList<>();
            for (Car i : item) {
                if(i.getCarName().equals(cat)){
                    result.add(i);
                }
            }
            return  result;
        }
    }
