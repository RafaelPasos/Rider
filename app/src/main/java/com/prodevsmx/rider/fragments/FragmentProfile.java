package com.prodevsmx.rider.fragments;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.facebook.CallbackManager;
import com.facebook.FacebookActivity;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.prodevsmx.rider.ActivityLand;
import com.prodevsmx.rider.LoginActivity;
import com.prodevsmx.rider.R;
import com.prodevsmx.rider.utils.DrawableToBitmap;
import com.prodevsmx.rider.utils.ImageRounder;

import static com.facebook.FacebookSdk.getApplicationContext;


public class FragmentProfile extends android.support.v4.app.Fragment{

    ImageView round;
    Button logOut;
    CallbackManager callbackManager;
    SharedPreferences settings;
    SharedPreferences.Editor editor;
    View v;

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

        //fbLogOut();

        /*logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putBoolean(getString(R.string.strOnLogin), false);
                editor.commit();
                Intent goTo = new Intent(getActivity(), LoginActivity.class);
                startActivity(goTo);
            }
        });*/

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginManager.getInstance().logOut();
                editor.putBoolean(getString(R.string.strOnLogin), false);
                editor.commit();
                Intent goTo = new Intent(getActivity(), LoginActivity.class);
                startActivity(goTo);
            }
        });

    }

    public void initializeControls(){

        logOut = v.findViewById(R.id.btnLogOut);
        round = v.findViewById(R.id.ivUserProfilePicture);
        settings = this.getActivity().getSharedPreferences(getString(R.string.strSettings), Context.MODE_PRIVATE);
        editor = settings.edit();
        callbackManager = CallbackManager.Factory.create();
    }

    /*public void fbLogOut(){
        logOut.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                editor.putBoolean(getString(R.string.strOnLogin), false);
                editor.commit();
                Intent goTo = new Intent(getActivity(), LoginActivity.class);
                startActivity(goTo);
            }

            @Override
            public void onCancel() {
                Log.d("LoginMessage", "error");
            }

            @Override
            public void onError(FacebookException error) {
                Log.d("LoginMessage", error.getMessage().toString());
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }*/

}
