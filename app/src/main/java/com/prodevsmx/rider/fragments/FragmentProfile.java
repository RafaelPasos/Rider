package com.prodevsmx.rider.fragments;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.facebook.CallbackManager;

import com.facebook.login.LoginManager;

import com.prodevsmx.rider.Adapters.AdapterSocialContact;
import com.prodevsmx.rider.LoginActivity;
import com.prodevsmx.rider.R;
import com.prodevsmx.rider.beans.SocialContact;
import com.prodevsmx.rider.utils.DrawableToBitmap;
import com.prodevsmx.rider.utils.ImageRounder;

import java.util.ArrayList;


public class FragmentProfile extends android.support.v4.app.Fragment{

    ImageView round;
    Button logOut;
    CallbackManager callbackManager;
    SharedPreferences settings;
    SharedPreferences.Editor editor;
    RecyclerView recyclerViewSocial;
    View v;
    ArrayList<SocialContact> arraySocial = new ArrayList<>();

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

        v = view;

        initializeControls();

        Drawable d = getResources().getDrawable(R.drawable.elonmusk, getActivity().getTheme());
        Bitmap b = DrawableToBitmap.drawableToBitmap(d);
        b = ImageRounder.getRoundedBitmap(b);
        round.setImageBitmap(b);
        initializeViews();
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginManager.getInstance().logOut();
                editor.putBoolean(getString(R.string.strOnLogin), false);
                editor.commit();
                Intent goTo = new Intent(getActivity(), LoginActivity.class);
                goTo.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(goTo);
            }
        });

        AdapterSocialContact adapterSocialContact = new AdapterSocialContact(arraySocial, getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerViewSocial.setLayoutManager(layoutManager);
        recyclerViewSocial.setAdapter(adapterSocialContact);
    }

    public void initializeControls(){
        logOut = v.findViewById(R.id.btnLogOut);
        round = v.findViewById(R.id.ivUserProfilePicture);
        recyclerViewSocial = v.findViewById(R.id.rvSocialContact);
        settings = this.getActivity().getSharedPreferences(getString(R.string.strSettings), Context.MODE_PRIVATE);
        editor = settings.edit();
        callbackManager = CallbackManager.Factory.create();
    }

    public void initializeViews(){
        Drawable drawable = getResources().getDrawable(R.drawable.fb_logo, getActivity().getTheme());
        SocialContact item = new SocialContact(drawable, "Facebook", "steve.ruvalcaba.56");
        arraySocial.add(item);

        drawable = getResources().getDrawable(R.drawable.phone_logo, getActivity().getTheme());
        item = new SocialContact(drawable, "Cellphone", "485688132");
        arraySocial.add(item);

        drawable = getResources().getDrawable(R.drawable.mail_logo, getActivity().getTheme());
        item = new SocialContact(drawable, "Email", "stevejobsaoqui@gmail.com");
        arraySocial.add(item);
    }

}
