package com.prodevsmx.rider;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.prodevsmx.rider.Adapters.AdapterPassengers;
import com.prodevsmx.rider.beans.PendingRequestItem;

import java.util.ArrayList;
import java.util.List;

import static android.widget.LinearLayout.HORIZONTAL;

public class ActivityRideDetail extends AppCompatActivity implements OnMapReadyCallback{

    List<PendingRequestItem> pass = new ArrayList<PendingRequestItem>();
    SupportMapFragment supportMapFragment;
    private GoogleMap mMap;
    View v;
    RecyclerView passengers;
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(20.65, -103.34);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        CameraPosition cp = new CameraPosition.Builder().zoom(15).target(sydney).build();
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cp));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride_detail);

        /*
        SupportMapFragment mapFragment = (SupportMapFragment) findViewById(R.id.map);
        mapFragment.getMapAsync(this);
        passengers = (RecyclerView) v.findViewById(R.id.recycler_view_passengers);
        Drawable drawable = getResources().getDrawable(R.drawable.susana, getTheme());
        PendingRequestItem item = new PendingRequestItem(drawable, "Susana Mérces", "Trapani", "Pasajero");
        for (int i=0; i<5; i++){
            pass.add(item);
        }
        AdapterPassengers adapter = new AdapterPassengers(pass, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this), LinearLayoutManager.HORIZONTAL, false);
        passengers.setLayoutManager(layoutManager);
        passengers.setAdapter(adapter);
        */

    }



}
