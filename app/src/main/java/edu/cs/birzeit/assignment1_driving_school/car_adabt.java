package edu.cs.birzeit.assignment1_driving_school;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.checkerframework.checker.guieffect.qual.UI;

import java.util.ArrayList;
import java.util.List;

import edu.cs.birzeit.assignment1_driving_school.model.Car;
import edu.cs.birzeit.assignment1_driving_school.model.CarData;
import edu.cs.birzeit.assignment1_driving_school.model.Student;
import edu.cs.birzeit.assignment1_driving_school.model.StudentDA;


    public class car_adabt extends RecyclerView.Adapter<car_adabt.MyviewHolder> implements Filterable {
        List<Car> fullCars;
        List<Car> Cars ;


        @Override
        public Filter getFilter() {
            return exampleFilter;
        }

        public class MyviewHolder extends RecyclerView.ViewHolder {
            TextView name;
            TextView plate;
            TextView gear;
            TextView fuel;
            ImageView to_pay;
            CardView card;


            public MyviewHolder(@NonNull View ItemView){
                super(ItemView);
       name=ItemView.findViewById(R.id.car_name);
                plate=ItemView.findViewById(R.id.plate_no);
                fuel=ItemView.findViewById(R.id.fuel);
                gear=ItemView.findViewById(R.id.gear);
                card=ItemView.findViewById(R.id.card);

            }

        }
        Context ct ;


        car_adabt(Context ct , ArrayList<Car> Cars){
            this.ct=ct;
            this.Cars = Cars;
//            fullCars = new ArrayList<>(Cars);

        }

        void full(ArrayList<Car> Cars){
            fullCars = new ArrayList<>(Cars);

        }


        private Filter exampleFilter = new Filter() {


            FilterResults Fresults = new FilterResults();
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                List<Car> filteredList = new ArrayList<>();


                if(constraint.toString().isEmpty()){
                    filteredList.addAll(fullCars);
                } else {
                    String filterPattern = constraint.toString().toLowerCase().trim();
                    constraint="";
                    for ( Car item : fullCars) {
                        if (item.toString().toLowerCase().contains(filterPattern)) {
                            filteredList.add(item);
                        }

                    }
                }

                Fresults.values = filteredList;

                return Fresults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                Cars.clear();
                Cars.addAll((List) Fresults.values);
                notifyDataSetChanged();
            }
        };


        @NonNull
        @Override
        public car_adabt.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(ct);
            View myLayout = inflater.inflate(R.layout.car_card, parent, false);
            return new car_adabt.MyviewHolder(myLayout);
        }

        @Override
        public void onBindViewHolder(@NonNull car_adabt.MyviewHolder holder, int position) {
            holder.name.setText( Cars.get(position).getCarName()+" "+ Cars.get(position).getYear());
            holder.plate.setText( ""+Cars.get(position).getTypeLicense());
            holder.gear.setText( "plate No:"+Cars.get(position).getPlateNo());
            holder.fuel.setText(String.valueOf( Cars.get(position).getFuelType()));

            holder.card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent second =new Intent(ct,student_info.class);
//
//                    second.putExtra("id", String.valueOf("d"));
//                    second.putExtra("topay", String.valueOf("to_bay"));

                    ct.startActivity(second);

                }
            });
        }



        @Override
        public int getItemCount() {
            return Cars.size();
        }
    }




