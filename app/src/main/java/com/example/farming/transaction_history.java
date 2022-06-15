package com.example.farming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import Adapters.AddToCartAdapter;
import Adapters.TransactionHistoryAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class transaction_history extends AppCompatActivity {

    TextView btnBack;
    ApiInterface apiInterface;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_history);

        btnBack = findViewById(R.id.btnBack);
        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);
        recyclerView = findViewById(R.id.recyclerView);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(transaction_history.this);
        String userId = preferences.getString("userId", "");
        apiInterface.getTransactionHistory(Integer.parseInt(userId)).enqueue(new Callback<ResponseArrayTransactionHistory>() {
            @Override
            public void onResponse(Call<ResponseArrayTransactionHistory> call, Response<ResponseArrayTransactionHistory> response) {
                if (response.body() != null){
                    List<TransactionHistoryOverview> transactionList = response.body().getResponse();
                    TransactionHistoryAdapter adapter = new TransactionHistoryAdapter(transaction_history.this, transactionList);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(transaction_history.this);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<ResponseArrayTransactionHistory> call, Throwable t) {

            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Wallet_view.class);
                startActivity(intent);
            }
        });


    }
}