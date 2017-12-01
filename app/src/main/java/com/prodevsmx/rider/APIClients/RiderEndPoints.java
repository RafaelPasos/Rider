package com.prodevsmx.rider.APIClients;

import com.prodevsmx.rider.APIClients.RequestModels.CarRequest;
import com.prodevsmx.rider.beans.BackEndModels.NewTravel;
import com.prodevsmx.rider.beans.BackEndModels.PickUpRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Damian Garcia on 11/26/2017.
 */


public interface RiderEndPoints {
    @GET("/api/chofer/PendingRequests/{id}")
    Call<List<PickUpRequest>> requestForUser(
            @Path("id") String id
    );

    @POST("/api/chofer/{id_chofer}/Accept/{id_request}")
    Call<Void> acceptRequest(
            @Path("id_chofer") String id_chofer,
            @Path("id_request") String id_request
    );

    @POST("/api/User/{id_usuario}/RegistrarVehiculo")
    Call<Void> storeCar(
            @Body CarRequest carro,
            @Path("id_usuario") String id_usuario
    );

    @GET("/api/User/{id_usuario}/GetVehiculos")
    Call<List<CarRequest>> getCars(
            @Path("id_usuario") String id_usuario
    );

    @GET("/api/User/{id_usuario}/SimpleCarList/")
    Call<List<CarRequest>> getCarsList(
            @Path("id_usuario") String id_usuario
    );
    
    @POST("/api/Chofer/{id_chofer}/CrearViaje/")
    Call<String> crearViaje(
            @Body NewTravel travel,
            @Path("id_chofer") String chofer
    );
}