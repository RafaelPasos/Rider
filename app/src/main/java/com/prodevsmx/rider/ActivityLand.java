package com.prodevsmx.rider;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    @BindView(R.id.rider_toolbar)
    android.support.v7.widget.Toolbar riderToolbar;

    @BindView(R.id.bottomNav)
    BottomNavigationView navigationBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        navigationBar.getMenu().findItem(R.id.navBExplore).setChecked(true);
        initializeUIElements();

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_land;
    }


    public void initializeUIElements(){
        Typeface type = Typeface.createFromAsset(this.getAssets(),"fonts/myraidpro.ttf");
        tvEventsNearby.setTypeface(type);
        setSupportActionBar(riderToolbar);
        navigationBar.getMenu().findItem(R.id.navBExplore).setChecked(true);
        navigationBar.setOnNavigationItemSelectedListener(
             new BottomNavigationView.OnNavigationItemSelectedListener() {
                 @Override
                 public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                     switch (item.getItemId()) {
                         case R.id.navBExplore:
                             //TODO: GO TO EXPLORER PAGE
                             break;
                         case R.id.navBRequest:
                             //TODO: GO TO REQUESTS PAGE
                             break;
                         case R.id.navBVehicles:
                             //TODO: GO TO VEHICLES PAGE
                             break;
                         case R.id.navBPastRides:
                             //TODO: GO TO PAST RIDES PAGE
                             break;
                         case R.id.navBNextRides:
                             //TODO: GO TO NEXT RIDES PAGE
                             break;
                        }
                     return true;
                 }
             }
        );
    }

    /*
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
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    */

}
