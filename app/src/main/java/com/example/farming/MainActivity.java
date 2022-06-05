package com.example.farming;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

import Adapters.CategoryAdapter;
import Adapters.FeaturedProductAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    androidx.appcompat.widget.Toolbar drawerLayout2;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    ApiInterface apiInterface;
    RecyclerView recyclerView;

    ImageView addToCart,imageNotification, textNavigation;

    TextView viewProductAll,categoryViewAll;

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.profile:
                startActivity(new Intent(getApplicationContext(),farmer_profile.class));
                break;
            case R.id.wallet:
                startActivity(new Intent(getApplicationContext(), Wallet_view.class));
                break;
            case R.id.logout:
                startActivity(new Intent(getApplicationContext(), signin_password.class));
                break;

        }
        return true;
    }

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

        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);
        recyclerView = findViewById(R.id.recyclerView);

        apiInterface.getFeaturedProduct().enqueue(new Callback<ResponseArrayFeaturedProductOverview>() {
            @Override
            public void onResponse(Call<ResponseArrayFeaturedProductOverview> call, Response<ResponseArrayFeaturedProductOverview> response) {
                if (response.body() != null){
                    List<FeaturedProductOverview> productList = response.body().getResponse();
                    FeaturedProductAdapter adapter = new FeaturedProductAdapter(MainActivity.this, productList);
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 3);
                    recyclerView.setLayoutManager(gridLayoutManager);
                    recyclerView.setAdapter(adapter);
                } else{
                    Toast.makeText(MainActivity.this, "Not Success", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseArrayFeaturedProductOverview> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });


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

        NavigationView navigationView = findViewById(R.id.navigationview);

        navigationView.setNavigationItemSelectedListener(this);


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