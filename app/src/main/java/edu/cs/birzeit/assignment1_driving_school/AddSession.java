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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import edu.cs.birzeit.assignment1_driving_school.model.Car;
import edu.cs.birzeit.assignment1_driving_school.model.CarData;
import edu.cs.birzeit.assignment1_driving_school.model.Session;
import edu.cs.birzeit.assignment1_driving_school.model.SessionDA;
import edu.cs.birzeit.assignment1_driving_school.model.Student;
import edu.cs.birzeit.assignment1_driving_school.model.StudentDA;

public class AddSession extends AppCompatActivity {

    private CalendarView calendarView;
    private Button timeBtn;
    private Spinner studentNameSpinner;
    private Spinner carSpinner;
    private Button addSessionBtn;
    private Context context;
    private ArrayList<Session> sessions= new ArrayList<>() ;
    TextView time;
    int h;
    int m;

    int arrOfInt[] = {23, (11 + 1), 2022};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_session);
        setupView();
        time = (TextView) findViewById(R.id.timeBtn);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        sessions.add(new Session(7,4,2023,11,00,"ibrahim asfor","Hyundai i30"));
        sessions.add(new Session(3,7,2023,11,00,"ibrahim asfor","Skoda octavia"));
        sessions.add(new Session(5,6,2023,11,00,"ibrahim asfor","skoda kodiq"));
        sessions.add(new Session(2,2,2023,11,00,"ibrahim asfor","kia k5"));
        sessions.add(new Session(9,8,2023,11,00,"ibrahim asfor","kia sportage"));
        sessions.add(new Session(1,2,2023,11,00,"ibrahim asfor","volvo"));
        sessions.add(new Session(1,2,2023,11,00,"fatma ahmad","Hyundai Accent"));
        sessions.add(new Session(7,4,2023,11,00,"fatma ahmad","Hyundai i30"));
        sessions.add(new Session(3,7,2023,11,00,"fatma ahmad","Skoda octavia"));
        sessions.add(new Session(5,6,2023,11,00,"fatma ahmad","skoda kodiq"));
        sessions.add(new Session(2,2,2023,11,00,"fatma ahmad","kia k5"));
        sessions.add(new Session(9,8,2023,11,00,"fatma ahmad","kia sportage"));
        sessions.add(new Session(1,2,2023,11,00,"fatma ahmad","volvo"));
        sessions.add(new Session(1,2,2023,11,00,"alaa hamdan","Hyundai Accent"));
        sessions.add(new Session(7,4,2023,11,00,"alaa hamdan","Hyundai i30"));
        sessions.add(new Session(3,7,2023,11,00,"alaa hamdan","Skoda octavia"));
        sessions.add(new Session(5,6,2023,11,00,"alaa hamdan","skoda kodiq"));
        sessions.add(new Session(2,2,2023,11,00,"alaa hamdan","kia k5"));
        sessions.add(new Session(9,8,2023,10,00,"alaa hamdan","kia sportage"));
        sessions.add(new Session(1,2,2023,11,00,"alaa hamdan","volvo"));
        sessions.add(new Session(1,2,2023,11,00,"yasmeen khaled","Hyundai Accent"));
        sessions.add(new Session(7,4,2023,11,00,"yasmeen khaled","Hyundai i30"));
        sessions.add(new Session(3,7,2023,11,00,"yasmeen khaled","Skoda octavia"));
        sessions.add(new Session(5,6,2023,11,00,"yasmeen khaled","skoda kodiq"));
        sessions.add(new Session(2,2,2023,19,00,"yasmeen khaled","kia k5"));
        sessions.add(new Session(9,8,2023,11,00,"yasmeen khaled","kia sportage"));
        sessions.add(new Session(1,2,2023,11,00,"yasmeen khaled","volvo"));
        sessions.add(new Session(1,2,2023,11,00,"ahmad osama","Hyundai Accent"));
        sessions.add(new Session(7,4,2023,11,00,"ahmad osama","Hyundai i30"));
        sessions.add(new Session(3,7,2023,11,00,"ahmad osama","Skoda octavia"));
        sessions.add(new Session(5,6,2023,11,00,"ahmad osama","skoda kodiq"));
        sessions.add(new Session(2,2,2023,11,00,"ahmad osama","kia k5"));
        sessions.add(new Session(9,8,2023,21,00,"ahmad osama","kia sportage"));
        sessions.add(new Session(1,2,2023,11,00,"ahmad osama","volvo"));
        sessions.add(new Session(1,2,2023,11,00,"ahmad qattu","Hyundai Accent"));
        sessions.add(new Session(7,4,2023,11,00,"ahmad qattu","Hyundai i30"));
        sessions.add(new Session(3,7,2023,11,00,"ahmad qattu","Skoda octavia"));
        sessions.add(new Session(5,6,2023,11,00,"ahmad qattu","skoda kodiq"));
        sessions.add(new Session(2,2,2023,11,00,"ahmad qattu","kia k5"));
        sessions.add(new Session(9,8,2023,26,00,"ahmad qattu","kia sportage"));
        sessions.add(new Session(1,2,2023,11,00,"ahmad qattu","volvo"));


        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                h = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                m = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(AddSession.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        time.setText(selectedHour + ":" + selectedMinute);
                    }
                }, h, m, false);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();

            }
        });
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
                arrOfInt[0] = i;
                arrOfInt[1] = i1;
                arrOfInt[2] = i2;

                Toast.makeText(getApplicationContext(), ("" + i2 + " " + (i1 + 1) + " " + i), Toast.LENGTH_SHORT).show();
            }
        });
        addSessionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = arrOfInt[0];
                int i1 = arrOfInt[1];
                int i2 = arrOfInt[2];
