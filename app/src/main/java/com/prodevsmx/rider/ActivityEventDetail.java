package com.prodevsmx.rider;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.prodevsmx.rider.beans.CarItem;
import com.prodevsmx.rider.fragments.FragmentExplore;
import com.prodevsmx.rider.fragments.FragmentVehicle;

import java.util.ArrayList;

public class ActivityEventDetail extends AppCompatActivity {

    String id;
    Spinner carSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);
        Bundle b = getIntent().getExtras();
        id = b.getString("id");
        Log.d("idTotomax", id);
        ArrayList<String> cars = new ArrayList<>();
        /*Drawable drawable = getResources().getDrawable(R.drawable.fiesta, getTheme());
        CarItem item = new CarItem(drawable, "Ford Fiesta 2016", "JMH-47-51");
        cars.add(item);
        drawable = getResources().getDrawable(R.drawable.porsche, getTheme());
        item = new CarItem(drawable, "Porsche 911 S", "JNU-17-58");
        cars.add(item);
        */
        carSelect = (Spinner) findViewById(R.id.spinnerSelectCar);
        ArrayAdapter<String> adapter;
        cars.add("Ford Fiesta 2016");
        cars.add("Porsche 911 S");
        adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_spinner_item, cars);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        carSelect.setAdapter(adapter);
    }

    public void selectLocation(View view){
        if(carSelect.getVisibility() == view.GONE){
            Intent i = new Intent(this, ActivityChooseDriver.class);
            startActivity(i);
        }
    }

    public void selectMode(View view){
        switch (view.getId()) {
            case R.id.btn_driver_mode:
                carSelect.setVisibility(view.VISIBLE);
                break;
            case R.id.btn_passenger_mode:
                carSelect.setVisibility(view.GONE);
                break;
        }
    }
}
