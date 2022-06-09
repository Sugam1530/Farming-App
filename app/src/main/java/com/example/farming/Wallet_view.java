package com.example.farming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Wallet_view extends AppCompatActivity {
    ApiInterface apiInterface;
    ImageView btnBack, ivScanner;
    TextView transactionHistory,tvTotalMoney;
    public static TextView  scantext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet_view);

        btnBack= findViewById(R.id.textHello);
        transactionHistory = findViewById(R.id.transactionHistory);
        tvTotalMoney = findViewById(R.id.totalMoney);
        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);
        scantext = findViewById(R.id.scantext);
        ivScanner = findViewById(R.id.ivScaner);


        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(Wallet_view.this);
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

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
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
                intent.putExtra("calling_activity", "walletView") ;
            startActivity(intent);
        });
    }
}