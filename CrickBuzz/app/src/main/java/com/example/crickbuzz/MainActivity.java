package com.example.crickbuzz;

import android.os.Bundle;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.crickbuzz.ui.main.SectionsPagerAdapter;
import com.example.crickbuzz.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

   ViewPager viewPager;
   AppBarLayout appBarLayout;
   TabLayout tabLayout;
   Pager_Adapter pager_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        viewPager=findViewById(R.id.view_pager);
        tabLayout=findViewById(R.id.tabs);
        pager_adapter=new Pager_Adapter(this,getSupportFragmentManager());




    }
}