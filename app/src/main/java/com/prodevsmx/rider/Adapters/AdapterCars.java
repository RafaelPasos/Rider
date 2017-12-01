package com.prodevsmx.rider.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.prodevsmx.rider.R;
import com.prodevsmx.rider.beans.CarItem;
import com.prodevsmx.rider.utils.DrawableToBitmap;
import com.prodevsmx.rider.utils.ImageRounder;
import com.prodevsmx.rider.utils.RoundedCornersTransform;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.util.List;

/**
 * Created by Pasos on 24/10/2017.
 */

public class AdapterCars extends RecyclerView.Adapter<AdapterCars.ViewHolder>{

    private List<CarItem> items;
    private Context context;

    public AdapterCars(List<CarItem> items, Context context) {
            this.items = items;
            this.context = context;
            }

    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_car, parent, false);
            return new ViewHolder(v);
            }

    @Override public void onBindViewHolder(ViewHolder holder, int position) {
            CarItem item = items.get(position);
            //Set data to UI Elements
            holder.carName.setText(item.getCarTitle());
            holder.carPlates.setText(item.getCarPlates());
            //not Now
            //Bitmap eventBitmap = ImageRounder.getRoundedBitmap(item.getCarImage());
           //Picasso.with(context).load(getImageUri(context, item.getCarImage())).transform(new RoundedCornersTransform()).into(holder.carImage);
            holder.carImage.setImageBitmap(ImageRounder.getRoundedBitmap(item.getCarImage()));
            holder.itemView.setTag(item);
            }



    @Override public int getItemCount() {
            return items.size();
            }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView carImage;
        public TextView carName;
        public TextView carPlates;

        public ViewHolder(View itemView) {
            super(itemView);
            carImage = (ImageView) itemView.findViewById(R.id.ivCarImage);
            carName = (TextView) itemView.findViewById(R.id.tvCarTitle);
            carPlates = (TextView) itemView.findViewById(R.id.tv_CarPlates);
        }
    }
}