package com.example.farming;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class activity_services extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationMenu);

        bottomNavigationView.setSelectedItemId(R.id.menuServices);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuFavourite:
                        startActivity(new Intent(getApplicationContext(),
                                activity_favourite.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.menuHome:
                        startActivity(new Intent(getApplicationContext(),
                                activity_services.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.menuServices:
                        return true;
                }
                return false;
            }
        });
    }
}