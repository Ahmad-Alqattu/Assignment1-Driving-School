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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        int id = Integer.parseInt(getIntent().getStringExtra("id"));
        setVar();
        name.append(StudentDA.getInstance().students.get(id).getName());
        ginder.append(StudentDA.getInstance().students.get(id).getSex());
        ID.append(StudentDA.getInstance().students.get(id).getIdNumber());
        phone.append(StudentDA.getInstance().students.get(id).getPhoneNumber());
        status.append(StudentDA.getInstance().students.get(id).getStatus());
        corses.append(String.valueOf(StudentDA.getInstance().students.get(id).getSessionNumber()));
        paid.append(String.valueOf(StudentDA.getInstance().students.get(id).getPaid()));
        to_pay.append(getIntent().getStringExtra("topay"));
        cons = findViewById(R.id.conpay);
        cons.setVisibility(View.INVISIBLE);
        rbAdd=findViewById(R.id.rbAdd);
        license = findViewById(R.id.licence);
        from= findViewById(R.id.def);
        pay= findViewById(R.id.edpay);
        add= findViewById(R.id.Addpay);


        if(StudentDA.getInstance().students.get(id).getStatus()!="in training") {

            license.setVisibility(View.INVISIBLE);
        }if(StudentDA.getInstance().students.get(id).getPaid()==Integer.parseInt(getIntent().getStringExtra("topay"))) {

            rbAdd.setVisibility(View.INVISIBLE);
        }
        license.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    if(StudentDA.getInstance().students.get(id).getPaid()==Integer.parseInt(getIntent().getStringExtra("topay")))
                {
                    StudentDA.getInstance().students.get(id).setStatus("Done");
                }else{
                        StudentDA.getInstance().students.get(id).setStatus("has Debts");
                    }
                    else
                    StudentDA.getInstance().students.get(id).setStatus("in training");


            }
        });
        int num = Integer.parseInt(getIntent().getStringExtra("topay")) - StudentDA.getInstance().students.get(id).getPaid();

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
                    StudentDA.getInstance().students.get(id).setPaid(StudentDA.getInstance().students.get(id).getPaid() + Integer.parseInt(pay.getText().toString()));
                    paid.setText("Paid: " + StudentDA.getInstance().students.get(id).getPaid());
                    int num = Integer.parseInt(getIntent().getStringExtra("topay")) - StudentDA.getInstance().students.get(id).getPaid();
                    from.setText("from: "+String.valueOf(num));

                    Toast.makeText(student_info.this, "Add successfully", Toast.LENGTH_SHORT).show();

                    if (StudentDA.getInstance().students.get(id).getPaid() == Integer.parseInt(getIntent().getStringExtra("topay"))) {
                        if (StudentDA.getInstance().students.get(id).getStatus().equalsIgnoreCase("has Debts")) {
                            StudentDA.getInstance().students.get(id).setStatus("Done");
                            cons.setVisibility(View.INVISIBLE);
                        }
                        rbAdd.setVisibility(View.INVISIBLE);
                    }
                } else {
                    Toast.makeText(student_info.this, "try again", Toast.LENGTH_SHORT).show();
                }
            }
        });

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

