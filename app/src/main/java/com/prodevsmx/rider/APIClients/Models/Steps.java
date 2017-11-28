package com.prodevsmx.rider.APIClients.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Damian Garcia on 11/28/2017.
 */

public class Steps {

    private LocationPoint start_location;
    private LocationPoint end_location;
    private OverviewPolyLine polyline;

    @SerializedName("distance")
    @Expose
    private Distance distance;

    @SerializedName("html_instructions")
    @Expose
    private String htmlInstructions;

    @SerializedName("maneuver")
    @Expose
    private String maneuver;

    public LocationPoint getStart_location() {
        return start_location;
    }

    public LocationPoint getEnd_location() {
        return end_location;
    }

    public OverviewPolyLine getPolyline() {
        return polyline;
    }

    public Distance getDistance() {
        return distance;
    }

    public void setDistance(Distance distance) {
        this.distance = distance;
    }

    public String getHtmlInstructions() {
        return htmlInstructions;
    }

    public void setHtmlInstructions(String htmlInstructions) {
        this.htmlInstructions = htmlInstructions;
    }

    public String getManeuver() {
        return maneuver;
    }

    public void setManeuver(String maneuver) {
        this.maneuver = maneuver;
    }
}
