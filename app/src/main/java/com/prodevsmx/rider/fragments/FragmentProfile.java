package com.prodevsmx.rider.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;

import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;

import com.facebook.login.widget.ProfilePictureView;
import com.prodevsmx.rider.ActivityLogin;
import com.prodevsmx.rider.R;
import com.prodevsmx.rider.beans.SocialContact;

import org.json.JSONObject;

import java.util.ArrayList;


public class FragmentProfile extends android.support.v4.app.Fragment{

    View v;
    ProfilePictureView pic;
    Button logOut;
    RecyclerView recyclerViewSocial;
    ArrayList<SocialContact> arraySocial = new ArrayList<>();
    CallbackManager callbackManager;
    AccessTokenTracker accessTokenTracker;
    private JSONObject user;
    String FIELDS = "fields";
    private String REQUEST_FIELDS = TextUtils.join(",", new String[]{"name", "id", "picture"});
    TextView name;
    private TextView connectedStateLabel;


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
        FacebookSdk.sdkInitialize(view.getContext());
        callbackManager = CallbackManager.Factory.create();
        v = view;
        pic = (ProfilePictureView) v.findViewById(R.id.ppvProfile);
        connectedStateLabel = (TextView) v.findViewById(R.id.punUserName);
        logOut = v.findViewById(R.id.btnLogOut);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(v.getContext(), ActivityLogin.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                LoginManager.getInstance().logOut();
            }
        });
        accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken,
                                                       AccessToken currentAccessToken) {
                if (AccessToken.getCurrentAccessToken() == null){
                    Intent intent = new Intent(v.getContext(), ActivityLogin.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }else {
                    fetchUserInfo();
                    updateUI();
                }
            }
        };

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
    @Override
    public void onResume() {
        super.onResume();
        fetchUserInfo();
        updateUI();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        accessTokenTracker.stopTracking();
    }

    private void fetchUserInfo() {
        final AccessToken accessToken = AccessToken.getCurrentAccessToken();
        if (accessToken != null) {
            GraphRequest request = GraphRequest.newMeRequest(
                    accessToken, new GraphRequest.GraphJSONObjectCallback() {
                        @Override
                        public void onCompleted(JSONObject me, GraphResponse response) {
                            user = me;
                            updateUI();
                        }
                    });
            Bundle parameters = new Bundle();
            parameters.putString(FIELDS, REQUEST_FIELDS);
            request.setParameters(parameters);
            GraphRequest.executeBatchAsync(request);
        } else {
            user = null;
        }
    }

    @SuppressWarnings("deprecation")
    private void updateUI() {
        if (AccessToken.getCurrentAccessToken() != null) {
            if (user != null) {
                try {
                    pic.setProfileId(user.getString("id"));
                } catch (Exception e) {
                }
                connectedStateLabel.setText(user.optString("name"));
            }
        }
    }

}
