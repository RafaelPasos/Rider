package com.prodevsmx.rider.fragments;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.facebook.internal.Utility;
import com.prodevsmx.rider.ActivityLand;
import com.prodevsmx.rider.Adapters.AdapterCars;
import com.prodevsmx.rider.Adapters.AdapterEventsNearby;
import com.prodevsmx.rider.R;
import com.prodevsmx.rider.beans.CarItem;
import com.prodevsmx.rider.beans.EventNearbyItem;
import com.prodevsmx.rider.beans.SocialContact;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;
import static com.facebook.FacebookSdk.getApplicationContext;


public class FragmentVehicle extends android.support.v4.app.Fragment {

    public static final int MY_REQUEST_CAMERA   = 10;
    public static final int MY_REQUEST_WRITE_CAMERA   = 11;
    public static final int CAPTURE_CAMERA   = 12;

    public static final int MY_REQUEST_READ_GALLERY   = 13;
    public static final int MY_REQUEST_WRITE_GALLERY   = 14;
    public static final int MY_REQUEST_GALLERY   = 15;


    View v;
    ArrayList<CarItem> carItems = new ArrayList<>();
    RecyclerView recyclerViewCars;
    FloatingActionButton fabCarRegistration;
    TextInputEditText etCarModel;
    ImageView selectCar;
    TextInputEditText etCarPlates;
    AlertDialog.Builder dialog;
    LayoutInflater inflater;
    View dialogView;
    private static final int PICK_MODE = 100;
    private static final int TAKE_PHOTO = 101;
    Uri imageUri;


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
        displayCarsInRecyler();
        fabCarRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogForm();
            }
        });

    }

    private void initializeViews() {

        Drawable drawable = getResources().getDrawable(R.drawable.fiesta, getActivity().getTheme());
        CarItem item = new CarItem(drawable, "Ford Fiesta 2016", "JMH-47-51");
        carItems.add(item);

        drawable = getResources().getDrawable(R.drawable.porsche, getActivity().getTheme());
        item = new CarItem(drawable, "Porsche 911 S", "JNU-17-58");
        carItems.add(item);

    }

    private void addCar(Drawable carImage, String modelName, String plates){
        CarItem item = new CarItem(carImage, modelName, plates);
        carItems.add(item);
        displayCarsInRecyler();
    }

    private void displayCarsInRecyler(){
        AdapterCars adapterCars = new AdapterCars(carItems, getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerViewCars.setLayoutManager(layoutManager);
        recyclerViewCars.setAdapter(adapterCars);
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
        selectCar = (ImageView) dialogView.findViewById(R.id.ivSelectCar);
        etCarPlates = (TextInputEditText) dialogView.findViewById(R.id.etFormPlacas);

        selectCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectImage();
                //openGallery();
            }
        });

        dialog.setPositiveButton("SUBMIT", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Drawable d = selectCar.getDrawable();
                addCar(d, etCarModel.getText().toString(), etCarPlates.getText().toString());
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


    private void openGallery(){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_MODE);
    }

    private void openCamera(){
        checkPermissionCW();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == PICK_MODE){
            imageUri = data.getData();
            selectCar.setImageURI(imageUri);
        }
        if (resultCode == RESULT_OK && requestCode == TAKE_PHOTO){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            selectCar.setImageBitmap(bitmap);
        }

    }

    private void selectImage() {
        final CharSequence[] items = { "Take Photo", "Choose from Gallery",
                "Cancel" };
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Add a photo");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (items[item].equals("Take Photo")) {
                    openCamera();
                } else if (items[item].equals("Choose from Gallery")) {
                    openGallery();
                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    private void checkPermissionCA(){
        int permissionCheck = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    getActivity(), new String[]{Manifest.permission.CAMERA}, MY_REQUEST_CAMERA);
        } else {
            takePhoto();
        }
    }

    private void checkPermissionCW(){
        int permissionCheck = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_REQUEST_WRITE_CAMERA);
            checkPermissionCW();
        } else {
            checkPermissionCA();
        }
    }

    private void takePhoto() {
        Intent openCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(openCamera, TAKE_PHOTO);
    }
}

