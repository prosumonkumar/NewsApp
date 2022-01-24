package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem home, sports, health, science, entertainment, technology;
    PaggerAdapter paggerAdapter;
    Toolbar toolbar;
    String api = "4de74dfd4a9b4c15b0a7aa8350ec8c10";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tablayOutId);
        home = findViewById(R.id.homeId);
        sports = findViewById(R.id.sportsId);
        health = findViewById(R.id.helthId);
        science = findViewById(R.id.scienceId);
        entertainment = findViewById(R.id.entertainmentId);
        technology = findViewById(R.id.technologyId);

        toolbar = findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);

        ViewPager viewPager = findViewById(R.id.viewPagerId);

        paggerAdapter = new PaggerAdapter(getSupportFragmentManager(), 6);
        viewPager.setAdapter(paggerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition()==0 || tab.getPosition()==1 || tab.getPosition()==2 || tab.getPosition()==3 || tab.getPosition()==4 ||
                        tab.getPosition()==5){
                    paggerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}