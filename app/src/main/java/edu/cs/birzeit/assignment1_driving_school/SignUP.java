package edu.cs.birzeit.assignment1_driving_school;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import edu.cs.birzeit.assignment1_driving_school.model.Teacher;

public class SignUP extends AppCompatActivity {
  public  ArrayList<Teacher> teachersList = new ArrayList<>();
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
            teachersList.add(new Teacher(name,email,pass));

            Toast.makeText(this, "Add successfully", Toast.LENGTH_SHORT).show();
            finish();
        }
        else{
            Toast.makeText(this, "You Should full all data", Toast.LENGTH_SHORT).show();
        }
    }
}