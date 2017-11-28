package com.prodevsmx.rider.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.prodevsmx.rider.R;
import com.prodevsmx.rider.beans.BackEndModels.Persona;
import com.prodevsmx.rider.beans.CarItem;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Carlos on 28/11/2017.
 */

public class AdapterDriver extends RecyclerView.Adapter<AdapterDriver.ViewHolder> {
    private List<Persona> items;
    private Context context;

    public AdapterDriver(List<Persona> items, Context context) {
        this.items = items;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_driver, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AdapterDriver.ViewHolder holder, int position) {
        Persona p = items.get(position);
//        holder.driverImage.setImageBitmap();
        Picasso.with(context).load(p.getImagen()).into(holder.driverImage);
        holder.driverLocation.setText(p.getHome().getType());
        holder.driverName.setText(p.getName());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView driverImage;
        public TextView driverName;
        public TextView driverLocation;

        public ViewHolder(View itemView) {
            super(itemView);
            driverImage = (ImageView) itemView.findViewById(R.id.ivUserRequestImageRide);
            driverName = (TextView) itemView.findViewById(R.id.tv_RequestDriverName);
            driverLocation = (TextView) itemView.findViewById(R.id.tv_requestDriverPoint);
        }

    }
}