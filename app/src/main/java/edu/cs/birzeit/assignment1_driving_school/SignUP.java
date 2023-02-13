package edu.cs.birzeit.assignment1_driving_school;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TimePicker;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;

import edu.cs.birzeit.assignment1_driving_school.model.Teacher;
import edu.cs.birzeit.assignment1_driving_school.model.TeacherDa;

public class SignUP extends AppCompatActivity {
    private EditText editText2;
    private EditText editText3;
    private EditText editPassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        editText2 = findViewById(R.id.edit2);
        editText3 = findViewById(R.id.edit3);
        editPassword = findViewById(R.id.editPassword);


    }

    public void sign(View view) {
        String name = editText2.getText().toString();
        String email = editText3.getText().toString();
        String pass = editPassword.getText().toString();

        if(!name.isEmpty() && !email.isEmpty() && editPassword.getText().toString()!=""){


            FirebaseDatabase fire = FirebaseDatabase.getInstance();
            DatabaseReference myRef = fire.getReference("teachers");

            myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // Get the number of child nodes
                    long numOfCars = dataSnapshot.getChildrenCount();

                    // Use the setValue method to save the car object in the database with the incremented identifier as the child name
                    myRef.child("teacher" + (numOfCars + 1)).setValue(new Teacher(name,email,pass));
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }



            });
            Toast.makeText(this, "Add successfully", Toast.LENGTH_SHORT).show();
            finish();
        }
        else{
            Toast.makeText(this, "You Should full all data", Toast.LENGTH_SHORT).show();
        }
    }
}