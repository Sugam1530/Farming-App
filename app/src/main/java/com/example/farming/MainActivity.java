package com.example.farming;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    androidx.appcompat.widget.Toolbar drawerLayout2;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    ImageView addToCart,imageNotification, textNavigation;

    TextView viewProductAll,categoryViewAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewProductAll = findViewById(R.id.viewProductAll);
        addToCart = findViewById(R.id.addToCart);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationview);
        categoryViewAll = findViewById(R.id.categoryViewAll);
        drawerLayout2 = findViewById(R.id.drawer_layout2);

        toggle = new ActionBarDrawerToggle(this, drawerLayout ,drawerLayout2,R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


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

        categoryViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), category_screen.class);
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
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}