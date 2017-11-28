package com.prodevsmx.rider.APIClients;

/**
 * Created by Damian Garcia on 11/26/2017.
 */

public class ApiUtils {
    public static final String RIDER_BASE_URL = "http://riderbackend.azurewebsites.net/";

    public static RiderEndPoints getRiderService(){
        return RetrofitClient.getClient(RIDER_BASE_URL).create(RiderEndPoints.class);
    }
}
