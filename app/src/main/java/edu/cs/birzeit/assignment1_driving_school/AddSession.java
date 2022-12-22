package edu.cs.birzeit.assignment1_driving_school;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

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

    int[] arrOfInt = {23,(11+1),2022};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_session);
        setupView();
    }

    private void setupView() {
        calendarView = findViewById(R.id.calendarView);
        timeBtn = findViewById(R.id.timeBtn);
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
                sessions.addSessionToTable(new Session(i,i1,i2,4,
                        studentNameSpinner.getSelectedItem().toString(),
                        carSpinner.getSelectedItem().toString()));
                Toast.makeText(getApplicationContext(),(""+i+" "+i1+" "+i2+" 4 "+
                        studentNameSpinner.getSelectedItem().toString()+" "+
                        carSpinner.getSelectedItem().toString()),Toast.LENGTH_SHORT);

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
