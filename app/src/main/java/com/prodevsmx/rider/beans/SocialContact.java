package com.prodevsmx.rider.beans;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.prodevsmx.rider.utils.DrawableToBitmap;
import com.prodevsmx.rider.utils.ImageRounder;

/**
 * Created by Pasos on 24/10/2017.
 */

public class SocialContact {
    private String socialImage;
    private String socialName;
    private String socialInfo;


    public SocialContact(String socialImage, String socialName, String socialInfo) {
        this.socialImage = socialImage;
        this.socialName = socialName;
        this.socialInfo = socialInfo;
    }

    public String getSocialImage() {
        return socialImage;
    }

    public void setSocialImage(String socialImage) {
        this.socialImage = socialImage;
    }

    public String getSocialName() {
        return socialName;
    }

    public void setSocialName(String socialName) {
        this.socialName = socialName;
    }

    public String getSocialInfo() {
        return socialInfo;
    }

    public void setSocialInfo(String socialInfo) {
        this.socialInfo = socialInfo;
    }
}
