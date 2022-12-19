package edu.cs.birzeit.assignment1_driving_school;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.cs.birzeit.assignment1_driving_school.model.Student;
import edu.cs.birzeit.assignment1_driving_school.model.StudentDA;

public class myAdabt extends RecyclerView.Adapter<myAdabt.MyviewHolder> {


    public class MyviewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView ID;
        TextView status;
        TextView paid;
        TextView to_pay;
        CardView card;

        public MyviewHolder(@NonNull View ItemView){
            super(ItemView);
            name=ItemView.findViewById(R.id.category);
            ID=ItemView.findViewById(R.id.id);
            status=ItemView.findViewById(R.id.status);
            paid=ItemView.findViewById(R.id.paid);
            to_pay=ItemView.findViewById(R.id.to_bay);
            card=ItemView.findViewById(R.id.card);

        }

    }
     List<Student> students= StudentDA.getInstance().students;;
    Context ct ;


     myAdabt(Context ct,String s1[], int img[]){
        this.ct=ct;

    }

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
        holder.ID.append( students.get(position).getIdNumber());
        holder.status.setText( students.get(position).getStatus());
        holder.paid.append(String.valueOf( students.get(position).getPaid()));
        int to_bay;
        if(students.get(position).getSessionType()=="truck")
            to_bay=110*students.get(position).getSessionNumber();
        else
            to_bay=90*students.get(position).getSessionNumber();

        holder.to_pay.append(String.valueOf(to_bay) );

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent second =new Intent(ct,student_info.class);
                second.putExtra("id", holder.getAdapterPosition());
                ct.startActivity(second);

            }
        });
    }


    @Override
    public int getItemCount() {
        return students.size();
    }
}
