package com.example.farming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;

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
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(real_splash_screen.this);
                if(sharedPreferences.getBoolean("userLoggedInFlag", false))
                {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }
                else if (launcherManager.isFirstTime()){
                    startActivity(new Intent(getApplicationContext(), slider.class));

                } else {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }

            }
        }, 2000);
    }
}