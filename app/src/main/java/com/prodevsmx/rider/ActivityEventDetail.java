package com.prodevsmx.rider;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ActivityEventDetail extends AppCompatActivity implements OnMapReadyCallback {

    String id;
    Spinner carSelect;
    private FusedLocationProviderClient mFusedLocationClient;
    LatLng posActual ;
    TextView locationTV;
    SupportMapFragment mapFragment;
    private GoogleMap mMap;
    ArrayList<String> cars;
    ArrayAdapter<String> adapter;

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
        setContentView(R.layout.activity_event_detail);
        cars = new ArrayList<>();
        posActual = new LatLng(20.65, -103.34);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        getLocation();
        mapFragment =  (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.eventMapFragment);
        mapFragment.getMapAsync(this);

        Bundle b = getIntent().getExtras();
        id = b.getString("id");
        Log.d("idTotomax", id);

        carSelect = (Spinner) findViewById(R.id.spinnerSelectCar);

        cars.add("Ford Fiesta 2016");
        cars.add("Porsche 911 S");
        adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_spinner_item, cars);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        carSelect.setAdapter(adapter);
        locationTV = (TextView) findViewById(R.id.txt_location);
    }

    public void selectLocation(View view){
        if(carSelect.getVisibility() == view.GONE){
            Intent i = new Intent(this, ActivityChooseDriver.class);
            startActivity(i);
        }else{
            Toast.makeText(this, "Your ride has been published to compatible users!", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(ActivityEventDetail.this, ActivityLand.class);
            startActivity(i);
            finish();
        }
    }

    public void selectMode(View view){
        switch (view.getId()) {
            case R.id.btn_driver_mode:
                carSelect.setVisibility(view.VISIBLE);
                ((Button)view).setBackgroundResource(R.drawable.btn_selected_left);
                ((Button)findViewById(R.id.btn_passenger_mode)).setBackgroundResource(R.drawable.btn_deselected_right);
                break;
            case R.id.btn_passenger_mode:
                carSelect.setVisibility(view.GONE);
                ((Button)view).setBackgroundResource(R.drawable.btn_selected_right);
                ((Button)findViewById(R.id.btn_driver_mode)).setBackgroundResource(R.drawable.btn_deselected_left);
                break;
        }
    }

    public void getLocation(){
        try {
            mFusedLocationClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    Geocoder geocoder = new Geocoder(ActivityEventDetail.this, Locale.getDefault());
                    posActual = new LatLng(location.getLatitude(), location.getLongitude());
                    try {
                        List<Address> addresses;
                        addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
                        String address = addresses.get(0).getAddressLine(0);
                        updateRoute(posActual);
                        locationTV.setText(address);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        catch(SecurityException e) {

        }
    }

}
