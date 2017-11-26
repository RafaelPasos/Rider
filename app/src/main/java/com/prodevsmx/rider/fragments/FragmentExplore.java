package com.prodevsmx.rider.fragments;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
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
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.prodevsmx.rider.Adapters.AdapterEventsNearby;
import com.prodevsmx.rider.Models.EventResponse.EventDatum;
import com.prodevsmx.rider.Models.EventResponse.EventResponse;
import com.prodevsmx.rider.Models.Image.FBImage;
import com.prodevsmx.rider.R;
import com.prodevsmx.rider.beans.EventNearbyItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;

import com.fasterxml.jackson.databind.ObjectMapper;


public class FragmentExplore extends android.support.v4.app.Fragment {

    View v;
    String searchStr = null;
    ArrayList<EventNearbyItem> eventNearbyItems = new ArrayList<>();
    RecyclerView recyclerViewEvents;
    CallbackManager callbackManager;
    private FusedLocationProviderClient mFusedLocationClient;

    public void getEventsFromFB() {
        if (searchStr== null){
            getLocation();
        }else{
            eventNearbyItems.clear();
            GraphRequest request = GraphRequest.newGraphPathRequest(
                    AccessToken.getCurrentAccessToken(),
                    "/search",
                    new GraphRequest.Callback() {
                        @Override
                        public void onCompleted(GraphResponse response) {
                            ObjectMapper mapper = new ObjectMapper();
                            try {
                                Log.d("DATA:", response.getJSONObject().toString());
                                String s = response.getJSONObject().toString();
                                EventResponse res = mapper.readValue(s, EventResponse.class);
                                for (EventDatum e : res.getData()) {
                                    EventNearbyItem ev = new EventNearbyItem(e.getId(), (e.getName() != null) ? e.getName() : " - - - ", (e.getPlace() != null) ? e.getPlace().getName() : " - - - ", (e.getstart_time() != null) ? e.getstart_time() : "");
                                    eventNearbyItems.add(ev);
                                }
                                populateRecyclerView();
                                Log.d("DATA:", ".1.");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
            Bundle parameters = new Bundle();
            parameters.putString("q", searchStr);
            parameters.putString("type", "event");
            request.setParameters(parameters);
            request.executeAsync();
        }


    }

    public FragmentExplore() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        callbackManager = CallbackManager.Factory.create();
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(getContext());
        return inflater.inflate(R.layout.fragment_explore, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        v = view;
        recyclerViewEvents = v.findViewById(R.id.recyclerViewEventsNearby);
        getEventsFromFB();
        populateRecyclerView();
    }

    public void getLocation(){
        try {
            mFusedLocationClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    Geocoder gcd = new Geocoder(getContext(), Locale.getDefault());
                    try {
                        List<Address> addresses = gcd.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                        if (addresses.size() > 0){
                            searchStr = addresses.get(0).getLocality();
                            Log.d("direccion:", searchStr);
                            getEventsFromFB();
                        }else {
                            Log.d("direccion:", "Not Aviable");
                            searchStr = "Error";
                            Log.d("direccion:", searchStr);
                            getEventsFromFB();
                        }
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                }
            });
        }
        catch(SecurityException e){
            searchStr = "Error";
            Log.d("EERASYNC" ,"TOROMAX");
        }
    }

    public void populateRecyclerView(){
        AdapterEventsNearby adapterEventsNearby = new AdapterEventsNearby(eventNearbyItems, getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerViewEvents.setLayoutManager(layoutManager);
        recyclerViewEvents.setAdapter(adapterEventsNearby);
    }
}
