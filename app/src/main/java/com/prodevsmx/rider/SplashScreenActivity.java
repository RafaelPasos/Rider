package com.prodevsmx.rider;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent goToActivity = new Intent(SplashScreenActivity.this, ActivityLogin.class);
        startActivity(goToActivity);
        finish();
    }
}
