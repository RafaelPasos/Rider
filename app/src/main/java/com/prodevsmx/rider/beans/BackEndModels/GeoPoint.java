package com.prodevsmx.rider.beans.BackEndModels;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Damian Garcia on 11/26/2017.
 */

public class GeoPoint {
    public String type;
    public ArrayList<Double> coordinates;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Double> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(ArrayList<Double> coordinates) {
        this.coordinates = coordinates;
    }

    public GeoPoint(String type, ArrayList<Double> coordinates) {
        this.type = type;
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "type : " + type;
    }
}
