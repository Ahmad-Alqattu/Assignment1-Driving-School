package edu.cs.birzeit.assignment1_driving_school;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.List;

import edu.cs.birzeit.assignment1_driving_school.model.CarData;
import edu.cs.birzeit.assignment1_driving_school.model.Session;
import edu.cs.birzeit.assignment1_driving_school.model.SessionDA;
import edu.cs.birzeit.assignment1_driving_school.model.StudentDA;

public class AddSession extends AppCompatActivity {

    private CalendarView calendarView;
    private Button timeBtn;
    private Spinner studentNameSpinner;
    private Spinner carSpinner;
    private Button addSessionBtn;
    private Context context;
    private SessionDA sessions = new SessionDA();
    TextView time;
    int h;
    int m;

    int[] arrOfInt = {23,(11+1),2022};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_session);
        setupView();
        time = (TextView) findViewById(R.id.timeBtn);
        // perform click event listener on edit text
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(AddSession.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        time.setText(selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, false);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();

            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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

        private void setupView() {
        calendarView = findViewById(R.id.calendarView);
        studentNameSpinner = findViewById(R.id.studentNameSpinner);
        carSpinner = findViewById(R.id.carSpinner);
        addSessionBtn = findViewById(R.id.addSessionBtn);
        populateCarSpinner();
        populateStudentSpinner();

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {
                int[] arrOfInt = {i,(i1+1),i2};
                Toast.makeText(getApplicationContext(),(""+i2+" "+(i1+1)+" "+i),Toast.LENGTH_SHORT ).show();
            }
        });

        addSessionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i=arrOfInt[0];
                int i1=arrOfInt[1];
                int i2=arrOfInt[2];
                sessions.addSessionToTable(new Session(i,i1,i2,h,m,
                        studentNameSpinner.getSelectedItem().toString(),
                        carSpinner.getSelectedItem().toString()));
                StudentDA.getInstance().ubdate( studentNameSpinner.getSelectedItem().toString());
                Toast.makeText(getApplicationContext(),(""+i+" "+i1+" "+i2+" 4 "+
                        studentNameSpinner.getSelectedItem().toString()+" "+
                        carSpinner.getSelectedItem().toString()),Toast.LENGTH_SHORT);
                Toast.makeText(AddSession.this, "Add successfully", Toast.LENGTH_SHORT).show();
                finish();

            }
        });

    }

    public void populateStudentSpinner(){
        List<String> studs = StudentDA.getInstance().showStudents();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, studs);
        studentNameSpinner.setAdapter(adapter);
    }

    public void populateCarSpinner(){
        List<String> cars = CarData.getInstance().getCategories();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, cars);
        carSpinner.setAdapter(adapter);
    }

    public void addTimeBtn(View view) {
        context= this;
        Intent vAddTime = new Intent( context,addGrid.class);
        context.startActivity(vAddTime);
    }

}
