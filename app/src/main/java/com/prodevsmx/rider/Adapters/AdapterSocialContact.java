package com.prodevsmx.rider.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.prodevsmx.rider.R;
import com.prodevsmx.rider.beans.SocialContact;
import com.prodevsmx.rider.utils.DrawableToBitmap;
import com.prodevsmx.rider.utils.ImageRounder;

import java.util.List;


/**
 * Created by Pasos on 24/10/2017.
 */

public class AdapterSocialContact extends RecyclerView.Adapter<AdapterSocialContact.ViewHolder> {

    private List<SocialContact> items;
    private Context context;

    public AdapterSocialContact(List<SocialContact> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_social_contact, parent, false);
        return new AdapterSocialContact.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SocialContact item = items.get(position);
        //Set data to UI Elements
        holder.socialName.setText(item.getSocialName());
        holder.socialData.setText(item.getSocialInfo());

        //not Now
        //Bitmap eventBitmap = ImageRounder.getRoundedBitmap(DrawableToBitmap.drawableToBitmap(item.getSocialImage().getDrawable()));
        holder.socialImage.setImageBitmap(item.getSocialImage());
        holder.itemView.setTag(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView socialImage;
        public TextView socialName;
        public TextView socialData;

        public ViewHolder(View v) {
            super(v);
            socialImage = v.findViewById(R.id.ivSocialImage);
            socialName  = v.findViewById(R.id.tvSocialTitle);
            socialData  = v.findViewById(R.id.tv_SocialInformation);
        }
    }
}
