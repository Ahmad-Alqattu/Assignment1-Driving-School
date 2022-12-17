package edu.cs.birzeit.assignment1_driving_school;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class myAdabt extends RecyclerView.Adapter<myAdabt.MyviewHolder> {
    public class MyviewHolder extends RecyclerView.ViewHolder {
            TextView t1;
            ImageView img;
        public MyviewHolder(@NonNull View ItemView){
            super(ItemView);
            t1=ItemView.findViewById(R.id.category);
            img=ItemView.findViewById(R.id.icon);
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
    holder.t1.setText(st[position]);
        holder.img.setImageResource(img[position]);

    }


    @Override
    public int getItemCount() {
        return st.length;
    }
}
