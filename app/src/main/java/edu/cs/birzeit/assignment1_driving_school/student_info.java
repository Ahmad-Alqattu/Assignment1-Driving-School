package edu.cs.birzeit.assignment1_driving_school;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import edu.cs.birzeit.assignment1_driving_school.model.Session;
import edu.cs.birzeit.assignment1_driving_school.model.Student;
import edu.cs.birzeit.assignment1_driving_school.model.StudentDA;

public class student_info extends AppCompatActivity {
    TextView name;
    TextView ginder;
    TextView ID;
    TextView phone;
    TextView status;
    TextView corses;
    TextView paid;
    TextView to_pay;
    CardView card;
    Switch license;
    ConstraintLayout cons;
    RadioButton rbAdd;
    TextView from;
    Button add;
    EditText pay;
    int flag=0;
    int f;
    String id ;
    Student student;
    FirebaseDatabase fire = FirebaseDatabase.getInstance();
    DatabaseReference myRef = fire.getReference("students");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setVar();
        id = getIntent().getStringExtra("id");

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot carSnapshot : dataSnapshot.getChildren()) {
                    if (carSnapshot.getKey().equals("student" + id)) {
                        student = carSnapshot.getValue(Student.class);
                        break;
                    }

                }
                adddata();
            }

            @Override
            public void onCancelled(DatabaseError error) {// Handle error
            }
        });
if(f==5){

        }


    }

    private void setVar(){
       name=findViewById(R.id.name);
         ginder=findViewById(R.id.genderv);
         ID=findViewById(R.id.idv);
         phone=findViewById(R.id.phonev);
         status=findViewById(R.id.statusv);
         corses=findViewById(R.id.corsev);
         paid=findViewById(R.id.paidv);
         to_pay=findViewById(R.id.payv);


    }

    private void adddata(){

        name.append(student.getName());
        ginder.append(student.getSex());
        ID.append(student.getIdNumber());
        phone.append(student.getPhoneNumber());
        status.append(student.getStatus());
        corses.append(String.valueOf(student.getSessionNumber()));
        paid.append(String.valueOf(student.getPaid()));
        to_pay.append(getIntent().getStringExtra("topay"));
        cons = findViewById(R.id.conpay);
        cons.setVisibility(View.INVISIBLE);
        rbAdd=findViewById(R.id.rbAdd);
        license = findViewById(R.id.licence);
        from= findViewById(R.id.def);
        pay= findViewById(R.id.edpay);
        add= findViewById(R.id.Addpay);
        if(!student.getStatus().equals("in training")) {
            license.setVisibility(View.INVISIBLE);
        }if(student.getPaid()==Integer.parseInt(getIntent().getStringExtra("topay"))) {
            rbAdd.setVisibility(View.INVISIBLE);
        }
        license.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    if(student.getPaid()==Integer.parseInt(getIntent().getStringExtra("topay")))
                    {
                        student.setStatus("Done");
                    }else{
                        student.setStatus("has Debts");
                    }
                else
                    student.setStatus("in training");
myRef.child("student" + id).setValue(student);
            }

        });
        int num = Integer.parseInt(getIntent().getStringExtra("topay")) - student.getPaid();

        rbAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag==0) {
                    rbAdd.setChecked(true);
                    flag=1;
                }else {
                    rbAdd.setChecked(false);
                    flag = 0;

                }
            }
        });

        rbAdd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                if(isChecked) {
                    cons.setVisibility(View.VISIBLE);
                    from.setText("from: "+String.valueOf(num));
                }else
                    cons.setVisibility(View.INVISIBLE);

            }

        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (pay.getText().toString().isEmpty() || Integer.parseInt(pay.getText().toString()) <= num) {
                    student.setPaid(student.getPaid() + Integer.parseInt(pay.getText().toString()));
                    paid.setText("Paid: " + student.getPaid());
                    int num = Integer.parseInt(getIntent().getStringExtra("topay")) - student.getPaid();
                    from.setText("from: "+String.valueOf(num));

                    Toast.makeText(student_info.this, "Add successfully", Toast.LENGTH_SHORT).show();

                    if (student.getPaid() == Integer.parseInt(getIntent().getStringExtra("topay"))) {
                        if (student.getStatus().equalsIgnoreCase("has Debts")) {
                            student.setStatus("Done");
                            cons.setVisibility(View.INVISIBLE);
                        }
                        rbAdd.setVisibility(View.INVISIBLE);
                    }
                } else {
                    Toast.makeText(student_info.this, "try again", Toast.LENGTH_SHORT).show();
                }
                myRef.child("student" + id).setValue(student);

            }
        });

    }

    public int calculatePayment(int paid, int toPay){
        return toPay - paid;
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
}

