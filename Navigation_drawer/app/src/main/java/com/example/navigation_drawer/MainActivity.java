package com.example.navigation_drawer;

import androidx.annotation.NonNull;
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
    AppBarLayout appBarLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appBarLayout = findViewById(R.id.appbar);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawrlayout);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.home) {
                    addFragment(new fragment_home());
                    drawerLayout.closeDrawer(Gravity.LEFT);
                }
                if (item.getItemId() == R.id.sent) {
                    addFragment(new fragment_sent());
                    drawerLayout.closeDrawer(Gravity.LEFT);
                }
                if (item.getItemId() == R.id.trash) {
                    addFragment(new fragment_trash());
                    drawerLayout.closeDrawer(Gravity.LEFT);
                }
                if (item.getItemId() == R.id.setting) {
                    addFragment(new fragment_setting());
                    drawerLayout.closeDrawer(Gravity.LEFT);
                }
                if (item.getItemId() == R.id.about) {
                    addFragment(new fragment_about());
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