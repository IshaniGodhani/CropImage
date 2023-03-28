package com.example.tabbedactivity;

import android.os.Bundle;

import com.example.tabbedactivity.ui.main.Pager_Adapter;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tabbedactivity.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    ViewPager viewPager;
    TabLayout tabLayout;
    AppBarLayout appBarLayout;
    Pager_Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);

//        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
//        ViewPager viewPager = binding.viewPager;
//        viewPager.setAdapter(sectionsPagerAdapter);
//        TabLayout tabs = binding.tabs;
//        tabs.setupWithViewPager(viewPager);

       // FloatingActionButton fab = binding.fab;

//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        viewPager=findViewById(R.id.view_pager);
        tabLayout=findViewById(R.id.tabs);

        adapter=new Pager_Adapter(this,getSupportFragmentManager());

        Fragment_One fragment_one = new Fragment_One();
        adapter.addFragment(fragment_one,"Tab-1");
        adapter.addFragment(new Fragment_Two(),"Tab-2");
        adapter.addFragment(new Fragment_Three(),"Tab-3");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}