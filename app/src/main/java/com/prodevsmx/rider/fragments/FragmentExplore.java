package com.prodevsmx.rider.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.prodevsmx.rider.Adapters.AdapterEventsNearby;
import com.prodevsmx.rider.Models.EventResponse.EventDatum;
import com.prodevsmx.rider.Models.EventResponse.EventResponse;
import com.prodevsmx.rider.Models.Image.FBImage;
import com.prodevsmx.rider.R;
import com.prodevsmx.rider.beans.EventNearbyItem;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;


public class FragmentExplore extends android.support.v4.app.Fragment {

    View v;
    ArrayList<EventNearbyItem> eventNearbyItems = new ArrayList<>();
    RecyclerView recyclerViewEvents;
    CallbackManager callbackManager;

    public void getEventsFromFB(final String eName){
        eventNearbyItems.clear();
        GraphRequest request = GraphRequest.newGraphPathRequest(
                AccessToken.getCurrentAccessToken(),
                "/search",
                new GraphRequest.Callback() {
                    @Override
                    public void onCompleted(GraphResponse response) {
                        ObjectMapper mapper = new ObjectMapper();
                        try {
                            String s = response.getJSONObject().toString();
                            //s = s.substring(1, s.length()-2);
                            EventResponse res = mapper.readValue(s, EventResponse.class);
                            Log.d("TOROMAX:", "vaAli");
                            for(EventDatum e : res.getData()){
                                 EventNearbyItem ev = new EventNearbyItem(e.getId(), (e.getName() != null) ? e.getName() : " - - - ", (e.getPlace()!=null) ? e.getPlace().getName() : " - - - ", (e.getstart_time() != null) ? e.getstart_time() : "" );
                                Log.d("TOROMAXSHISHOTAS:", e.getId());
                                 eventNearbyItems.add(ev);
                            }
                            populateRecyclerView();
                        }
                        catch(Exception e){
                            e.printStackTrace();
                            Log.d("TOROMAX:", "vali");
                        }
                    }
                });

        Bundle parameters = new Bundle();
        parameters.putString("q", eName);
        parameters.putString("type", "event");
        request.setParameters(parameters);
        request.executeAsync();
    }

    public FragmentExplore(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        callbackManager = CallbackManager.Factory.create();
        return inflater.inflate(R.layout.fragment_explore, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        v = view;
        recyclerViewEvents = v.findViewById(R.id.recyclerViewEventsNearby);
        initializeViews();
        populateRecyclerView();
    }

    public void initializeViews(){
        //EventNearbyItem evento = new EventNearbyItem("https://media.pitchfork.com/photos/59299367c0084474cd0bead4/1:1/w_300/90179474.jpg", "Coldplay", "Arena VFG", "10 November 2017");
        //eventNearbyItems.add(evento);

        //evento = new EventNearbyItem("https://media.pitchfork.com/photos/59299367c0084474cd0bead4/1:1/w_300/90179474.jpg", "Kendrick Lamar", "Teatro Diana", "17 December 2017");
        //eventNearbyItems.add(evento);

        //evento = new EventNearbyItem("https://media.pitchfork.com/photos/59299367c0084474cd0bead4/1:1/w_300/90179474.jpg", "Zoé", "Teatro estudio Cabaret", "02 January 2018");
        //eventNearbyItems.add(evento);

        //evento = new EventNearbyItem("https://media.pitchfork.com/photos/59299367c0084474cd0bead4/1:1/w_300/90179474.jpg", "Maluma", "C3 Stage", "08 January 2018");
        //eventNearbyItems.add(evento);

        //evento = new EventNearbyItem("https://media.pitchfork.com/photos/59299367c0084474cd0bead4/1:1/w_300/90179474.jpg", "Foo Fighters", "Auditorio Telmex", "14 January 2018");
        //eventNearbyItems.add(evento);

        //evento = new EventNearbyItem("https://media.pitchfork.com/photos/59299367c0084474cd0bead4/1:1/w_300/90179474.jpg", "Caloncho", "Parque Trasloma", "27 January 2018");
        //eventNearbyItems.add(evento);

        //evento = new EventNearbyItem("https://media.pitchfork.com/photos/59299367c0084474cd0bead4/1:1/w_300/90179474.jpg", "Bruno Mars", "Estadio Omnilife", "05 February 2018");
        //eventNearbyItems.add(evento);

        //evento = new EventNearbyItem("https://media.pitchfork.com/photos/59299367c0084474cd0bead4/1:1/w_300/90179474.jpg", "Valentín Elizalde", "Palenque", "06 March 2018");
        //eventNearbyItems.add(evento);

        getEventsFromFB("la garfield");


    }

    public void populateRecyclerView(){
        AdapterEventsNearby adapterEventsNearby = new AdapterEventsNearby(eventNearbyItems, getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerViewEvents.setLayoutManager(layoutManager);
        recyclerViewEvents.setAdapter(adapterEventsNearby);
    }
}
