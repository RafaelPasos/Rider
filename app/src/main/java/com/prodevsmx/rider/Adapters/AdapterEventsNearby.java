package com.prodevsmx.rider.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.prodevsmx.rider.R;
import com.prodevsmx.rider.beans.EventNearbyItem;
import com.prodevsmx.rider.utils.DrawableToBitmap;
import com.prodevsmx.rider.utils.ImageRounder;
import com.squareup.picasso.Picasso;

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

    @Override public void onBindViewHolder(ViewHolder holder, int position) {
        EventNearbyItem item = items.get(position);
         //Set data to UI Elements
        holder.eventName.setText(item.getNameEvent());
        holder.eventPlace.setText(item.getEventPlace());
        holder.eventDate.setText(item.getEventDate());
        //not Now
        //Bitmap eventBitmap = ImageRounder.getRoundedBitmap(DrawableToBitmap.drawableToBitmap(item.getEventImage().getDrawable()));
        holder.eventImage.setImageBitmap(item.getEventImage());
        holder.itemView.setTag(item);
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
            eventImage = (ImageView) itemView.findViewById(R.id.ivEventImage);
            eventName = (TextView) itemView.findViewById(R.id.tvEventTitle);
            eventPlace = (TextView) itemView.findViewById(R.id.tv_EventDetail);
            eventDate = (TextView) itemView.findViewById(R.id.tv_EventDate);
        }
    }
}
