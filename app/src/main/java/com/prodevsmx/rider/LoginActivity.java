package com.prodevsmx.rider;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

public class LoginActivity extends AppCompatActivity {

    LoginButton fbLogIn;
    CallbackManager callbackManager;
    AccessToken token;
    SharedPreferences settings;
    SharedPreferences.Editor editor;
    String [] permissions = {"email", "user_about_me", "user_birthday", "user_events", "user_photos", "public_profile,"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);

        setContentView(R.layout.activity_login);

        initializeControls();
        fbLogin();

    }

    private void initializeControls(){

        fbLogIn = (LoginButton) findViewById(R.id.login_button);
        callbackManager = CallbackManager.Factory.create();

        settings = getSharedPreferences(getString(R.string.strSettings), Context.MODE_PRIVATE);
        editor = settings.edit();

        fbLogIn.setReadPermissions(permissions);
    }

    private void fbLogin(){
        fbLogIn.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                Log.d("TokenFacebook", loginResult.getAccessToken().toString());
                editor.putBoolean(getString(R.string.strOnLogin), true);
                editor.putString(getString(R.string.tokenApiGraph), loginResult.getAccessToken().toString());
                editor.commit();

                Intent goToActivity = new Intent(LoginActivity.this, ActivityLand.class);
                startActivity(goToActivity);
                LoginActivity.this.finish();

            }

            @Override
            public void onCancel() {
                Log.d("LoginMesssage", "error");
            }

            @Override
            public void onError(FacebookException error) {
                Log.d("LoginMesssage", error.getMessage().toString());
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

}
