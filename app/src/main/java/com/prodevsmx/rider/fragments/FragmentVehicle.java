package com.prodevsmx.rider.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prodevsmx.rider.Adapters.AdapterCars;
import com.prodevsmx.rider.Adapters.AdapterEventsNearby;
import com.prodevsmx.rider.R;
import com.prodevsmx.rider.beans.CarItem;
import com.prodevsmx.rider.beans.EventNearbyItem;
import com.prodevsmx.rider.beans.SocialContact;

import java.util.ArrayList;


public class FragmentVehicle extends android.support.v4.app.Fragment {

    View v;
    ArrayList<CarItem> carItems = new ArrayList<>();
    RecyclerView recyclerViewCars;
    FloatingActionButton fabCarRegistration;
    TextInputEditText etCarModel;
    TextInputEditText etCarPassengerCapacity;
    TextInputEditText etCarPlates;
    AlertDialog.Builder dialog;
    LayoutInflater inflater;
    View dialogView;


    public FragmentVehicle() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vehicle, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        v = view;
        recyclerViewCars = v.findViewById(R.id.recyclerViewVehicles);
        fabCarRegistration = v.findViewById(R.id.fabAddVehicle);
        initializeViews();
        AdapterCars adapterCars = new AdapterCars(carItems, getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerViewCars.setLayoutManager(layoutManager);
        recyclerViewCars.setAdapter(adapterCars);
        fabCarRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogForm();
            }
        });

    }

    public void initializeViews() {

        Drawable drawable = getResources().getDrawable(R.drawable.fiesta, getActivity().getTheme());
        CarItem item = new CarItem(drawable, "Ford Fiesta 2016", "JMH-47-51");
        carItems.add(item);

        drawable = getResources().getDrawable(R.drawable.porsche, getActivity().getTheme());
        item = new CarItem(drawable, "Porsche 911 S", "JNU-17-58");
        carItems.add(item);
    }


    private void DialogForm() {
        dialog = new AlertDialog.Builder(getActivity());
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.dialog_car_form, null);
        dialog.setView(dialogView);
        dialog.setCancelable(true);
        dialog.setIcon(R.drawable.ic_car_black_48dp);
        dialog.setTitle("Car Registration");

        etCarModel = (TextInputEditText) dialogView.findViewById(R.id.etFormModelo);
        etCarPassengerCapacity = (TextInputEditText) dialogView.findViewById(R.id.etFormCapacidad);
        etCarPlates = (TextInputEditText) dialogView.findViewById(R.id.etFormPlacas);


        dialog.setPositiveButton("SUBMIT", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });

        dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }
}

