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
        setContentView(R.layout.activity_splash_screen);

        Intent goToActivity = new Intent(SplashScreenActivity.this, ActivityLand.class);
        startActivity(goToActivity);
        SplashScreenActivity.this.finish();


        //checkSession();
    }

    private void checkSession(){

        SharedPreferences settings = getSharedPreferences(getString(R.string.strSettings), Context.MODE_PRIVATE);

        boolean bLogin = settings.getBoolean(getString(R.string.strOnLogin), false);

        if(bLogin){
            //TODO: Go to  main activity
        }else{
            Intent goToLogin = new Intent(SplashScreenActivity.this, LoginActivity.class);
            startActivity(goToLogin);
            SplashScreenActivity.this.finish();
        }
    }

}
