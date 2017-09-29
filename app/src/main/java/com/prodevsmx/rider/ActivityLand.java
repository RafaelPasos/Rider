package com.prodevsmx.rider;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;

import com.prodevsmx.rider.utils.BaseActivity;
import com.prodevsmx.rider.utils.BottomNavigationViewHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityLand extends BaseActivity {

    @BindView(R.id.etSearchBar)
    EditText searchBar;

    @BindView(R.id.tvEventsNearby)
    TextView tvEventsNearby;

    TextView tvNav;

    //@BindView(R.id.rider_toolbar)
    android.support.v7.widget.Toolbar riderToolbar;

    BottomNavigationView navigationBar;

    BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initializeUIElements();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_land;
    }


    public void initializeUIElements(){
        Typeface type = Typeface.createFromAsset(this.getAssets(),"fonts/myraidpro.ttf");
        tvEventsNearby.setTypeface(type);
        riderToolbar = findViewById(R.id.rider_toolbar);
        riderToolbar.setTitle("");
        setSupportActionBar(riderToolbar);
        tvNav = findViewById(R.id.tvTestNav);
        navigationBar = findViewById(R.id.bottomNav);
        addBottomNavigationListener();
        navigationBar.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationViewHelper.disableShiftMode(navigationBar);
        navigationBar.setSelectedItemId(R.id.navBExplore);
    }

    public void addBottomNavigationListener(){
        mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navBExplore:
                        Log.d("State", "Explore");
                        tvNav.setText("3");
                        //TODO: GO TO EXPLORER PAGE
                        return true;
                    case R.id.navBRequest:
                        //TODO: GO TO REQUESTS PAGE
                        tvNav.setText("1");
                        Log.d("State", "Requests");
                        return true;
                    case R.id.navBVehicles:
                        //TODO: GO TO VEHICLES PAGE
                        tvNav.setText("2");
                        Log.d("State", "Vehicles");
                        return true;
                    case R.id.navBPastRides:
                        //TODO: GO TO PAST RIDES PAGE
                        tvNav.setText("4");
                        Log.d("State", "Past ride");
                        return true;
                    case R.id.navBNextRides:
                        //TODO: GO TO NEXT RIDES PAGE
                        tvNav.setText("5");
                        Log.d("State", "Next rides");
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
            //TODO: GO TO PROFILE PAGE
            Log.d("crayola", "con la tia bartola");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
