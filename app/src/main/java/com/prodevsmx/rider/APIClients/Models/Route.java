package com.prodevsmx.rider.APIClients.Models;

import java.util.List;

/**
 * Created by Damian Garcia on 11/28/2017.
 */


public class Route {

    private OverviewPolyLine overviewPolyLine;

    private List<Legs> legs;

    public OverviewPolyLine getOverviewPolyLine() {
        return overviewPolyLine;
    }

    public List<Legs> getLegs() {
        return legs;
    }
}
