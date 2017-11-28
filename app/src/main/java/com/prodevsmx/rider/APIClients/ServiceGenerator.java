package com.prodevsmx.rider.APIClients;

import android.text.TextUtils;
import android.util.Log;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Damian Garcia on 11/28/2017.
 */


public class ServiceGenerator {

    private static GoogleMapsAPI API_SERVICE;

    private static final String TAG = ServiceGenerator.class.getSimpleName();

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    //Petitions to api google
    public static GoogleMapsAPI putOnlineStatus(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://maps.googleapis.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        API_SERVICE = retrofit.create(GoogleMapsAPI.class);
        return API_SERVICE;
    }

}