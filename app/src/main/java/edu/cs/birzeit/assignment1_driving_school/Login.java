package edu.cs.birzeit.assignment1_driving_school;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import edu.cs.birzeit.assignment1_driving_school.model.Teacher;
import edu.cs.birzeit.assignment1_driving_school.model.TeacherDa;

public class Login extends AppCompatActivity {

    private Button butLog;
    SignUP sign = new SignUP();
    private EditText email;
    private EditText pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        butLog = findViewById(R.id.butLog);
        email = findViewById(R.id.editText1);
        pass = findViewById(R.id.editText2);

    }

    public void subLog(View view) {
        String userName  = email.getText().toString();
        String password  = pass.getText().toString();
        int flag = 0;

        for (Teacher t :   TeacherDa.getInstance().Teachers) {
            System.out.println("00000000000Sajed");
            if (t.getEmail().equals(userName) && t.getPass().equals(password)) {
                Toast.makeText(this, "Add successfully", Toast.LENGTH_SHORT).show();

                flag = 1;
              break;
            }
        }
        if(flag == 1){
            Intent v= new Intent( Login.this,Home.class);
            this.startActivity(v);
        }
        else
        {
            Toast.makeText(this, "Try Again", Toast.LENGTH_SHORT).show();
        }


    }

    public void btnSignUp(View view) {
        Intent sign= new Intent( Login.this,SignUP.class);
        startActivity(sign);
    }
}