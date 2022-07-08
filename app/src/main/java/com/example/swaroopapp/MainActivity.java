package com.example.swaroopapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;


import com.example.swaroopapp.ebook.ebookactivity;

import com.example.swaroopapp.rateus.Rateus;
import com.example.swaroopapp.scientificcalculator.scientificcalculator;
import com.example.swaroopapp.shareit.shareit;
import com.example.swaroopapp.theme.theme;
import com.example.swaroopapp.website.website;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView bottomNavigationView;
    private NavController navController;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationview;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitymainswaroop);
        bottomNavigationView=findViewById(R.id.bottomNavigationView);
        navController= Navigation.findNavController(this,R.id.framelayout);
        drawerLayout=findViewById(R.id.drawerLayout);
        bottomNavigationView=findViewById(R.id.bottomNavigationView);
        drawerLayout=findViewById(R.id.drawerLayout);
        navigationview=findViewById(R.id.navigation_view);
        toggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.start,R.string.close);

drawerLayout.addDrawerListener(toggle);
toggle.syncState();
Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        navigationview.setNavigationItemSelectedListener(this);



        NavigationUI.setupWithNavController(bottomNavigationView,navController);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)){
            return true;
        }
        return true;


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_developer:
             Toast.makeText(this,"Developer",Toast.LENGTH_SHORT).show();
             break;
             case R.id.navigation_video:
             Toast.makeText(this,"Video Lectures",Toast.LENGTH_SHORT).show();
             break;
             case R.id.navigation_rate:
                 startActivity(new Intent(this, Rateus.class));
             break;
             case R.id.navigation_ebook:
           startActivity(new Intent(this, ebookactivity.class));
             break;
             case R.id.navigation_theme:
                 startActivity(new Intent(this, theme.class));
             break;
             case R.id.navigation_share:
                 startActivity(new Intent(this, shareit.class));
             break;
             case R.id.navigation_website:
                 startActivity(new Intent(this, website.class));
             break; case R.id.navigation_scientificcalculator:
                 startActivity(new Intent(this, scientificcalculator.class));
             break;


        }
        return true;
    }
}
