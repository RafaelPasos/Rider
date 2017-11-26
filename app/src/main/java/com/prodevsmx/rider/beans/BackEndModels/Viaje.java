package com.prodevsmx.rider.beans.BackEndModels;

import java.util.ArrayList;

/**
 * Created by Damian Garcia on 11/26/2017.
 */

public class Viaje {
    public String _id ;
    public Persona chofer ;
    public Carro carro ;
    public GeoPoint locacionChofer ;
    public ArrayList<PickUpRequest> request ;
    public ArrayList<PickUpRequest> aceptados ;
    public ArrayList<PickUpRequest> rechazados ;
    public String status ;

    public Viaje(String _id, Persona chofer, Carro carro, GeoPoint locacionChofer, ArrayList<PickUpRequest> request, ArrayList<PickUpRequest> aceptados, ArrayList<PickUpRequest> rechazados, String status) {
        this._id = _id;
        this.chofer = chofer;
        this.carro = carro;
        this.locacionChofer = locacionChofer;
        this.request = request;
        this.aceptados = aceptados;
        this.rechazados = rechazados;
        this.status = status;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Persona getChofer() {
        return chofer;
    }

    public void setChofer(Persona chofer) {
        this.chofer = chofer;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public GeoPoint getLocacionChofer() {
        return locacionChofer;
    }

    public void setLocacionChofer(GeoPoint locacionChofer) {
        this.locacionChofer = locacionChofer;
    }

    public ArrayList<PickUpRequest> getRequest() {
        return request;
    }

    public void setRequest(ArrayList<PickUpRequest> request) {
        this.request = request;
    }

    public ArrayList<PickUpRequest> getAceptados() {
        return aceptados;
    }

    public void setAceptados(ArrayList<PickUpRequest> aceptados) {
        this.aceptados = aceptados;
    }

    public ArrayList<PickUpRequest> getRechazados() {
        return rechazados;
    }

    public void setRechazados(ArrayList<PickUpRequest> rechazados) {
        this.rechazados = rechazados;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
