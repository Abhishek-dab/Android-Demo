package com.example.navigationmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    FragmentManager  manager;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);


        getSupportActionBar();
        navigationView.bringToFront();
        //context-->drawerLayout-->toolbar-->startmenu-->stopmenu
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,0,0);

        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        drawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(android.R.color.white));

        navigationView.setNavigationItemSelectedListener(this);

//new 5 steps
        if(savedInstanceState == null) {
            manager = getSupportFragmentManager();
            transaction = manager.beginTransaction();
            Home home = new Home();
            transaction.replace(R.id.main_body, home);
            transaction.commit();
        }
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        switch (item.getItemId()){
            case R.id.home:
                Home home = new Home();
                transaction.replace(R.id.main_body, home);
                transaction.commit();

                break;
            case R.id.notification:
                Notification notification = new Notification();
                transaction.replace(R.id.main_body,notification);
                transaction.commit();

                break;
            case R.id.design:
                Design design = new Design();
                transaction.replace(R.id.main_body,design);
                transaction.commit();

                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}


