package com.prodevsmx.rider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.prodevsmx.rider.Adapters.AdapterDriver;
import com.prodevsmx.rider.beans.BackEndModels.GeoPoint;
import com.prodevsmx.rider.beans.BackEndModels.Persona;

import java.util.ArrayList;
import java.util.List;

public class ActivityChooseDriver extends AppCompatActivity {
    ArrayList<Persona> p = new ArrayList<Persona>();
    RecyclerView recyclerViewDrivers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_driver);
        recyclerViewDrivers = findViewById(R.id.recycler_view_drivers);

        Persona per = new Persona();
        per.setName("aliki");
        GeoPoint pt = new GeoPoint("", null);
        pt.type = "home";
        per.setHome(pt);
        per.setImagen("https://scontent.fgdl3-1.fna.fbcdn.net/v/t1.0-9/14199307_1406476386036245_6742877168913168843_n.jpg?oh=76ffb77445ae9b755b4c23aefda09b10&oe=5A8CC7BA");
        p.add(per);

        Persona per2 = new Persona();
        per2.setName("dami");
        GeoPoint pt2 = new GeoPoint("", null);
        pt.type = "casa";
        per2.setHome(pt2);
        per2.setImagen("https://scontent.fgdl3-1.fna.fbcdn.net/v/t1.0-9/22780294_1610523835635344_2948924642890879755_n.jpg?oh=b8bc64b2e91f4304fbb03c5a1b09ae1d&oe=5A8ABEA4");
        p.add(per2);

        AdapterDriver ad = new AdapterDriver(p, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewDrivers.setLayoutManager(layoutManager);
        recyclerViewDrivers.setAdapter(ad);

    }
}
