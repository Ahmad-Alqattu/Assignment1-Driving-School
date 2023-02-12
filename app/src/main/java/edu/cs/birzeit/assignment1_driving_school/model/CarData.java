package edu.cs.birzeit.assignment1_driving_school.model;

import java.util.ArrayList;
import java.util.List;

    public class CarData implements  InfoCar{

        private static CarData cardata_1;
        public static CarData getInstance()
        {
            if (cardata_1 == null)
                cardata_1 = new CarData();
            return cardata_1;
        }

   public List<Car> item;

    public CarData(){
        item = new ArrayList<>();
        item.add(new Car("Hyundai Accent","diesel","277-888-99","gear" ,2017));
        item.add(new Car("Hyundai i30","benzin","277-888-55","automatic",2018));

        item.add(new Car("Skoda octavia","diesel","277-111-33","gear",2020));
        item.add(new Car("skoda kodiq","benzin","277-111-50","automatic",2019));

        item.add(new Car("kia k5","diesel","222-111-00","gear",2014));
        item.add(new Car("kia sportage","benzin","666-111-44","automatic",2015));

        item.add(new Car("volvo ","diesel","225-178-93","gear", 2023));

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
