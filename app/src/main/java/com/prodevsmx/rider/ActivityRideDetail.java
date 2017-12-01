package com.prodevsmx.rider;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
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
    String rideStatus;
    String eventName_txt;
    SharedPreferences sp;
    SharedPreferences.Editor editor;

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
        final String eventNameStr;
        String eventId;
        String eventPlaceStr;
        String eventDateStr;

        eventId = extras.getString("id");
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

        Picasso.with(this).load(eventId).into(eventImage);
        //Picasso.with(this).load("https://graph.facebook.com/" + eventImageStr + "/picture").into(eventImage);

        SupportMapFragment mapFragment =  (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        passengers = (RecyclerView) findViewById(R.id.recycler_view_passengersRide);
        PendingRequestItem item = new PendingRequestItem(
                "http://i.ytimg.com/vi/w5ZaHJ8ItaY/maxresdefault.jpg",
                "Susana Mérces",
                "Av. Carnero 1247",
                "Pasajero",
                "request1");
        pass.add(item);
        PendingRequestItem item1 = new PendingRequestItem(
                "http://www.abt.org/images/db_images/dancers/waskiweb.jpg",
                "Arcana Macana",
                "Av. Puritana 6879",
                "Pasajero",
                "request2");

        pass.add(item1);

        AdapterPassengers adapter = new AdapterPassengers(pass, this);
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        passengers.setLayoutManager(layoutManager);
        passengers.setAdapter(adapter);

        onTravel = false;
        sp = this.getSharedPreferences("com.prodevsmx.rider.prefs", Context.MODE_PRIVATE);
        if(sp.contains("com_prodevsmx_rider_trip_started")) {
            rideStatus = sp.getString("com_prodevsmx_rider_trip_started", null);
            onTravel = rideStatus.equals("true");
            if(!eventName.equals(sp.getString("com_prodevsmx_rider_trip_name", null)))
                button.setText("End ride " + sp.getString("com_prodevsmx_rider_trip_name", null));
        }

        if(onTravel)
            if(sp.contains("com_prodevsmx_rider_trip_name"))
                eventName_txt = sp.getString("com_prodevsmx_rider_trip_name", null);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onTravel){
                    SharedPreferences.Editor editor = sp.edit();
                    editor.remove("com_prodevsmx_rider_trip_started");
                    editor.remove("com_prodevsmx_rider_trip_name");
                    onTravel = false;
                    editor.commit();
                    Intent i = new Intent(ActivityRideDetail.this, ActivityEndRide.class);
                    startActivity(i);
                }else {

                    onTravel = true;
                    AdapterOnRide adapter = new AdapterOnRide(pass, ActivityRideDetail.this);
                    passengers.setAdapter(adapter);
                    Uri.Builder builder = new Uri.Builder();
                    builder.scheme("https")
                            .authority("www.google.com").appendPath("maps").appendPath("dir").appendPath("").appendQueryParameter("api", "1")
                            .appendQueryParameter("destination", 20.676494 + "," + -103.430730).appendQueryParameter("waypoints", 20.645493  +"," + -103.401261+"|"+20.665649  +"," + -103.393888);
                    String url = builder.build().toString();
                    Log.d("Directions", url);
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                    button.setText("End ride " + eventNameStr);
                }
            }
        });
    }

    public void saveInfo(String name, String place, String date, String image, String status){
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("com_prodevsmx_rider_trip_started", (status == null) ? "" : name);
        editor.putString("com_prodevsmx_rider_trip_name", name);
        editor.commit();
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
        Log.d("PICKED: ", p.getUserName());
    }


}
