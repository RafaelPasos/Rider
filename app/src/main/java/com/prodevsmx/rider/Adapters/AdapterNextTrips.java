package com.prodevsmx.rider.Adapters;

import android.content.Context;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.transition.Fade;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.prodevsmx.rider.R;
import com.prodevsmx.rider.beans.EventNearbyItem;
import com.prodevsmx.rider.fragments.FragmentNextRideDetails;

import java.util.List;

/**
 * Created by Damian Garcia on 10/26/2017.
 */

public class AdapterNextTrips  extends RecyclerView.Adapter<AdapterNextTrips.ViewHolder> {

    private List<EventNearbyItem> items;
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
        holder.eventImage.setImageBitmap(item.getEventImage());
        holder.itemView.setTag(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView eventImage;
        public TextView eventName;
        public TextView eventPlace;
        public TextView eventDate;


        public ViewHolder(View itemView, final Context context) {
            super(itemView);
            eventImage = (ImageView) itemView.findViewById(R.id.ivEventImage);
            eventName = (TextView) itemView.findViewById(R.id.tvEventTitle);
            eventPlace = (TextView) itemView.findViewById(R.id.tv_EventDetail);
            eventDate = (TextView) itemView.findViewById(R.id.tv_EventDate);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "click",Toast.LENGTH_SHORT).show();
                    Fragment fragment = new FragmentNextRideDetails();

                    FragmentManager fragmentManager;

                    fragmentManager = ((AppCompatActivity)context).getSupportFragmentManager();
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction= fragmentManager.beginTransaction();
                    fragment.setEnterTransition(new Fade(1));
                    fragment.setExitTransition(new Fade(2));
                    transaction.replace(R.id.fragmentMain, fragment);
                    transaction.commit();
                }
            });
        }
    }

    /*

     changeBottomNavColor(true);
                        //TODO: GO TO VEHICLES PAGE
                        Log.d("Fragment", "Vehicles");
                        transaction = fragmentManager.beginTransaction();
                        fragment = new FragmentVehicle();
                        //fragment.setEnterTransition(new Slide(Gravity.RIGHT));
                        //fragment.setExitTransition(new Slide(Gravity.LEFT));
                        fragment.setEnterTransition(new Fade(1));
                        fragment.setExitTransition(new Fade(2));
                        transaction.replace(R.id.fragmentMain, fragment);
                        transaction.commit();
    * */
}
