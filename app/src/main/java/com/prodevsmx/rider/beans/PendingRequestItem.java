package com.prodevsmx.rider.beans;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import com.google.android.gms.maps.model.LatLng;
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
    String request_id;
    LatLng pickupPoint;



    public PendingRequestItem(String userImage, String userName, String pickup, String mode, String request_id) {
        this.userImage = userImage;
        this.userName = userName;
        this.mode = mode;
        this.pickup = pickup;
        this.request_id = request_id;
    }

    public PendingRequestItem(String userImage, String userName, LatLng pickupPoint, String mode, String request_id) {
        this.userImage = userImage;
        this.userName = userName;
        this.mode = mode;
        this.pickupPoint = pickupPoint;
        this.request_id = request_id;
    }

    public PendingRequestItem(String userImage, String userName, String pickup, LatLng pickupPoint, String mode, String request_id) {
        this.userImage = userImage;
        this.userName = userName;
        this.mode = mode;
        this.pickup = pickup;
        this.pickupPoint = pickupPoint;
        this.request_id = request_id;
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

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public static PendingRequestItem backEndModelMapper(PickUpRequest backEndModel){
        String userImage = "https://media.pitchfork.com/photos/59299367c0084474cd0bead4/1:1/w_300/90179474.jpg";
        String userName = backEndModel.getPasajero().getName();
        String mode = "pasajero";
        String pickup = backEndModel.getAddress();
        String id = backEndModel.get_id();

        PendingRequestItem  generated =  new PendingRequestItem(userImage, userName, mode, pickup, id);
        return generated;
    }


    public LatLng getPickupPoint() {
        return pickupPoint;
    }

    public void setPickupPoint(LatLng pickupPoint) {
        this.pickupPoint = pickupPoint;
    }
}
