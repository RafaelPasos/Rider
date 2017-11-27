package com.prodevsmx.rider.Models.EventResponse;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EventResponse {

    @SerializedName("data")
    @Expose
    private List<EventDatum> data = null;
    @SerializedName("paging")
    @Expose
    private Paging paging;

    public List<EventDatum> getData() {
        return data;
    }

    public void setData(List<EventDatum> data) {
        this.data = data;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }

}