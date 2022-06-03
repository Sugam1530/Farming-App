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
import android.widget.Toast;

import java.util.List;

import Adapters.AddToCartAdapter;
import Adapters.ProductAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class cartView extends AppCompatActivity {


    ApiInterface apiInterface;
    RecyclerView recyclerView;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_view);

        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);
        recyclerView = findViewById(R.id.recyclerView);


        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(cartView.this);
        String userId = preferences.getString("userId", "");
        apiInterface.getAllCartProduct(Integer.parseInt(userId)).enqueue(new Callback<ResponseArrayGetAllCartProduct>() {
            @Override
            public void onResponse(Call<ResponseArrayGetAllCartProduct> call, Response<ResponseArrayGetAllCartProduct> response) {
                if (response.body() != null){
                    List<GetAllCartProduct> productList = response.body().getResponse();
                    AddToCartAdapter adapter = new AddToCartAdapter(cartView.this,productList);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(cartView.this);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(adapter);
                } else{
                    Toast.makeText(cartView.this, "Not Success", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseArrayGetAllCartProduct> call, Throwable t) {
                Toast.makeText(cartView.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
}