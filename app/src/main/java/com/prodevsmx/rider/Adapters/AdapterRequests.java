package com.prodevsmx.rider.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.prodevsmx.rider.APIClients.ApiUtils;
import com.prodevsmx.rider.APIClients.RiderEndPoints;
import com.prodevsmx.rider.R;
import com.prodevsmx.rider.Settings.Identity;
import com.prodevsmx.rider.beans.BackEndModels.PickUpRequest;
import com.prodevsmx.rider.beans.PendingRequestItem;
import com.prodevsmx.rider.utils.RoundedCornersTransform;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Pasos on 27/10/2017.
 */

public class AdapterRequests extends RecyclerView.Adapter<AdapterRequests.ViewHolder>{

    private List<PendingRequestItem> items;
    private Context context;

    RiderEndPoints mRiderEndPoints;


    public AdapterRequests(List<PendingRequestItem> items, Context context) {
        this.items = items;
        this.context = context;
        mRiderEndPoints = ApiUtils.getRiderService();

    }

    @Override public AdapterRequests.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_request, parent, false);
        return new AdapterRequests.ViewHolder(v);
    }

    @Override public void onBindViewHolder(AdapterRequests.ViewHolder holder, final int position) {
        PendingRequestItem item = items.get(position);
        //Set data to UI Elements
        holder.userName.setText(item.getUserName());
        holder.userLocation.setText(item.getPickup());
        holder.userMode.setText(item.getMode());
        holder.requestId.setText(item.getRequest_id());
        //not Now
        //Bitmap eventBitmap = ImageRounder.getRoundedBitmap(DrawableToBitmap.drawableToBitmap(item.getEventImage().getDrawable()));
        //holder.userImage.setImageBitmap(item.getUserImage());
        Picasso.with(context).load(item.getUserImage()).transform(new RoundedCornersTransform()).into(holder.userImage);
        holder.itemView.setTag(item);
        holder.userImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tryToDeleteItem(position);
            }
        });
    }

    private void tryToDeleteItem(final int position) {
        String userName = Identity.getUserId();
        PendingRequestItem item = items.get(position);
        Log.d("BORRAR", "Se borrara" + item.getRequest_id());
        mRiderEndPoints.acceptRequest(userName, item.getRequest_id()).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.isSuccessful()) {
                    deleteItem(position);
                }else {
                    int statusCode  = response.code();
                    // handle request errors depending on status code
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });

    }

    private void deleteItem(int pos){
        items.remove(pos);
        notifyItemRemoved(pos);
    }

    @Override public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView userImage;
        public TextView userName;
        public TextView userLocation;
        public TextView userMode;
        public TextView requestId;

        public ViewHolder(View itemView) {
            super(itemView);
            userImage = (ImageView) itemView.findViewById(R.id.ivUserRequestImageRide);
            userName = (TextView) itemView.findViewById(R.id.tvUserRequestNameRide);
            userLocation = (TextView) itemView.findViewById(R.id.tv_requestPickPointRide);
            userMode = (TextView) itemView.findViewById(R.id.tv_requestUserMode);
            requestId = (TextView) itemView.findViewById(R.id.tv_request_id);
        }

    }
}
