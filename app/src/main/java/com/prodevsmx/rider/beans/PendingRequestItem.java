package com.prodevsmx.rider.beans;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import com.prodevsmx.rider.utils.DrawableToBitmap;
import com.prodevsmx.rider.utils.ImageRounder;

/**
 * Created by Pasos on 27/10/2017.
 */

public class PendingRequestItem {

    Bitmap userImage;
    String userName;
    String mode;
    String pickup;


    public PendingRequestItem(Drawable userImage, String userName, String pickup, String mode) {
        Bitmap bitmapUser = DrawableToBitmap.drawableToBitmap(userImage);
        bitmapUser = ImageRounder.getRoundedBitmap(bitmapUser);

        this.userImage = bitmapUser;
        this.userName = userName;
        this.mode = mode;
        this.pickup = pickup;
    }

    public Bitmap getUserImage() {
        return userImage;
    }

    public void setUserImage(Bitmap userImage) {
        this.userImage = userImage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getPickup() {
        return pickup;
    }

    public void setPickup(String pickup) {
        this.pickup = pickup;
    }
}
