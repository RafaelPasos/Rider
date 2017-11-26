package com.prodevsmx.rider.beans;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import com.prodevsmx.rider.beans.BackEndModels.PickUpRequest;
import com.prodevsmx.rider.utils.DrawableToBitmap;
import com.prodevsmx.rider.utils.ImageRounder;

/**
 * Created by Pasos on 27/10/2017.
 */

public class PendingRequestItem {

    String userImage;
    String userName;
    String mode;
    String pickup;


    public PendingRequestItem(String userImage, String userName, String pickup, String mode) {
        this.userImage = userImage;
        this.userName = userName;
        this.mode = mode;
        this.pickup = pickup;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
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

    public static PendingRequestItem backEndModelMapper(PickUpRequest backEndModel){
        String userImage = "https://media.pitchfork.com/photos/59299367c0084474cd0bead4/1:1/w_300/90179474.jpg";
        String userName = backEndModel.getPasajero().getName();
        String mode = "pasajero";
        String pickup = backEndModel.getAddress();

        PendingRequestItem  generated =  new PendingRequestItem(userImage, userName, mode, pickup);
        return generated;
    }
}
