package com.prodevsmx.rider.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.prodevsmx.rider.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentNextRideDetails.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentNextRideDetails#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentNextRideDetails extends android.support.v4.app.Fragment implements OnMapReadyCallback{

    SupportMapFragment supportMapFragment;
    private GoogleMap mMap;
    View v;

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(20.65, -103.34);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        CameraPosition cp = new CameraPosition.Builder().zoom(15).target(sydney).build();
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cp));
    }


    public FragmentNextRideDetails() {
        // Required empty public constructor
    }


        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_fragment_next_ride_details, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        v = view;
        //supportMapFragment = (SupportMapFragment) v.findViewById(R.id.map);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);

        //
        mapFragment.getMapAsync(this);
    }

}
