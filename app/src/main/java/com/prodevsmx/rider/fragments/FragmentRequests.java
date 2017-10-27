package com.prodevsmx.rider.fragments;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prodevsmx.rider.Adapters.AdapterEventsNearby;
import com.prodevsmx.rider.Adapters.AdapterRequests;
import com.prodevsmx.rider.R;
import com.prodevsmx.rider.beans.EventNearbyItem;
import com.prodevsmx.rider.beans.PendingRequestItem;

import java.util.ArrayList;


public class FragmentRequests extends android.support.v4.app.Fragment{

    View v;
    ArrayList<PendingRequestItem> pendingRequestItems = new ArrayList<>();
    RecyclerView recyclerViewRequests;

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
        recyclerViewRequests = v.findViewById(R.id.recyclerViewPendingRequests);
        initializeViews();
        AdapterRequests adapterRequests = new AdapterRequests(pendingRequestItems, getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerViewRequests.setLayoutManager(layoutManager);
        recyclerViewRequests.setAdapter(adapterRequests);
    }

    public void initializeViews(){
        Drawable drawable = getResources().getDrawable(R.drawable.susana, getActivity().getTheme());
        PendingRequestItem item = new PendingRequestItem(drawable, "Susana Mérces", "Trapani", "Pasajero");
        pendingRequestItems.add(item);

        drawable = getResources().getDrawable(R.drawable.ana, getActivity().getTheme());
        item = new PendingRequestItem(drawable, "Anastasia Klimov", "Av. Chaikovski", "Pasajero");
        pendingRequestItems.add(item);

        drawable = getResources().getDrawable(R.drawable.roger, getActivity().getTheme());
        item = new PendingRequestItem(drawable, "Rogelio Rámirez", "Av. México", "Pasajero");
        pendingRequestItems.add(item);
    }


}
