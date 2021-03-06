package com.prodevsmx.rider.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.prodevsmx.rider.ActivityEventDetail;
import com.prodevsmx.rider.R;
import com.prodevsmx.rider.beans.EventNearbyItem;
import com.prodevsmx.rider.utils.RoundedCornersTransform;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Pasos on 26/09/2017.
 */

public class AdapterEventsNearby extends RecyclerView.Adapter<AdapterEventsNearby.ViewHolder>{

    private List<EventNearbyItem> items;
    private Context context;

    public AdapterEventsNearby(List<EventNearbyItem> items, Context context) {
            this.items = items;
            this.context = context;
    }

    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_event, parent, false);
        return new ViewHolder(v);
    }

    public static Bitmap getFacebookProfilePicture(String userID) throws IOException {
        URL imageURL = new URL("https://graph.facebook.com/" + userID + "/picture?type=large");
        Bitmap bitmap = BitmapFactory.decodeStream(imageURL.openConnection().getInputStream());
        return bitmap;
    }

    @Override public void onBindViewHolder(final ViewHolder holder, int position) {
        final EventNearbyItem item = items.get(position);
        //Set data to UI Elements
        //not Now
        //Bitmap eventBitmap = ImageRounder.getRoundedBitmap(DrawableToBitmap.drawableToBitmap(item.getEventImage().getDrawable()));
        //holder.eventImage.setImageBitmap(item.getEventImage());
        holder.eventName.setText(item.getNameEvent());
        holder.eventPlace.setText(item.getEventPlace());
        Date date = null;
        String formattedDate = "";
        try {
            date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss-SSSS").parse(item.getEventDate());
            formattedDate = new SimpleDateFormat("dd/MM/yyyy, Ka").format(date);

        }catch (Exception e){
            e.printStackTrace();
        }

        holder.eventDate.setText(formattedDate);
        Picasso.with(context).load("https://graph.facebook.com/" + item.getId() + "/picture").transform(new RoundedCornersTransform()).into(holder.eventImage);
        holder.itemView.setTag(item);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle data = new Bundle();
                data.putString("id", item.getId());
                Intent i = new Intent(context, ActivityEventDetail.class);
                i.putExtras(data);
                context.startActivity(i);

                //((Activity) context).finish();
            }
        });
    }

    @Override public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView eventImage;
        public TextView eventName;
        public TextView eventPlace;
        public TextView eventDate;

        public ViewHolder(View itemView) {
            super(itemView);
            eventImage = (ImageView) itemView.findViewById(R.id.ivEventImageDetail);
            eventName = (TextView) itemView.findViewById(R.id.tvEventTitleDetail);
            eventPlace = (TextView) itemView.findViewById(R.id.tv_EventDetailDetail);
            eventDate = (TextView) itemView.findViewById(R.id.tv_EventDateDetail);
        }
    }
}
