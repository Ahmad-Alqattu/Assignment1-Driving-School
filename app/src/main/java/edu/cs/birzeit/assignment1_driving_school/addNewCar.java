package edu.cs.birzeit.assignment1_driving_school;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import edu.cs.birzeit.assignment1_driving_school.model.Car;
import edu.cs.birzeit.assignment1_driving_school.model.CarData;

public class addNewCar extends AppCompatActivity {
    private EditText edit4;
    private EditText edit2;
    private EditText year;
    private Spinner spinner2;
    private RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_car);
        edit2 = findViewById(R.id.edit2);
        edit4 = findViewById(R.id.edit4);
        year = findViewById(R.id.year);
        spinner2 = findViewById(R.id.spinner2);
        radioGroup = findViewById(R.id.radioGroup);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    CarData newData = null;
    public void btnNewCar(View view) {
        String edt2 = edit2.getText().toString();
        String spn = spinner2.getSelectedItem().toString();
        String edt4 = edit4.getText().toString();
        if(!edt2.isEmpty() && !spn.isEmpty() && !edt4.isEmpty() && radioGroup.getCheckedRadioButtonId()!=-1){
            RadioButton selectedRadioButton = findViewById(radioGroup.getCheckedRadioButtonId());


//            newData.item.add(new Car(edt2,spn,edt4,selectedRadioButton.getText().toString(),Integer.parseInt(year.getText().toString())));
            FirebaseDatabase fire = FirebaseDatabase.getInstance();
            DatabaseReference myRef = fire.getReference("cars");

            myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // Get the number of child nodes
                    long numOfCars = dataSnapshot.getChildrenCount();

                    // Use the setValue method to save the car object in the database with the incremented identifier as the child name
                    myRef.child("car" + (numOfCars + 1)).setValue(new Car(edt2,spn,edt4,selectedRadioButton.getText().toString(),Integer.parseInt(year.getText().toString())));
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Handle error
                }
            });
            Toast.makeText(this, "Add successfully", Toast.LENGTH_SHORT).show();
           finish();
        }
        else
        {
            Toast.makeText(this, "You Should full all Data", Toast.LENGTH_SHORT).show();
        }
        
    }
}