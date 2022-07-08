package com.example.swaroopapp.shareit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.swaroopapp.BuildConfig;
import com.example.swaroopapp.R;

public class shareit extends AppCompatActivity {
    private Button share;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shareit);
        share = (Button)findViewById(R.id.button);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_SUBJECT,"Swaroop app");
                String shareMessage="https://play.google.com/store/apps/details?id="+ BuildConfig.APPLICATION_ID+"\n\n";
                shareIntent.putExtra(Intent.EXTRA_TEXT,shareMessage);
                shareIntent.setType("text/plain");
                startActivity(Intent.createChooser(shareIntent,"shareby"));
            }
        });
    }
}
