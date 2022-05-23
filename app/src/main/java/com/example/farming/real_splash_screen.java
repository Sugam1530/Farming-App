package com.example.farming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class real_splash_screen extends AppCompatActivity {

    LauncherManager launcherManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_splash_screen);

        launcherManager = new LauncherManager(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (launcherManager.isFirstTime()){
                    startActivity(new Intent(getApplicationContext(), slider.class));

                } else {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }

            }
        }, 2000);
    }
}