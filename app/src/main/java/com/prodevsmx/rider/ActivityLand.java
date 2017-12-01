package com.prodevsmx.rider;

import android.app.Fragment;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
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

import android.Manifest;
import android.widget.SearchView;

public class ActivityLand extends AppCompatActivity {


    android.support.v7.widget.Toolbar riderToolbar;
    BottomNavigationView navigationBar;
    BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;
    FragmentManager fragmentManager;
    int joker = 0;
    int[][] states;
    int[] colors;
    ColorStateList myList;
    static final int MY_PERMISSIONS_REQUEST_LOCATION = 6969;
    MenuItem itemSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_land);
        checkPermission();
    }

    public void checkPermission(){
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        if(permissionCheck == PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
        }else{
            initializeUIElements();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode){
            case MY_PERMISSIONS_REQUEST_LOCATION:{
                if(grantResults.length > 0){
                    Log.d("PERMISO:", ":)GRAX");
                }
                else{
                    Log.d("PERMISO:", ":(MAL");
                }
                checkPermission();
                return;
            }
        }
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
                        if(joker == 0){
                            joker ++;
                        }else{
                            itemSearch.setVisible(true);
                        }
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
                        itemSearch.setVisible(false);
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
                        itemSearch.setVisible(false);
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
                        itemSearch.setVisible(false);
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
                        itemSearch.setVisible(false);
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
        itemSearch = menu.findItem(R.id.searchBtn);

        //SearchView sv = (SearchView) itemSearch.getActionView();

        MenuItem s = riderToolbar.getMenu().findItem(R.id.searchBtn);
        android.support.v7.widget.SearchView r = (android.support.v7.widget.SearchView) s.getActionView();

        r.setOnQueryTextListener(new android.support.v7.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d("SEED","asddf");
                FragmentExplore f = (FragmentExplore) getSupportFragmentManager().findFragmentById(R.id.fragmentMain);
                f.setSearchStr(query);
                f.getEventsFromFB();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }
        });

        /*sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                return false;
            }
        });  */

        return true;

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.profileBtn) {
            changeBottomNavColor(false);
            itemSearch.setVisible(false);
            //TODO: GO TO PROFILE PAGE
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            android.support.v4.app.Fragment fragment = new FragmentProfile();
            //fragment.setEnterTransition(new Slide(Gravity.RIGHT));
            //fragment.setExitTransition(new Slide(Gravity.LEFT));
            fragment.setEnterTransition(new Fade(1));
            fragment.setExitTransition(new Fade(2));
            transaction.replace(R.id.fragmentMain, fragment, "lol");
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
