package com.prodevsmx.rider.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prodevsmx.rider.Adapters.AdapterEventsNearby;
import com.prodevsmx.rider.R;
import com.prodevsmx.rider.beans.EventNearbyItem;

import java.util.ArrayList;


public class FragmentExplore extends android.support.v4.app.Fragment {

    View v;
    ArrayList<EventNearbyItem> eventNearbyItems = new ArrayList<>();
    RecyclerView recyclerViewEvents;

    public FragmentExplore(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_explore, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        v = view;
        recyclerViewEvents = v.findViewById(R.id.recyclerViewEventsNearby);
        initializeViews();
        AdapterEventsNearby adapterEventsNearby = new AdapterEventsNearby(eventNearbyItems, getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerViewEvents.setLayoutManager(layoutManager);
        recyclerViewEvents.setAdapter(adapterEventsNearby);
    }

    public void initializeViews(){
        Drawable drawable = getResources().getDrawable(R.drawable.coldplay, getActivity().getTheme());
        EventNearbyItem evento = new EventNearbyItem(drawable, "Coldplay", "Arena VFG", "10 November 2017");
        eventNearbyItems.add(evento);

        drawable = getResources().getDrawable(R.drawable.kendrick, getActivity().getTheme());
        evento = new EventNearbyItem(drawable, "Kendrick Lamar", "Teatro Diana", "17 December 2017");
        eventNearbyItems.add(evento);

        drawable = getResources().getDrawable(R.drawable.zoe, getActivity().getTheme());
        evento = new EventNearbyItem(drawable, "Zoé", "Teatro estudio Cabaret", "02 January 2018");
        eventNearbyItems.add(evento);

        drawable = getResources().getDrawable(R.drawable.maluma, getActivity().getTheme());
        evento = new EventNearbyItem(drawable, "Maluma", "C3 Stage", "08 January 2018");
        eventNearbyItems.add(evento);

        drawable = getResources().getDrawable(R.drawable.foofighters, getActivity().getTheme());
        evento = new EventNearbyItem(drawable, "Foo Fighters", "Auditorio Telmex", "14 January 2018");
        eventNearbyItems.add(evento);

        drawable = getResources().getDrawable(R.drawable.caloncho, getActivity().getTheme());
        evento = new EventNearbyItem(drawable, "Caloncho", "Parque Trasloma", "27 January 2018");
        eventNearbyItems.add(evento);

        drawable = getResources().getDrawable(R.drawable.bruno, getActivity().getTheme());
        evento = new EventNearbyItem(drawable, "Bruno Mars", "Estadio Omnilife", "05 February 2018");
        eventNearbyItems.add(evento);

        drawable = getResources().getDrawable(R.drawable.valentin, getActivity().getTheme());
        evento = new EventNearbyItem(drawable, "Valentín Elizalde", "Palenque", "06 March 2018");
        eventNearbyItems.add(evento);

    }
}
