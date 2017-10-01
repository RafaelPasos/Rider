package com.prodevsmx.rider.fragments;


import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.prodevsmx.rider.R;
import com.prodevsmx.rider.utils.DrawableToBitmap;
import com.prodevsmx.rider.utils.ImageRounder;


public class FragmentProfile extends android.support.v4.app.Fragment{

    ImageView round;

    public FragmentProfile() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        round = view.findViewById(R.id.ivUserProfilePicture);
        Drawable d = getResources().getDrawable(R.drawable.elonmusk, getActivity().getTheme());
        Bitmap b = DrawableToBitmap.drawableToBitmap(d);
        b = ImageRounder.getRoundedBitmap(b);
        round.setImageBitmap(b);

    }
}
