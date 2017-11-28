package com.prodevsmx.rider.APIClients.RequestModels;

import android.graphics.Bitmap;

import com.prodevsmx.rider.beans.CarItem;
import com.prodevsmx.rider.utils.Base64Utils;

import static com.prodevsmx.rider.utils.Base64Utils.encodeToBase64;

/**
 * Created by Damian Garcia on 11/28/2017.
 */

public class CarRequest {
    public String model;
    public String plates;
    public String imageBase64;

    public  CarRequest(CarItem carItem){
        this.model = carItem.getCarTitle();
        this.plates = carItem.getCarPlates();
        Bitmap myBitmap = carItem.getCarImage();
        String base64ed = encodeToBase64(myBitmap, Bitmap.CompressFormat.JPEG, 100);
        this.imageBase64 = base64ed;
    }

    public CarRequest(String model, String plates, String imageBase64) {
        this.model = model;
        this.plates = plates;
        this.imageBase64 = imageBase64;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlates() {
        return plates;
    }

    public void setPlates(String plates) {
        this.plates = plates;
    }

    public String getImageBase64() {
        return imageBase64;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }
}


