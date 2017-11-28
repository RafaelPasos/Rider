package com.prodevsmx.rider.APIClients;

import com.prodevsmx.rider.APIClients.Response.GetRouteResponse;

import retrofit2.Call;

/**
 * Created by Damian Garcia on 11/28/2017.
 */

public class ApiManager {
    public Call<GetRouteResponse> getRouteApiGoogle (String latLongStart, String latLongFinal, String key, String language){
        GoogleMapsAPI apiService = ServiceGenerator.putOnlineStatus();
        return apiService.getRouteToUser(latLongStart, latLongFinal, key, language);
    }
}
