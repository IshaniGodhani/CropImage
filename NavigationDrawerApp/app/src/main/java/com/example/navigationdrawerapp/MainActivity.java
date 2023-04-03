package com.example.navigationdrawerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    AppBarLayout appBarLayout;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toobar);
        appBarLayout = findViewById(R.id.appbar);
        navigationView = findViewById(R.id.nav_view);
        drawerLayout=findViewById(R.id.drawerLayout);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.Open_Drawer,R.string.Close_Drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.home)
                {
                    addFragment(new Fragment_Home());
                    drawerLayout.closeDrawer(Gravity.LEFT);
                }
                if(item.getItemId()==R.id.about)
                {
                    addFragment(new Fragment_Home());
                    drawerLayout.closeDrawer(Gravity.LEFT);
                }
                if(item.getItemId()==R.id.settings)
                {
                    addFragment(new Fragment_Home());
                    drawerLayout.closeDrawer(Gravity.LEFT);
                }

                return true;
            }
        });

    }
    private void addFragment(Fragment fragment)
    {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction transaction= fm.beginTransaction();
        transaction.add(R.id.frame, fragment);
        transaction.commit();
    }
}