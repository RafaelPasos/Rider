package com.prodevsmx.rider.APIClients.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Damian Garcia on 11/28/2017.
 */

public class OverviewPolyLine {

    @SerializedName("points")
    public String points;

    public String getPoints() {
        return points;
    }
}
