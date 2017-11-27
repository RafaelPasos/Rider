package com.prodevsmx.rider.Models.EventResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EventTime {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("start_time")
    @Expose
    private String startTime;
    @SerializedName("end_time")
    @Expose
    private String endTime;
    @SerializedName("ticket_uri")
    @Expose
    private String ticketUri;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getstart_time() {
        return startTime;
    }

    public void setstart_time(String startTime) {
        this.startTime = startTime;
    }

    public String getend_time() {
        return endTime;
    }

    public void setend_time(String endTime) {
        this.endTime = endTime;
    }

    public String getticket_uri() {
        return ticketUri;
    }

    public void setticket_uri(String ticketUri) {
        this.ticketUri = ticketUri;
    }

}