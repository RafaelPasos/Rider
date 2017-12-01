package com.prodevsmx.rider.beans;

/**
 * Created by rpasos on 01/12/17.
 */

public class PastRide {
    String map;
    String eventName;
    String eventDate;


    public PastRide(String map, String eventName, String eventDate) {
        this.map = map;
        this.eventName = eventName;
        this.eventDate = eventDate;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }
}
