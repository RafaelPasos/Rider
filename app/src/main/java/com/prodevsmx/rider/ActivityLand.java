package com.prodevsmx.rider;

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

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityLand extends BaseActivity {

    @BindView(R.id.etSearchBar)
    EditText searchBar;

    @BindView(R.id.tvEventsNearby)
    TextView tvEventsNearby;

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

        navigationBar = findViewById(R.id.bottomNav);
        addBottomNavigationListener();
        navigationBar.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigationBar.setSelectedItemId(R.id.navBExplore);
    }

    public void addBottomNavigationListener(){
        mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navBExplore:
                        Log.d("crayola", "hola crayola");
                        //TODO: GO TO EXPLORER PAGE
                        return true;
                    case R.id.navBRequest:
                        //TODO: GO TO REQUESTS PAGE
                        Log.d("crayola", "con la pistola");
                        return true;
                    case R.id.navBVehicles:
                        //TODO: GO TO VEHICLES PAGE
                        Log.d("crayola", "ruperta y manola");
                        return true;
                    case R.id.navBPastRides:
                        //TODO: GO TO PAST RIDES PAGE
                        Log.d("crayola", "le gusta la trola");
                        return true;
                    case R.id.navBNextRides:
                        //TODO: GO TO NEXT RIDES PAGE
                        Log.d("crayola", "si es en barcelona");
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
