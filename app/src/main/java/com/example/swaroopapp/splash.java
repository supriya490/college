package com.example.swaroopapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import static android.view.View.SYSTEM_UI_FLAG_LOW_PROFILE;


public class splash extends AppCompatActivity {
    View mcontentView;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mcontentView = findViewById(R.id.logo);
        mcontentView.setSystemUiVisibility(SYSTEM_UI_FLAG_LOW_PROFILE
                /View.SYSTEM_UI_FLAG_FULLSCREEN
                /View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                /View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                /View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                /View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        handler =new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));

            }
        }, 2000);
    }}

