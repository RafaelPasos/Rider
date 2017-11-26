package com.prodevsmx.rider.Models.EventResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventDatum {

    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("end_time")
    @Expose
    private String end_time;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("place")
    @Expose
    private EventPlace place;
    @SerializedName("start_time")
    @Expose
    private String startTime;
    @SerializedName("id")
    @Expose
    private String id;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getend_time() {
        return end_time;
    }

    public void setend_time(String end_time) {
        this.end_time = end_time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EventPlace getPlace() {
        return place;
    }

    public void setPlace(EventPlace place) {
        this.place = place;
    }

    public String getstart_time() {
        return startTime;
    }

    public void setstart_time(String startTime) {
        this.startTime = startTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
