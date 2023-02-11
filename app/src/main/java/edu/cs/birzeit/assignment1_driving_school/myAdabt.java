package edu.cs.birzeit.assignment1_driving_school;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.cs.birzeit.assignment1_driving_school.model.Student;
import edu.cs.birzeit.assignment1_driving_school.model.StudentDA;

public class myAdabt extends RecyclerView.Adapter<myAdabt.MyviewHolder> implements Filterable {
    List<Student> fullStudents= StudentDA.getInstance().students;
    List<Student> students= new ArrayList<>(fullStudents);


    @Override
    public  Filter getFilter() {
        return exampleFilter;
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView ID;
        TextView status;
        TextView paid;
        TextView to_pay;
        CardView card;


        public MyviewHolder(@NonNull View ItemView){
            super(ItemView);
            name=ItemView.findViewById(R.id.car_name);
            ID=ItemView.findViewById(R.id.plate_no);
            status=ItemView.findViewById(R.id.fuel);
            paid=ItemView.findViewById(R.id.paid);
            to_pay=ItemView.findViewById(R.id.gear);
            card=ItemView.findViewById(R.id.card);

        }

    }
    Context ct ;


     myAdabt(Context ct,String s1[], int img[]){
        this.ct=ct;


     }


    private Filter exampleFilter = new Filter() {


        FilterResults Fresults = new FilterResults();
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Student> filteredList = new ArrayList<>();


            if(constraint.toString().isEmpty()){
                filteredList.addAll(fullStudents);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                constraint="";
                for ( Student item : fullStudents) {
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
            students.clear();
            students.addAll((List) Fresults.values);
            notifyDataSetChanged();
        }
    };


    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ct);
        View myLayout = inflater.inflate(R.layout.cat_row, parent, false);
        return new MyviewHolder(myLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull myAdabt.MyviewHolder holder, int position) {
    holder.name.setText( students.get(position).getName());
        holder.ID.setText( "ID: "+students.get(position).getIdNumber());
        holder.status.setText( students.get(position).getStatus());
        holder.paid.setText("Paid: "+String.valueOf( students.get(position).getPaid()));
        int to_bay;
        if(students.get(position).getSessionType()=="truck")
            to_bay=110*students.get(position).getSessionNumber();
        else
            to_bay=90*students.get(position).getSessionNumber();

        holder.to_pay.setText("payable: "+String.valueOf(to_bay) );
int i=position;
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent second =new Intent(ct,student_info.class);

                second.putExtra("id", String.valueOf(i));
                second.putExtra("topay", String.valueOf(to_bay));

                ct.startActivity(second);

            }
        });
    }



    @Override
    public int getItemCount() {
        return students.size();
    }
}
