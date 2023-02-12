package edu.cs.birzeit.assignment1_driving_school;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class car_info extends AppCompatActivity {
    TextView name;
    TextView fuel;
    TextView license;
    TextView plate;
    TextView year;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_info);
    }
    public void setData(){
        name = findViewById(R.id.textView10);
        fuel = findViewById(R.id.textView11);
        license  = findViewById(R.id.textView12);
        plate = findViewById(R.id.textView13);
        year = findViewById(R.id.textView14);
    }
}