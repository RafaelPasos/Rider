package com.prodevsmx.rider;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.prodevsmx.rider.utils.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityLand extends BaseActivity {

    @BindView(R.id.etSearchBar)
    EditText searchBar;

    @BindView(R.id.tvEventsNearby)
    TextView tvEventsNearby;

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
    }


}
