package edu.cs.birzeit.assignment1_driving_school;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import edu.cs.birzeit.assignment1_driving_school.model.CarData;
import edu.cs.birzeit.assignment1_driving_school.model.Teacher;
import edu.cs.birzeit.assignment1_driving_school.model.TeacherDa;

public class Login extends AppCompatActivity {

    private Button butLog;
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

        for (Teacher t : TeacherDa.getInstance().Teachers) {

            if (t.getEmail().equalsIgnoreCase(userName) && t.getPass().equals(password)) {
                Toast.makeText(this, "Login successfully", Toast.LENGTH_SHORT).show();
                Intent v= new Intent( Login.this,Home.class);
                v.putExtra("tname",TeacherDa.getInstance().searchByEmail(userName));
                this.startActivity(v);

                flag = 1;
              break;
            }
        }

        if(flag == 1){
            finish();

        }
        else
        {
            Toast.makeText(this, "Try Again", Toast.LENGTH_SHORT).show();
        }

    }

    public void btnSignUp(View view) {
        Intent s = new Intent(Login.this,SignUP.class);
        startActivity(s);

    }
}