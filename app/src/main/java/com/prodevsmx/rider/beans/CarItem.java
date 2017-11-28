package com.prodevsmx.rider.beans;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import com.prodevsmx.rider.APIClients.RequestModels.CarRequest;
import com.prodevsmx.rider.utils.Base64Utils;
import com.prodevsmx.rider.utils.DrawableToBitmap;
import com.prodevsmx.rider.utils.ImageRounder;

/**
 * Created by Pasos on 24/10/2017.
 */

public class CarItem {
    private Bitmap carImage;
    private String carTitle;
    private String carPlates;

    public CarItem(Drawable carImage, String carTitle, String carPlates) {
        Bitmap bitmapCar = DrawableToBitmap.drawableToBitmap(carImage);
        bitmapCar = ImageRounder.getRoundedBitmap(bitmapCar);
        this.carImage = bitmapCar;
        this.carTitle = carTitle;
        this.carPlates = carPlates;
    }

    public CarItem(CarRequest carRequest){
        this.carTitle = carRequest.getModel();
        this.carPlates = carRequest.getPlates();
        this.carImage = Base64Utils.decodeBase64(carRequest.getImageBase64());
    }

    public Bitmap getCarImage() {
        return carImage;
    }

    public void setCarImage(Bitmap carImage) {
        this.carImage = carImage;
    }

    public String getCarTitle() {
        return carTitle;
    }

    public void setCarTitle(String carTitle) {
        this.carTitle = carTitle;
    }

    public String getCarPlates() {
        return carPlates;
    }

    public void setCarPlates(String carPlates) {
        this.carPlates = carPlates;
    }
}
