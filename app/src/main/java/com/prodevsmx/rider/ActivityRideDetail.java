package com.prodevsmx.rider;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.prodevsmx.rider.Adapters.AdapterOnRide;
import com.prodevsmx.rider.Adapters.AdapterPassengers;
import com.prodevsmx.rider.beans.PendingRequestItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ActivityRideDetail extends AppCompatActivity implements OnMapReadyCallback{

    List<PendingRequestItem> pass = new ArrayList<PendingRequestItem>();
    SupportMapFragment supportMapFragment;
    private GoogleMap mMap;
    private FusedLocationProviderClient mFusedLocationClient;
    View v;
    RecyclerView passengers;
    ImageView eventImage;
    TextView eventName;
    TextView eventPlace;
    TextView eventDate;
    Button button;
    boolean onTravel = false;
    LatLng posActual = new LatLng(20.65, -103.34);
    ArrayList<LatLng> destinos = new ArrayList<>();
    LatLng destinoActual;
    PolylineOptions polylineOptions;

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(20.65, -103.34);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        CameraPosition cp = new CameraPosition.Builder().zoom(15).target(sydney).build();
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cp));
    }

    public void updateRoute(LatLng latLng){
        mMap.addMarker(new MarkerOptions().position(latLng).title("Marker in your position"));
        CameraPosition cp = new CameraPosition.Builder().zoom(15).target(latLng).build();
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cp));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride_detail);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        getLocation();
        Bundle extras = getIntent().getExtras();
        String eventImageStr;
        String eventNameStr;
        String eventPlaceStr;
        String eventDateStr;

        eventImageStr = extras.getString("image");
        eventNameStr = extras.getString("name");
        eventPlaceStr = extras.getString("place");
        eventDateStr = extras.getString("date");
        button = findViewById(R.id.btnStartRide);
        eventImage = findViewById(R.id.ivEventImageDetail);
        eventName = findViewById(R.id.tvEventTitleDetail);
        eventPlace = findViewById(R.id.tv_EventDetailDetail);
        eventDate = findViewById(R.id.tv_EventDateDetail);
        eventName.setText(eventNameStr);
        eventPlace.setText(eventPlaceStr);
        eventDate.setText(eventDateStr);

        Picasso.with(this).load("https://media.pitchfork.com/photos/59299367c0084474cd0bead4/1:1/w_300/90179474.jpg").into(eventImage);
        //Picasso.with(this).load("https://graph.facebook.com/" + eventImageStr + "/picture").into(eventImage);

        SupportMapFragment mapFragment =  (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        passengers = (RecyclerView) findViewById(R.id.recycler_view_passengersRide);
        PendingRequestItem item = new PendingRequestItem(
                "https://media.pitchfork.com/photos/59299367c0084474cd0bead4/1:1/w_300/90179474.jpg",
                "Susana Mérces",
                "Trapani",
                "Pasajero",
                "request1");

        for (int i=0; i<3; i++){
            pass.add(item);
        }
        AdapterPassengers adapter = new AdapterPassengers(pass, this);
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        passengers.setLayoutManager(layoutManager);
        passengers.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdapterOnRide adapter = new AdapterOnRide(pass, ActivityRideDetail.this);
                passengers.setAdapter(adapter);
                button.setText("End ride");
                onTravel = true;
            }
        });
    }

    public void getLocation(){
        try {
            mFusedLocationClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    posActual = new LatLng(location.getLatitude(), location.getLongitude());
                    updateRoute(posActual);
                }
            });
        }
        catch(SecurityException e){

        }
    }

    public void pickupUser(int pos){
        PendingRequestItem p = pass.get(pos);
        destinoActual = p.getPickupPoint();
        getLocation();

    }

    public void calculateRoute(){

    }

}
