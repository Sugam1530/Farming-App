package com.example.farming;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class activity_favourite extends AppCompatActivity {

    ApiInterface apiInterface;
    TextView transactionHistory,tvTotalMoney;
    ImageView btnBack, ivScanner;
    public static TextView  scantext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);


        transactionHistory = findViewById(R.id.transactionHistory);
        tvTotalMoney = findViewById(R.id.totalMoney);
        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);
        scantext = findViewById(R.id.scantext);
        ivScanner = findViewById(R.id.ivScaner);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationMenu);

        bottomNavigationView.setSelectedItemId(R.id.menuWallet);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuWallet:
                        return true;
                    case R.id.menuHome:
                        startActivity(new Intent(getApplicationContext(),
                                MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.menuProfile:
                        startActivity(new Intent(getApplicationContext(),
                                activity_services.class));
                        overridePendingTransition(0,0);
                }
                return false;
            }
        });

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity_favourite.this);
        String userId = preferences.getString("userId", "");
        apiInterface.getFarmerProfile(Integer.parseInt(userId)).enqueue(new Callback<ResponseArrayFarmerProfileOverview>() {
            @Override
            public void onResponse(Call<ResponseArrayFarmerProfileOverview> call, Response<ResponseArrayFarmerProfileOverview> response) {
                if (response.body() != null && response.body().getResponse() != null){
                    tvTotalMoney.setText(response.body().getResponse().getWallet_balance());
                }
            }

            @Override
            public void onFailure(Call<ResponseArrayFarmerProfileOverview> call, Throwable t) {

            }
        });

        transactionHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), transaction_history.class);
                startActivity(intent);
            }
        });

        ivScanner.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), scannerView.class);
            intent.putExtra("calling_activity", "activityFavourite") ;
            startActivity(intent);
        });
    }
}