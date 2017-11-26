package com.prodevsmx.rider.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.prodevsmx.rider.R;
import com.prodevsmx.rider.beans.PendingRequestItem;
import com.prodevsmx.rider.beans.SocialContact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carlos on 16/11/2017.
 */

public class AdapterPassengers extends RecyclerView.Adapter<AdapterPassengers.ViewHolder>{

    List<PendingRequestItem> contacts;
    Context c;

    public AdapterPassengers(List<PendingRequestItem> items, Context context) {
        contacts = items;
        c = context;
    }

    @Override
    public AdapterPassengers.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_request, parent, false);
        return new AdapterPassengers.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AdapterPassengers.ViewHolder holder, int position) {
        PendingRequestItem item = contacts.get(position);
        holder.userImage.setImageBitmap(item.getUserImage());
        holder.userLocation.setText(item.getPickup());
        holder.userMode.setText(item.getMode());
        holder.userName.setText(item.getUserName());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView userImage;
        TextView userName;
        TextView userLocation;
        TextView userMode;

        public ViewHolder(View itemView) {
            super(itemView);
            userImage = (ImageView) itemView.findViewById(R.id.ivUserRequestImage);
            userName = (TextView) itemView.findViewById(R.id.tvUserRequestName);
            userLocation = (TextView) itemView.findViewById(R.id.tv_requestPickPoint);
            userMode = (TextView) itemView.findViewById(R.id.tv_requestUserMode);
        }
    }
}
