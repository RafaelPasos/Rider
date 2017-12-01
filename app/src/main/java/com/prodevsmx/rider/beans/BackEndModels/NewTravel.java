package com.prodevsmx.rider.beans.BackEndModels;

/**
 * Created by Carlos on 30/11/2017.
 */

public class NewTravel {
    private String personId;
    private String eventId;
    private String carId;
    private GeoPoint start;

    public NewTravel(){

    }

    public NewTravel(String personId, String eventId, String carId, GeoPoint start) {
        this.personId = personId;
        this.eventId = eventId;
        this.carId = carId;
        this.start = start;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public GeoPoint getStart() {
        return start;
    }

    public void setStart(GeoPoint start) {
        this.start = start;
    }
}
