package com.example.smarttravelguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {
//Initialize variable
    SupportMapFragment supportMapFragment;

    TabLayout tablayout;
    TabItem tabItem1, tabItem2, tabItem3;
    ViewPager viewPager;
    PageAdapter pageAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        

        


        tablayout=(TabLayout)findViewById(R.id.tabLayout);
        tabItem1=(TabItem)findViewById(R.id.tab1);
        tabItem2=(TabItem)findViewById(R.id.tab2);
        tabItem3=(TabItem)findViewById(R.id.tab3);
        viewPager=(ViewPager)findViewById(R.id.viewpager);


        pageAdapter=new PageAdapter(getSupportFragmentManager(),tablayout.getTabCount());
        viewPager.setAdapter(pageAdapter);


        tablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                if(tab.getPosition()==0 || tab.getPosition()==1 || tab.getPosition()==2)
                    pageAdapter.notifyDataSetChanged();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        //map = googleMap;
        LatLng Karachi = new LatLng(25.13950552834867, 66.79983530551566);
        googleMap.addMarker(new MarkerOptions().position(Karachi).title("Karachi"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(Karachi));
    }
}