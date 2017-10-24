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
    private Bitmap socialImage;
    private String socialName;
    private String socialInfo;


    public SocialContact(Drawable socialImage, String socialName, String socialInfo) {
        Bitmap bitmapSocial = DrawableToBitmap.drawableToBitmap(socialImage);
        bitmapSocial = ImageRounder.getRoundedBitmap(bitmapSocial);
        this.socialImage = bitmapSocial;
        this.socialName = socialName;
        this.socialInfo = socialInfo;
    }

    public Bitmap getSocialImage() {
        return socialImage;
    }

    public void setSocialImage(Bitmap socialImage) {
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
