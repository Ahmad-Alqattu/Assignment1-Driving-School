package edu.cs.birzeit.assignment1_driving_school;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import edu.cs.birzeit.assignment1_driving_school.model.CarData;
import edu.cs.birzeit.assignment1_driving_school.model.Teacher;
import edu.cs.birzeit.assignment1_driving_school.model.TeacherDa;

public class Login extends AppCompatActivity {

    public static final String NAME = "NAME";
    public static final String PASS = "PASS";
    public static final String FLAG = "FLAG";
    private Button butLog;
    private EditText email;
    private EditText pass;
    private CheckBox checkBox;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        butLog = findViewById(R.id.butLog);
        email = findViewById(R.id.editText1);
        pass = findViewById(R.id.editText2);
        checkBox = findViewById(R.id.checkBox);
        setupSharedPreference();
        checkPrefs();

    }

    private void checkPrefs(){
        Boolean flag = prefs.getBoolean(FLAG, false);
        if(flag){
            String name = prefs.getString(NAME,"");
            String pas = prefs.getString(PASS,"");
            email.setText(name);
            pass.setText(pas);
            checkBox.setChecked(true);
        }
    }

    private void setupSharedPreference(){
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();
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

        if(checkBox.isChecked()){
            String nam = email.getText().toString();
            String pas = pass.getText().toString();
            editor.putString(NAME, nam);
            editor.putString(PASS, pas);
            editor.putBoolean(FLAG,true);
            editor.commit();
        }

    }

    public void btnSignUp(View view) {
        Intent s = new Intent(Login.this,SignUP.class);
        startActivity(s);

    }
}