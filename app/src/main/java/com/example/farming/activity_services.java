package com.example.farming;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class activity_services extends AppCompatActivity {

    ApiInterface apiInterface;
    TextView tvName, tvUserName, tvEmail, tvWalletBalance, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationMenu);

        bottomNavigationView.setSelectedItemId(R.id.menuProfile);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuWallet:
                        startActivity(new Intent(getApplicationContext(),
                                activity_favourite.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.menuHome:
                        startActivity(new Intent(getApplicationContext(),
                                MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.menuProfile:
                        return true;
                }
                return false;
            }
        });

        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);
        tvName = findViewById(R.id.tvname);
        tvUserName = findViewById(R.id.tvusername);
        tvEmail = findViewById(R.id.tvemail);
        tvWalletBalance = findViewById(R.id.tvwalletbalance);
        btnBack = findViewById(R.id.btnBack);


        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity_services.this);
        String userId = preferences.getString("userId", "");
        apiInterface.getFarmerProfile(Integer.parseInt(userId)).enqueue(new Callback<ResponseArrayFarmerProfileOverview>() {
            @Override
            public void onResponse(Call<ResponseArrayFarmerProfileOverview> call, Response<ResponseArrayFarmerProfileOverview> response) {
                if (response.body() != null && response.body().getResponse() != null){
                    tvName.setText(response.body().getResponse().getName());
                    tvUserName.setText(response.body().getResponse().getUsername());
                    tvEmail.setText(response.body().getResponse().getEmail());
                    tvWalletBalance.setText(response.body().getResponse().getWallet_balance());
                }
            }

            @Override
            public void onFailure(Call<ResponseArrayFarmerProfileOverview> call, Throwable t) {
                Toast.makeText(activity_services.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}