package com.prodevsmx.rider.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.prodevsmx.rider.R;
import com.prodevsmx.rider.beans.CarItem;
import com.prodevsmx.rider.beans.PastRide;
import com.prodevsmx.rider.utils.ImageRounder;
import com.prodevsmx.rider.utils.RoundedCornersTransform;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by rpasos on 01/12/17.
 */

public class AdapterPastRides extends RecyclerView.Adapter<AdapterPastRides.ViewHolder>{

    private List<PastRide> items;
    private Context context;

    public AdapterPastRides(List<PastRide> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override public AdapterPastRides.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_past_ride, parent, false);
        return new AdapterPastRides.ViewHolder(v);
    }

    @Override public void onBindViewHolder(AdapterPastRides.ViewHolder holder, int position) {
        PastRide item = items.get(position);
        //Set data to UI Elements
        holder.eventName.setText(item.getEventName());
        holder.eventDate.setText(item.getEventDate());
        //not Now
        //Bitmap eventBitmap = ImageRounder.getRoundedBitmap(item.getCarImage());
        Picasso.with(context).load(item.getMap()).into(holder.map);
        //holder.carImage.setImageBitmap(ImageRounder.getRoundedBitmap(item.getCarImage()));

        holder.itemView.setTag(item);
    }



    @Override public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView map;
        public TextView eventName;
        public TextView eventDate;

        public ViewHolder(View itemView) {
            super(itemView);
            map = (ImageView) itemView.findViewById(R.id.ivPastRide);
            eventName = (TextView) itemView.findViewById(R.id.tvPastRidesTitle);
            eventDate = (TextView) itemView.findViewById(R.id.tvPastRidesDate);
        }
    }

}
