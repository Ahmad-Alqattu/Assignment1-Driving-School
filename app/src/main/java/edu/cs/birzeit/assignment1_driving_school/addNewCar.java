package edu.cs.birzeit.assignment1_driving_school;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import edu.cs.birzeit.assignment1_driving_school.model.Car;
import edu.cs.birzeit.assignment1_driving_school.model.CarData;

public class addNewCar extends AppCompatActivity {
    private EditText edit4;
    private EditText edit2;
    private Spinner spinner2;
    private RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_car);
        edit2 = findViewById(R.id.edit2);
        edit4 = findViewById(R.id.edit4);
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


            newData.item.add(new Car(edt2,spn,edt4,selectedRadioButton.getText().toString()));
            Toast.makeText(this, "Add successfully", Toast.LENGTH_SHORT).show();
           finish();
        }
        else
        {
            Toast.makeText(this, "You Should full all Data", Toast.LENGTH_SHORT).show();
        }
        
    }
}