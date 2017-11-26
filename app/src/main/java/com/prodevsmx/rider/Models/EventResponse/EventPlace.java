package com.prodevsmx.rider.Models.EventResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventPlace {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("location")
    @Expose
    private EventLocation location;
    @SerializedName("id")
    @Expose
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EventLocation getLocation() {
        return location;
    }

    public void setLocation(EventLocation location) {
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
