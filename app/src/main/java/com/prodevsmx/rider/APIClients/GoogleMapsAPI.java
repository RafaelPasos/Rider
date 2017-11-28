package com.prodevsmx.rider.APIClients;

import com.prodevsmx.rider.APIClients.Response.GetRouteResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Damian Garcia on 11/28/2017.
 */

public interface GoogleMapsAPI {

    //Get Route to user
    @GET("maps/api/directions/json")
    Call<GetRouteResponse> getRouteToUser(@Query("origin") String origin, @Query("destination") String destination, @Query("key") String key, @Query("language") String language);
}
