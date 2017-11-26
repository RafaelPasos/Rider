package com.prodevsmx.rider.fragments;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prodevsmx.rider.APIClients.ApiUtils;
import com.prodevsmx.rider.APIClients.RiderEndPoints;
import com.prodevsmx.rider.Adapters.AdapterEventsNearby;
import com.prodevsmx.rider.Adapters.AdapterRequests;
import com.prodevsmx.rider.R;
import com.prodevsmx.rider.beans.BackEndModels.PickUpRequest;
import com.prodevsmx.rider.beans.EventNearbyItem;
import com.prodevsmx.rider.beans.PendingRequestItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentRequests extends android.support.v4.app.Fragment{

    View v;
    ArrayList<PendingRequestItem> pendingRequestItems = new ArrayList<>();
    RecyclerView recyclerViewRequests;

    RiderEndPoints mRiderEndPoints;

    public FragmentRequests() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_requests, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        v = view;
        mRiderEndPoints = ApiUtils.getRiderService();
        recyclerViewRequests = v.findViewById(R.id.recyclerViewPendingRequests);
        AdapterRequests adapterRequests = new AdapterRequests(pendingRequestItems, getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerViewRequests.setLayoutManager(layoutManager);
        recyclerViewRequests.setAdapter(adapterRequests);
        initializeViews(adapterRequests);

    }

    public void initializeViews(final AdapterRequests adapterRequests){

/*
        PendingRequestItem item = new PendingRequestItem("https://media.pitchfork.com/photos/59299367c0084474cd0bead4/1:1/w_300/90179474.jpg", "Susana Mérces", "Trapani", "Pasajero");
        pendingRequestItems.add(item);

        item = new PendingRequestItem("https://media.pitchfork.com/photos/59299367c0084474cd0bead4/1:1/w_300/90179474.jpg", "Anastasia Klimov", "Av. Chaikovski", "Pasajero");
        pendingRequestItems.add(item);

        item = new PendingRequestItem("https://media.pitchfork.com/photos/59299367c0084474cd0bead4/1:1/w_300/90179474.jpg", "Rogelio Rámirez", "Av. México", "Pasajero");
        pendingRequestItems.add(item);
*/
        mRiderEndPoints.requestForUser("asdasdasd").enqueue(new Callback<List<PickUpRequest>>() {
            @Override
            public void onResponse(Call<List<PickUpRequest>> call, Response<List<PickUpRequest>> response) {
                if(response.isSuccessful()) {
                    List<PickUpRequest> responseList =  response.body();
                    for(PickUpRequest p : responseList){
                        pendingRequestItems.add(PendingRequestItem.backEndModelMapper(p));
                    }
                    adapterRequests.notifyDataSetChanged();
                    Log.d("MainActivity", "posts loaded from API");
                }else {
                    int statusCode  = response.code();
                    // handle request errors depending on status code
                }
            }

            @Override
            public void onFailure(Call<List<PickUpRequest>> call, Throwable t) {
                Log.d("Loading Error", "error loading from API");
            }
        });

    }


}
