package edu.cs.birzeit.assignment1_driving_school;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

