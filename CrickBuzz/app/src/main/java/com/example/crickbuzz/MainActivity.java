package com.example.crickbuzz;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

   ViewPager viewPager;
   AppBarLayout appBarLayout;
   TabLayout tabLayout;
   public static Pager_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        viewPager=findViewById(R.id.view_pager);
        tabLayout=findViewById(R.id.tabs);
        adapter=new Pager_Adapter(this,getSupportFragmentManager(),viewPager);

        adapter.addFragment(new fragment_one(viewPager),"Info");
        adapter.addFragment(new fragment_two(),"Live");
        adapter.addFragment(new fragment_three(),"scoreCards");
        adapter.addFragment(new fragment_four(),"Squads");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);




    }
}