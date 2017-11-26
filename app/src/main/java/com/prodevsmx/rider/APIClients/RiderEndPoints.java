package com.prodevsmx.rider.APIClients;

import com.prodevsmx.rider.beans.BackEndModels.PickUpRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Damian Garcia on 11/26/2017.
 */


public interface RiderEndPoints {
    @GET("/api/chofer/PendingRequests/{id}")
    Call<List<PickUpRequest>> requestForUser(
        @Path("id") String id
    );


}