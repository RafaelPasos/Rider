package com.prodevsmx.rider;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class LoginActivity extends AppCompatActivity {

    LoginButton fbLogin;
    CallbackManager callbackManager;
    AccessToken token;
    String [] permissions = {"email", "user_about_me", "user_birthday", "user_events", "user_photos", "public_profile,"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);

        initializeControls();
        fbLogin();

    }

    private void initializeControls(){

        callbackManager = CallbackManager.Factory.create();
        fbLogin = (LoginButton) findViewById(R.id.login_button);

        fbLogin.setReadPermissions(permissions);
    }

    private void fbLogin(){
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d("loginToken", loginResult.getAccessToken().getToken());
                token = loginResult.getAccessToken();
                //TODO: Go to main activity
            }

            @Override
            public void onCancel() {
                Log.d("loginToken", "cancel");
            }

            @Override
            public void onError(FacebookException error) {
                Log.d("loginToken", error.getMessage());
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
