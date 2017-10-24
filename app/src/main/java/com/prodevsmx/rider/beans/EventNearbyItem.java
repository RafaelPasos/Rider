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

    private Bitmap eventImage;
    private String nameEvent;
    private String eventPlace;
    private String eventDate;

    public EventNearbyItem(Drawable eventImage, String nameEvent, String eventPlace, String eventDate) {
        Bitmap bitmapEvent = DrawableToBitmap.drawableToBitmap(eventImage);
        bitmapEvent = ImageRounder.getRoundedBitmap(bitmapEvent);
        this.eventImage = bitmapEvent;
        this.nameEvent = nameEvent;
        this.eventPlace = eventPlace;
        this.eventDate = eventDate;
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

    public Bitmap getEventImage() {
        return eventImage;
    }

    public void setEventImage(Bitmap eventImage) {
        this.eventImage = eventImage;
    }
}
