package com.prodevsmx.rider.APIClients.Response;

import com.google.gson.annotations.SerializedName;
import com.prodevsmx.rider.APIClients.Models.Route;

import java.util.List;

/**
 * Created by Damian Garcia on 11/28/2017.
 */

public class GetRouteResponse {

    @SerializedName("routes")
    List<Route> routes;

    @SerializedName("status")
    String status;

    public List<Route> getRoutes() {
        return routes;
    }

    public String getStatus(){
        return status;
    }

}
