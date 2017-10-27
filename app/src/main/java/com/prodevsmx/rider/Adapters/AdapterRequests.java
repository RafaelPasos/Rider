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
import com.prodevsmx.rider.beans.PendingRequestItem;

import java.util.List;

/**
 * Created by Pasos on 27/10/2017.
 */

public class AdapterRequests extends RecyclerView.Adapter<AdapterRequests.ViewHolder>{

    private List<PendingRequestItem> items;
    private Context context;

    public AdapterRequests(List<PendingRequestItem> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override public AdapterRequests.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_request, parent, false);
        return new AdapterRequests.ViewHolder(v);
    }

    @Override public void onBindViewHolder(AdapterRequests.ViewHolder holder, int position) {
        PendingRequestItem item = items.get(position);
        //Set data to UI Elements
        holder.userName.setText(item.getUserName());
        holder.userLocation.setText(item.getPickup());
        holder.userMode.setText(item.getMode());
        //not Now
        //Bitmap eventBitmap = ImageRounder.getRoundedBitmap(DrawableToBitmap.drawableToBitmap(item.getEventImage().getDrawable()));
        holder.userImage.setImageBitmap(item.getUserImage());
        holder.itemView.setTag(item);
    }

    @Override public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView userImage;
        public TextView userName;
        public TextView userLocation;
        public TextView userMode;

        public ViewHolder(View itemView) {
            super(itemView);
            userImage = (ImageView) itemView.findViewById(R.id.ivUserRequestImage);
            userName = (TextView) itemView.findViewById(R.id.tvUserRequestName);
            userLocation = (TextView) itemView.findViewById(R.id.tv_requestPickPoint);
            userMode = (TextView) itemView.findViewById(R.id.tv_requestUserMode);
        }
    }
}
