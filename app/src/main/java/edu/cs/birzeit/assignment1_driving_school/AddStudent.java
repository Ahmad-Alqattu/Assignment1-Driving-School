package edu.cs.birzeit.assignment1_driving_school;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        setupView();
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
    StudentDA newData = null;

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

        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String studentNamee = String.valueOf(studentName.getText().toString());
                String IDNumberr = String.valueOf(IDNumber.getText().toString());
                String phoneNumberr = String.valueOf(phoneNumber.getText().toString());
                Student s = new Student(studentNamee,
                        IDNumberr, phoneNumberr,
                        maleOrFemale(),sessionType());
                newData.students.add(s);
            }
        });
    }

}
