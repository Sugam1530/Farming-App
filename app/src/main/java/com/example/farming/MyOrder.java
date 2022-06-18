package com.example.farming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import Adapters.MyOrderAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyOrder extends AppCompatActivity {

    TextView btnBack;
    ApiInterface apiInterface;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        btnBack = findViewById(R.id.btnBack);
        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);
        recyclerView = findViewById(R.id.recyclerViewMyOrder);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(MyOrder.this);
        String userId = preferences.getString("userId", "");
        apiInterface.getMyOrder(Integer.parseInt(userId)).enqueue(new Callback<ResponseArrayMyOrderOverview>() {
            @Override
            public void onResponse(Call<ResponseArrayMyOrderOverview> call, Response<ResponseArrayMyOrderOverview> response) {
                if (response.body() != null){
                    List<MyOrderOverview> myorderList = response.body().getResponse();
                    MyOrderAdapter adapter = new MyOrderAdapter(MyOrder.this, myorderList);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MyOrder.this);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseArrayMyOrderOverview> call, Throwable t) {
                Toast.makeText(MyOrder.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });
    }
}