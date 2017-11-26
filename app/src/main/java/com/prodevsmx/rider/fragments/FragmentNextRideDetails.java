package com.prodevsmx.rider.fragments;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.prodevsmx.rider.Adapters.AdapterPassengers;
import com.prodevsmx.rider.R;
import com.prodevsmx.rider.beans.PendingRequestItem;

import java.util.ArrayList;
import java.util.List;


public class FragmentNextRideDetails extends android.support.v4.app.Fragment implements OnMapReadyCallback{
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


    public FragmentNextRideDetails() {
        // Required empty public constructor
    }


        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_next_ride_details, container, false);
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

        passengers = (RecyclerView) v.findViewById(R.id.recycler_view_passengers);




        Drawable drawable = getResources().getDrawable(R.drawable.susana, getActivity().getTheme());
        PendingRequestItem item = new PendingRequestItem(drawable, "Susana Mérces", "Trapani", "Pasajero");
        for (int i=0; i<5; i++){
            pass.add(item);
        }

        AdapterPassengers adapter = new AdapterPassengers(pass, getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        passengers.setLayoutManager(layoutManager);
        passengers.setAdapter(adapter);
    }

}
