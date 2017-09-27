package com.prodevsmx.rider.beans;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Pasos on 26/09/2017.
 */

public class EventNearbyItem {

    private ImageView eventImage;
    private String nameEvent;
    private String eventPlace;
    private String eventDate;

    public String getNameEvent() {
        return nameEvent;
    }

    public void setNameEvent(String nameEvent) {
        this.nameEvent = nameEvent;
    }

    public String getEventPlace() {
        return eventPlace;
    }

    public void setEventPlace(String eventPlace) {
        this.eventPlace = eventPlace;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public ImageView getEventImage() {
        return eventImage;
    }

    public void setEventImage(ImageView eventImage) {
        this.eventImage = eventImage;
    }
}
