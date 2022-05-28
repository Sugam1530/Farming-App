package com.example.farming;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    ImageView addToCart,imageNotification;

    TextView viewProductAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewProductAll = findViewById(R.id.viewProductAll);
        addToCart = findViewById(R.id.addToCart);
        imageNotification = findViewById(R.id.imageNotification);

        viewProductAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),product_screen.class);
                startActivity(intent);
            }
        });

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), cartView.class);
                startActivity(intent);
            }
        });

        imageNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Wallet_view.class);
                startActivity(intent);
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationMenu);

        bottomNavigationView.setSelectedItemId(R.id.menuHome);

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
                        return true;
                    case R.id.menuServices:
                        startActivity(new Intent(getApplicationContext(),
                                activity_services.class));
                        overridePendingTransition(0,0);
                }
                return false;
            }
        });
    }
}