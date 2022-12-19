package edu.cs.birzeit.assignment1_driving_school;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import edu.cs.birzeit.assignment1_driving_school.model.StudentDA;

public class student_info extends AppCompatActivity {
    TextView name=findViewById(R.id.name);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int id =Integer.parseInt(getIntent().getStringExtra("id"));

        name.append(StudentDA.getInstance().students.get(id).getName());

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

