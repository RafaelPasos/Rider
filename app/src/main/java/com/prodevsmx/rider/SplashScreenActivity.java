package com.prodevsmx.rider;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SplashScreenActivity extends AppCompatActivity {

    SharedPreferences sp;
    SharedPreferences.Editor editor;
    String rideStatus;
    Boolean onTravel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("aqui", "splash");
        sp = this.getSharedPreferences("com.prodevsmx.rider.prefs", Context.MODE_PRIVATE);

        if(sp.contains("com_prodevsmx_rider_trip_started")) {
            Log.d("aqui", "activityridedetail");
            if(sp.getString("com_prodevsmx_rider_trip_started", null).equals("true")){
                Intent goToActivity = new Intent(SplashScreenActivity.this, ActivityRideDetail.class);
                startActivity(goToActivity);
                finish();
            }
            else
            {
                Log.d("aqui", "login");
                Intent goToActivity = new Intent(SplashScreenActivity.this, ActivityLogin.class);
                startActivity(goToActivity);
                finish();
            }
        }
        else
        {
            Log.d("aqui", "login");
            Intent goToActivity = new Intent(SplashScreenActivity.this, ActivityLogin.class);
            startActivity(goToActivity);
            finish();
        }
    }
}
