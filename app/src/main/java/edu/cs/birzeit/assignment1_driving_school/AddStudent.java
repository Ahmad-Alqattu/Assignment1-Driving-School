package edu.cs.birzeit.assignment1_driving_school;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import edu.cs.birzeit.assignment1_driving_school.model.Car;
import edu.cs.birzeit.assignment1_driving_school.model.Student;
import edu.cs.birzeit.assignment1_driving_school.model.StudentDA;


public class AddStudent extends AppCompatActivity{

    private Button addStudent;
    private EditText studentName;
    private EditText IDNumber;
    private EditText phoneNumber;
    private RadioButton maleBtn;
    private RadioButton femaleBtn;
    private RadioButton automaticBtn;
    private RadioButton manualBtn;
    private RadioButton truckBtn;
    private RadioGroup srb;
    private RadioGroup grb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        setupView();
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


    public String maleOrFemale(){
        if (maleBtn.isChecked())
            return "male";
        else
            return "female";
    }

    public String sessionType(){
        if (automaticBtn.isChecked())
            return "automatic";
        else if (manualBtn.isChecked())
            return "manual";
        else
            return "truck";
    }

    public void setupView() {
        addStudent = findViewById(R.id.addStudent);
        studentName = findViewById(R.id.studentName);
        IDNumber = findViewById(R.id.IDNumber);
        phoneNumber = findViewById(R.id.phoneNumber);
        maleBtn = findViewById(R.id.maleBtn);
        femaleBtn = findViewById(R.id.femaleBtn);
        automaticBtn = findViewById(R.id.automaticBtn);
        manualBtn = findViewById(R.id.manualBtn);
        truckBtn = findViewById(R.id.truckBtn);
        grb= findViewById(R.id.grb);
        srb= findViewById(R.id.srb);


        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String studentNamee = String.valueOf(studentName.getText().toString());
                String IDNumberr = String.valueOf(IDNumber.getText().toString());
                String phoneNumberr = String.valueOf(phoneNumber.getText().toString());

                if(!studentNamee.isEmpty() && !IDNumberr.isEmpty() && !phoneNumberr.isEmpty() && srb.getCheckedRadioButtonId()!=-1&&grb.getCheckedRadioButtonId()!=-1){
                    Student s = new Student(studentNamee,
                            IDNumberr, phoneNumberr,
                            maleOrFemale(),sessionType());
                    StudentDA.getInstance().addStudentsToTable(s);

                    Toast.makeText(AddStudent.this, "Add successfully", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else
                {
                    Toast.makeText(AddStudent.this, "You Should full all Data", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

}
