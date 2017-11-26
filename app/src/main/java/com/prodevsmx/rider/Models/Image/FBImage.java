package com.prodevsmx.rider.Models.Image;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class FBImage {
    @SerializedName("data")
    @Expose
    private ImageData data;
    public ImageData getData() {
        return data;
    }
    public void setData(ImageData data) {
        this.data = data;
    }
}
