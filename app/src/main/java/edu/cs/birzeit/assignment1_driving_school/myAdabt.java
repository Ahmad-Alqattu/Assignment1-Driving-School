package edu.cs.birzeit.assignment1_driving_school;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;

public class myAdabt extends RecyclerView.Adapter<myAdabt.MyviewHolder> {

    public class MyviewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView ID;
        TextView gender;
        TextView courses;
        TextView date;

        public MyviewHolder(@NonNull View ItemView){
            super(ItemView);
            name=ItemView.findViewById(R.id.category);
        }

    }

    String st[];
    Context ct ;
    int img[];

     myAdabt(Context ct,String s1[], int img[]){
        st=s1;
        this.ct=ct;
        this.img=img;
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
    holder.name.append(st[position]);

    }


    @Override
    public int getItemCount() {
        return st.length;
    }
}
