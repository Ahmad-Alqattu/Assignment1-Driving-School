package edu.cs.birzeit.assignment1_driving_school;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

import edu.cs.birzeit.assignment1_driving_school.model.Car;
import edu.cs.birzeit.assignment1_driving_school.model.CarData;

public class viewCar extends AppCompatActivity {
    private Context context;
    car_adabt adabt;
    RecyclerView car_info;
    FirebaseFirestore fire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_car);
        car_info= findViewById(R.id.recycler);
        adabt =new car_adabt(this);
        car_info.setAdapter(adabt);
        car_info.setLayoutManager(new LinearLayoutManager(this));
        FirebaseFirestor =FirebaseFirestor.getInstance();

//      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
}


    @Override
    protected void onResume() {
        super.onResume();

    }


    @Override
    protected void onPause() {
        super.onPause();


    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.search,menu);
        MenuItem searchItem = menu.findItem(R.id.search_bar);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;


            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adabt.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
//
//    public Spinner spinner;
//    private ListView listView;
//    private CarData data;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_view_car);
//
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                finish();
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    public boolean onCreateOptionsMenu(Menu menu) {
//        return true;
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        List<String> cars = CarData.getInstance().getCategories();
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_spinner_item,cars);
//        spinner.setAdapter(adapter);
//    }
//
//    public void btnSelect(View view) {
//        String str = spinner.getSelectedItem().toString();
//        List<Car> res = CarData.getInstance().getItems(str);
//        ArrayAdapter<Car> adapterItems = new ArrayAdapter<Car>(viewCar.this,
//                android.R.layout.simple_list_item_1,res);
//        listView.setAdapter(adapterItems);
//    }
//
//    public void btnAddCar(View view) {
//        context= this;
//        Intent vAddCar = new Intent( context,addNewCar.class);
//        context.startActivity(vAddCar);
//    }


}