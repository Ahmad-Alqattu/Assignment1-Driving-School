package edu.cs.birzeit.assignment1_driving_school;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.checkerframework.common.reflection.qual.NewInstance;

import java.util.ArrayList;

import edu.cs.birzeit.assignment1_driving_school.model.Car;
import edu.cs.birzeit.assignment1_driving_school.model.CarData;
import edu.cs.birzeit.assignment1_driving_school.model.Session;
import edu.cs.birzeit.assignment1_driving_school.model.Student;
import edu.cs.birzeit.assignment1_driving_school.model.Teacher;
import edu.cs.birzeit.assignment1_driving_school.model.TeacherDa;

public class Login extends AppCompatActivity {

    public static final String NAME = "NAME";
    public static final String PASS = "PASS";
    public static final String FLAG = "FLAG";
    int flag = 0;
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
    ;

    }

    private void checkPrefs(){
        Boolean flag = prefs.getBoolean(FLAG, false);
        if(flag){
            String name = prefs.getString(NAME,"");
            String pas = prefs.getString(PASS,"");
            email.setText(name);
            pass.setText(pas);
            checkBox.setChecked(true);
            View v= new View(Login.this);
            subLog(v);
        }
    }

    private void setupSharedPreference(){
        Context context = getApplicationContext();

        prefs = PreferenceManager.getDefaultSharedPreferences(context);
        editor = prefs.edit();
    }
    public void subLog(View view) {
        String userName  = email.getText().toString();
        String password  = pass.getText().toString();

        FirebaseDatabase fire = FirebaseDatabase.getInstance();
        DatabaseReference myRef = fire.getReference("teachers");
             ArrayList<Teacher> T = new ArrayList<>();
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot carSnapshot : dataSnapshot.getChildren()) {
                    Teacher teacher = carSnapshot.getValue(Teacher.class);
                    T.add(teacher);
                }
                for (Teacher t : T) {

                    if (t.getEmail().equalsIgnoreCase(userName) && t.getPass().equals(password)) {
                        Toast.makeText(Login.this, "Login successfully", Toast.LENGTH_SHORT).show();
                        Intent v= new Intent( Login.this,Home.class);
                        v.putExtra("tname",TeacherDa.getInstance().searchByEmail(userName));
                        Login.this.startActivity(v);

                        flag = 1;
                        finish();
                        break;
                    }
                }

                if(flag == 1){

                }
                else
                {
                    Toast.makeText(Login.this, "Try Again", Toast.LENGTH_SHORT).show();
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

            @Override
            public void onCancelled(DatabaseError error) {// Handle error
                Toast.makeText(Login.this, "No connection", Toast.LENGTH_SHORT).show();

            }
        });



    }

    public void btnSignUp(View view) {
        Intent s = new Intent(Login.this,SignUP.class);
        startActivity(s);

    }
}