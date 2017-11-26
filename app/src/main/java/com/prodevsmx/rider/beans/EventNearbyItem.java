package com.prodevsmx.rider.beans;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;

import com.prodevsmx.rider.utils.DrawableToBitmap;
import com.prodevsmx.rider.utils.ImageRounder;

/**
 * Created by Pasos on 26/09/2017.
 */

public class EventNearbyItem {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String eventImage;
    private String nameEvent;
    private String eventPlace;
    private String eventDate;

    public EventNearbyItem(String id, String nameEvent, String eventPlace, String eventDate) {
        this.id = id;
        this.nameEvent = nameEvent;
        this.eventPlace = eventPlace;
        this.eventDate = eventDate;
        eventImage = "http://icons.iconarchive.com/icons/dakirby309/windows-8-metro/256/Folders-OS-Default-Metro-icon.png";
    }

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

    public String getEventImage() {
        return eventImage;
    }

    public void setEventImage(String eventImage) {
        this.eventImage = eventImage;
    }
}
