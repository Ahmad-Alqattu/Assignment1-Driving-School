package edu.cs.birzeit.assignment1_driving_school;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Home extends AppCompatActivity {
String s1[];
RecyclerView category_btn;
int img[]={R.drawable.add_user,R.drawable.drive,R.drawable.statas,R.drawable.cars};
    int pages[]={R.drawable.add_user,R.drawable.drive,R.drawable.statas,R.drawable.cars};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//        s1=getResources().getStringArray(R.array.cat_btn);
//        category_btn=findViewById(R.id.recyclerView);
//        myAdabt myadabt= new myAdabt(this,s1,img);
//        category_btn.setAdapter(myadabt);
//        category_btn.setLayoutManager(new LinearLayoutManager(this));
    }
}