package com.prodevsmx.rider.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prodevsmx.rider.Adapters.AdapterNextTrips;
import com.prodevsmx.rider.R;
import com.prodevsmx.rider.beans.EventNearbyItem;

import java.util.ArrayList;


public class FragmentNextRides extends android.support.v4.app.Fragment{

    View v;
    ArrayList<EventNearbyItem> eventNearbyItems = new ArrayList<>();
    RecyclerView recyclerViewEvents;

    public FragmentNextRides() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_next_rides, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        v = view;
        recyclerViewEvents = v.findViewById(R.id.recyclerViewNextRides);
        initializeViews();
        AdapterNextTrips adapterEventsNearby = new AdapterNextTrips(eventNearbyItems, getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerViewEvents.setLayoutManager(layoutManager);
        recyclerViewEvents.setAdapter(adapterEventsNearby);
    }

    public void initializeViews(){
        EventNearbyItem evento = new EventNearbyItem("http://elmerey.com/wp-content/uploads/2017/11/16/Coldplay.jpg", "Coldplay", "Arena VFG", "10 November 2017");
        eventNearbyItems.add(evento);

        evento = new EventNearbyItem("http://maxima1067.fm/images/calonchodev-6626.jpg", "Caloncho", "Parque Trasloma", "27 January 2018");
        eventNearbyItems.add(evento);

        evento = new EventNearbyItem("https://psn.si/wp-content/uploads/2017/06/Bruno-Mars-M.jpg", "Bruno Mars", "Estadio Omnilife", "05 February 2018");
        eventNearbyItems.add(evento);
    }

}
