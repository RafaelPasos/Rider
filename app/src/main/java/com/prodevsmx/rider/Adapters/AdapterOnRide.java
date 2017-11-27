package com.prodevsmx.rider.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.prodevsmx.rider.R;
import com.prodevsmx.rider.beans.PendingRequestItem;
import com.prodevsmx.rider.utils.RoundedCornersTransform;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by rpasos on 26/11/17.
 */

public class AdapterOnRide extends RecyclerView.Adapter<AdapterOnRide.ViewHolder>{

    List<PendingRequestItem> contacts;
    Context c;

    public AdapterOnRide(List<PendingRequestItem> items, Context context) {
        contacts = items;
        c = context;
    }

    @Override
    public AdapterOnRide.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_passenger_ride, parent, false);
        return new AdapterOnRide.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AdapterOnRide.ViewHolder holder, int position) {
        PendingRequestItem item = contacts.get(position);
        //holder.userImage.setImageBitmap(item.getUserImage());
        Picasso.with(c).load(item.getUserImage()).transform(new RoundedCornersTransform()).into(holder.userImage);
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
        Button userMode;

        public ViewHolder(View itemView) {
            super(itemView);
            userImage = (ImageView) itemView.findViewById(R.id.ivUserRequestImageRide);
            userName = (TextView) itemView.findViewById(R.id.tvUserRequestNameRide);
            userLocation = (TextView) itemView.findViewById(R.id.tv_requestPickPointRide);
            userMode = (Button) itemView.findViewById(R.id.btnPickUpRide);
            userMode.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    userMode.setText("PickedUp");
                    userMode.setEnabled(false);
                }
            });

        }
    }
}
