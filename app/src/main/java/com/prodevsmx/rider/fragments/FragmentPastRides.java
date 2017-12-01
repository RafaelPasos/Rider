package com.prodevsmx.rider.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prodevsmx.rider.Adapters.AdapterPastRides;
import com.prodevsmx.rider.R;
import com.prodevsmx.rider.beans.PastRide;

import java.util.ArrayList;


public class FragmentPastRides extends android.support.v4.app.Fragment{

    RecyclerView rvPastRides;
    ArrayList<PastRide> rides = new ArrayList<>();

    public FragmentPastRides() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_past_rides, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvPastRides = view.findViewById(R.id.recyclerViewPastRides);
        PastRide r = new PastRide("https://maps.googleapis.com/maps/api/staticmap?center=20.652531, -103.392013&zoom=15&size=500x200&key=AIzaSyDdfmz1egjUFqky-rv-RvQ76-7XWSDN8mo", "Expo Mueble", "30/09/2017");
        PastRide p = new PastRide("https://maps.googleapis.com/maps/api/staticmap?center=20.722490, -103.431452&zoom=15&size=500x200&key=AIzaSyDdfmz1egjUFqky-rv-RvQ76-7XWSDN8mo", "Dia del niño", "29/04/2017");
        PastRide q = new PastRide("https://maps.googleapis.com/maps/api/staticmap?center=20.681629, -103.462999&zoom=15&size=500x200&key=AIzaSyDdfmz1egjUFqky-rv-RvQ76-7XWSDN8mo", "Chivas vs. América", "1/02/2017");
        rides.add(r);
        rides.add(p);
        rides.add(q);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        AdapterPastRides adapterPastRides  = new AdapterPastRides(rides, getContext());
        rvPastRides.setLayoutManager(layoutManager);
        rvPastRides.setAdapter(adapterPastRides);
    }
}
