package edu.cs.birzeit.assignment1_driving_school;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import edu.cs.birzeit.assignment1_driving_school.model.Car;
import edu.cs.birzeit.assignment1_driving_school.model.CarData;

public class addNewCar extends AppCompatActivity {
    private EditText edit4;
    private EditText edit3;
    private EditText edit2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_car);
        edit2 = findViewById(R.id.edit2);
        edit3 = findViewById(R.id.edit3);
        edit4 = findViewById(R.id.edit4);
    }

    public void btnNewCar(View view) {
        String edt2 = edit2.getText().toString();
        String edt3 = edit2.getText().toString();
        String edt4 = edit2.getText().toString();
        CarData newData = null;
        if(!edt2.isEmpty() && !edt3.isEmpty() && !edt4.isEmpty() ){

            Toast.makeText(this, CarData.getInstance().item.toString(), Toast.LENGTH_SHORT).show();

            CarData.getInstance().item.add(new Car(edt2,edt3,edt4));
        }
        else
        {
            Toast.makeText(this, "You Should full all Data", Toast.LENGTH_SHORT).show();
        }
        
    }
}