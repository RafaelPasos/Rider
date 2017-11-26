package com.prodevsmx.rider.beans.BackEndModels;

import java.util.Date;

/**
 * Created by Damian Garcia on 11/26/2017.
 */

public class PickUpRequest {

    public enum PickUpStatus{
        PU_PENDING(-1), PU_REJECTED(0),PU_ACCEPTED(1);
        private int value;

        private PickUpStatus(int value) {
            this.value = value;
        }

    }

    private String _id ;
    private String eventId ;
    private Persona chofer;
    private Persona pasajero;
    private String address;
    private GeoPoint coordenadas ;
    private Date time;
    private PickUpStatus status ;


    public PickUpRequest(String _id, String eventId, Persona chofer, Persona pasajero, String addres, GeoPoint coordenadas, Date time, PickUpStatus status) {
        this._id = _id;
        this.eventId = eventId;
        this.chofer = chofer;
        this.pasajero = pasajero;
        this.address =  addres;
        this.coordenadas = coordenadas;
        this.time = time;
        this.status = status;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public Persona getChofer() {
        return chofer;
    }

    public void setChofer(Persona chofer) {
        this.chofer = chofer;
    }

    public Persona getPasajero() {
        return pasajero;
    }

    public void setPasajero(Persona pasajero) {
        this.pasajero = pasajero;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public GeoPoint getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(GeoPoint coordenadas) {
        this.coordenadas = coordenadas;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public PickUpStatus getStatus() {
        return status;
    }

    public void setStatus(PickUpStatus status) {
        this.status = status;
    }
}
