package com.prodevsmx.rider;

import android.app.Fragment;
import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.support.transition.TransitionInflater;
import android.support.transition.TransitionSet;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import com.prodevsmx.rider.fragments.FragmentExplore;
import com.prodevsmx.rider.fragments.FragmentNextRides;
import com.prodevsmx.rider.fragments.FragmentPastRides;
import com.prodevsmx.rider.fragments.FragmentProfile;
import com.prodevsmx.rider.fragments.FragmentRequests;
import com.prodevsmx.rider.fragments.FragmentVehicle;
import com.prodevsmx.rider.utils.BottomNavigationViewHelper;

import butterknife.ButterKnife;

import static android.R.color.holo_blue_light;

public class ActivityLand extends AppCompatActivity {


    android.support.v7.widget.Toolbar riderToolbar;
    BottomNavigationView navigationBar;
    BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;
    FragmentManager fragmentManager;
    int[][] states;
    int[] colors;
    ColorStateList myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_land);
        initializeUIElements();
    }

    public void initializeUIElements(){
        riderToolbar = findViewById(R.id.rider_toolbar);
        riderToolbar.setTitle("");
        setSupportActionBar(riderToolbar);
        navigationBar = findViewById(R.id.bottomNav);
        fragmentManager = getSupportFragmentManager();
        addBottomNavigationListener();
        navigationBar.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationViewHelper.disableShiftMode(navigationBar);
        navigationBar.setSelectedItemId(R.id.navBExplore);
        fragmentManager = getSupportFragmentManager();

    }

    public void addBottomNavigationListener(){
        mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navBExplore:
                        Log.d("Fragment", "Explore");
                        changeBottomNavColor(true);
                        //GO TO EXPLORER PAGE
                        FragmentTransaction transaction = fragmentManager.beginTransaction();
                        android.support.v4.app.Fragment fragment = new FragmentExplore();
                        //fragment.setEnterTransition(new Slide(Gravity.RIGHT));
                        //fragment.setExitTransition(new Slide(Gravity.LEFT));
                        fragment.setEnterTransition(new Fade(1));
                        fragment.setExitTransition(new Fade(2));
                        transaction.replace(R.id.fragmentMain, fragment);
                        transaction.commit();
                        return true;
                    case R.id.navBRequest:
                        changeBottomNavColor(true);
                        //TODO: GO TO REQUESTS PAGE
                        Log.d("Fragment", "Requests");
                        transaction = fragmentManager.beginTransaction();
                        fragment = new FragmentRequests();
                        //fragment.setEnterTransition(new Slide(Gravity.RIGHT));
                        //fragment.setExitTransition(new Slide(Gravity.LEFT));
                        fragment.setEnterTransition(new Fade(1));
                        fragment.setExitTransition(new Fade(2));
                        transaction.replace(R.id.fragmentMain, fragment);
                        transaction.commit();
                        return true;
                    case R.id.navBVehicles:
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
                        return true;
                    case R.id.navBPastRides:
                        changeBottomNavColor(true);
                        //TODO: GO TO PAST RIDES PAGE
                        Log.d("Fragment", "Past ride");
                        transaction = fragmentManager.beginTransaction();
                        fragment = new FragmentPastRides();
                        //fragment.setEnterTransition(new Slide(Gravity.RIGHT));
                        //fragment.setExitTransition(new Slide(Gravity.LEFT));
                        fragment.setEnterTransition(new Fade(1));
                        fragment.setExitTransition(new Fade(2));
                        transaction.replace(R.id.fragmentMain, fragment);
                        transaction.commit();
                        return true;
                    case R.id.navBNextRides:
                        changeBottomNavColor(true);
                        //TODO: GO TO NEXT RIDES PAGE
                        Log.d("Fragment", "Next rides");
                        transaction = fragmentManager.beginTransaction();
                        fragment = new FragmentNextRides();
                        //fragment.setEnterTransition(new Slide(Gravity.RIGHT));
                        //fragment.setExitTransition(new Slide(Gravity.LEFT));
                        fragment.setEnterTransition(new Fade(1));
                        fragment.setExitTransition(new Fade(2));
                        transaction.replace(R.id.fragmentMain, fragment);
                        transaction.commit();
                        return true;
                }
                return false;
            }
        };
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.profileBtn) {
            changeBottomNavColor(false);
            //TODO: GO TO PROFILE PAGE
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            android.support.v4.app.Fragment fragment = new FragmentProfile();
            //fragment.setEnterTransition(new Slide(Gravity.RIGHT));
            //fragment.setExitTransition(new Slide(Gravity.LEFT));
            fragment.setEnterTransition(new Fade(1));
            fragment.setExitTransition(new Fade(2));
            transaction.replace(R.id.fragmentMain, fragment);
            transaction.commit();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void changeBottomNavColor(boolean selector){
        if (!selector){
            states = new int[][] {
                    new int[] {android.R.attr.state_checked}, // unchecked
                    new int[] {-android.R.attr.state_checked}
            };

            colors = new int[] {
                    this.getResources().getColor(R.color.colorPrimary, getTheme()),
                    this.getResources().getColor(R.color.colorPrimary, getTheme())

            };
            myList = new ColorStateList(states, colors);
            navigationBar.setItemIconTintList(myList);
            navigationBar.setItemTextColor(myList);
        }else{
            states = new int[][] {
                    new int[] {-android.R.attr.state_checked}, // unchecked
                    new int[] {android.R.attr.state_checked}
            };

            colors = new int[] {
                    this.getResources().getColor(R.color.colorPrimary, getTheme()),
                    this.getResources().getColor(holo_blue_light, getTheme())
            };
            myList = new ColorStateList(states, colors);
            navigationBar.setItemIconTintList(myList);
            navigationBar.setItemTextColor(myList);
        }
    }

}
