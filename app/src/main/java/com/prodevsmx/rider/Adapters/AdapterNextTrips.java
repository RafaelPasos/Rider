package com.prodevsmx.rider.Adapters;

import android.content.Context;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.prodevsmx.rider.ActivityRideDetail;
import com.prodevsmx.rider.R;
import com.prodevsmx.rider.beans.EventNearbyItem;
import com.prodevsmx.rider.utils.RoundedCornersTransform;
import com.squareup.picasso.Picasso;

import java.util.List;



public class AdapterNextTrips  extends RecyclerView.Adapter<AdapterNextTrips.ViewHolder> {

    private static List<EventNearbyItem> items;
    private Context context;

    @Override
    public AdapterNextTrips.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_event, parent, false);
        return new ViewHolder(v,context);
    }

    public AdapterNextTrips(List<EventNearbyItem> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(AdapterNextTrips.ViewHolder holder, int position) {
        EventNearbyItem item = items.get(position);
        //Set data to UI Elements

        holder.eventName.setText(item.getNameEvent());
        holder.eventPlace.setText(item.getEventPlace());
        holder.eventDate.setText(item.getEventDate());
        //not Now
        //Bitmap eventBitmap = ImageRounder.getRoundedBitmap(DrawableToBitmap.drawableToBitmap(item.getEventImage().getDrawable()));
        Picasso.with(context).load(item.getEventImage()).transform(new RoundedCornersTransform()).into(holder.eventImage);
        holder.itemView.setTag(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView eventImage;
        private TextView eventName;
        private TextView eventPlace;
        private TextView eventDate;


        private ViewHolder(final View itemView, final Context context) {
            super(itemView);
            eventImage = (ImageView) itemView.findViewById(R.id.ivEventImageDetail);
            eventName = (TextView) itemView.findViewById(R.id.tvEventTitleDetail);
            eventPlace = (TextView) itemView.findViewById(R.id.tv_EventDetailDetail);
            eventDate = (TextView) itemView.findViewById(R.id.tv_EventDateDetail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String eventImage = items.get(getAdapterPosition()).getEventImage();
                    String eventName = items.get(getAdapterPosition()).getNameEvent();
                    String eventPlace = items.get(getAdapterPosition()).getEventPlace();
                    String eventDate = items.get(getAdapterPosition()).getEventDate();
                    Bundle data = new Bundle();
                    data.putString("image", eventDate);
                    data.putString("name", eventName);
                    data.putString("place", eventPlace);
                    data.putString("date", eventDate);
                    Intent i = new Intent(itemView.getContext(), ActivityRideDetail.class);
                    i.putExtras(data);
                    itemView.getContext().startActivity(i);
                }
            });
        }
    }

}
