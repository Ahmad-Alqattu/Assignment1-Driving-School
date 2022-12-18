package edu.cs.birzeit.assignment1_driving_school.model;

import java.util.ArrayList;
import java.util.List;

    public class CarData implements  InfoCar{

        public static CarData cardata_1;
        public static CarData getInstance()
        {
            if (cardata_1 == null)
                cardata_1 = new CarData();

            return cardata_1;
        }

   public static List<Car> item;

    public CarData(){
        item = new ArrayList<>();
        item.add(new Car("Hyundai Accent 2014","diesel","gear"));
        item.add(new Car("Hyundai Accent 2022","benzin","automatic"));

        item.add(new Car("Skoda","diesel","gear"));
        item.add(new Car("skoda","benzin","automatic"));

        item.add(new Car("kia","diesel","gear"));
        item.add(new Car("kia","benzin","automatic"));

        item.add(new Car("Motorcycle","benzin","gear"));

        item.add(new Car("bus","diesel","gear"));

    }


        @Override
        public  List<String> getCategories() {
            List<String> cat = new ArrayList<>();
            for (Car i : item) {
                cat.add(i.getCarName());
                }

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
