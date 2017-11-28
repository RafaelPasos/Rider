package com.prodevsmx.rider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.prodevsmx.rider.Adapters.AdapterOnRide;
import com.prodevsmx.rider.beans.PendingRequestItem;

import java.util.ArrayList;
import java.util.List;

public class ActivityRide extends AppCompatActivity {

    List<PendingRequestItem> pass = new ArrayList<PendingRequestItem>();
    View v;
    RecyclerView passengers;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride);
        button = findViewById(R.id.btnRequestRide);
        passengers = (RecyclerView) findViewById(R.id.recycler_view_passengersRide);
        PendingRequestItem item = new PendingRequestItem(
                "https://media.pitchfork.com/photos/59299367c0084474cd0bead4/1:1/w_300/90179474.jpg",
                "Susana Mérces",
                "Trapani",
                "Pasajero",
                "request1"
        );

        for (int i=0; i<3; i++){
            pass.add(item);
        }
        AdapterOnRide adapter = new AdapterOnRide(pass, this);
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        passengers.setLayoutManager(layoutManager);
        passengers.setAdapter(adapter);
        

    }
}