//                sessions.addSessionToTable(new Session(i,i1,i2,h,m,
//                        studentNameSpinner.getSelectedItem().toString(),
//                        carSpinner.getSelectedItem().toString()));
//                StudentDA.getInstance().ubdate( studentNameSpinner.getSelectedItem().toString());
//                Toast.makeText(getApplicationContext(),(""+i+" "+i1+" "+i2+" 4 "+
//                        studentNameSpinner.getSelectedItem().toString()+" "+
//                        carSpinner.getSelectedItem().toString()),Toast.LENGTH_SHORT);

                FirebaseDatabase fire = FirebaseDatabase.getInstance();
                DatabaseReference myRef = fire.getReference("sessions");
                DatabaseReference studentsref = fire.getReference("students");
                studentsref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot carSnapshot : dataSnapshot.getChildren()) {
                            Student student = carSnapshot.getValue(Student.class);
                            if (student.getName().equalsIgnoreCase(studentNameSpinner.getSelectedItem().toString())){
                                Toast.makeText(AddSession.this, carSnapshot.getKey(), Toast.LENGTH_SHORT).show();
                                studentsref.child(carSnapshot.getKey()).child("sessionNumber").setValue(student.updateS());
                            }
                        }

                        long numOfCars = dataSnapshot.getChildrenCount();
                        // Use the setValue method to save the car object in the database with the incremented identifier as the child name
                        myRef.child("session" + (numOfCars + 1)).setValue(new Session(i2, i1, i, h, m,
                                studentNameSpinner.getSelectedItem().toString(),
                                carSpinner.getSelectedItem().toString()));
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {// Handle error
                    }
                });

                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        long numOfCars = dataSnapshot.getChildrenCount();
                        // Use the setValue method to save the car object in the database with the incremented identifier as the child name
                        myRef.child("session" + (numOfCars + 1)).setValue(new Session(i2, i1, i, h, m,
                                studentNameSpinner.getSelectedItem().toString(),
                                carSpinner.getSelectedItem().toString()));
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {// Handle error
                    }
                });
//                Toast.makeText(AddSession.this, "Add successfully", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }

    public void populateStudentSpinner() {
//        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, new ArrayList<String>());
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        FirebaseDatabase fire = FirebaseDatabase.getInstance();
        DatabaseReference myRef = fire.getReference("students");
        List<String> studs = new ArrayList<>();

//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
//                android.R.layout.simple_spinner_item, studs);
//        carSpinner.setAdapter(adapter);
//        List<String> studs= new ArrayList<>();
//        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, studs);
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot carSnapshot : dataSnapshot.getChildren()) {
                    Student student = carSnapshot.getValue(Student.class);
                    studs.add(student.getName());
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(AddSession.this, android.R.layout.simple_spinner_dropdown_item, studs);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                studentNameSpinner.setAdapter(adapter);
                studentNameSpinner.setEnabled(true);
            }

            @Override
            public void onCancelled(DatabaseError error) {// Handle error
            }
        });

    }

    public void populateCarSpinner() {

        FirebaseDatabase fire = FirebaseDatabase.getInstance();
        DatabaseReference myRef = fire.getReference("cars");
        List<String> cars = new ArrayList<>();

//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
//                android.R.layout.simple_spinner_item, studs);
//        carSpinner.setAdapter(adapter);
//        List<String> studs= new ArrayList<>();
//        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, studs);
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot carSnapshot : dataSnapshot.getChildren()) {
                    Car car = carSnapshot.getValue(Car.class);
                    cars.add(car.getCarName());
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(AddSession.this, android.R.layout.simple_spinner_dropdown_item, cars);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                carSpinner.setAdapter(adapter);
                carSpinner.setEnabled(true);
            }

            @Override
            public void onCancelled(DatabaseError error) {// Handle error
            }
        });

    }


}
