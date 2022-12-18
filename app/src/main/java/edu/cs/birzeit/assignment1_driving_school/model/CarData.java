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
        item.add(new Car("Hyundai Accent 2014","diesel","277-888-999","gear"));
        item.add(new Car("Hyundai Accent 2022","benzin","277-888-555","automatic"));

        item.add(new Car("Skoda","diesel","277-111-333","gear"));
        item.add(new Car("skoda","benzin","277-111-333","automatic"));

        item.add(new Car("kia","diesel","222-111-000","gear"));
        item.add(new Car("kia","benzin","666-111-444","automatic"));

        item.add(new Car("Motorcycle","benzin","666-111-777","gear"));

        item.add(new Car("bus","diesel","225-178-458","gear"));

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
