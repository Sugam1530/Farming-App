package com.example.farming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import Adapters.ProductAdapter;
import Adapters.ProductbyCategoryAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Product_by_category extends AppCompatActivity {

    ApiInterface apiInterface;
    RecyclerView recyclerView;

    TextView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_by_category);

        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);
        recyclerView = findViewById(R.id.recyclerView);
        btnBack = findViewById(R.id.btnBack);

        apiInterface.getProductbyCategory(Integer.parseInt(getIntent().getStringExtra(getString(R.string.cat_id)))).enqueue(new Callback<ResponseArrayProductbyCat>() {
            @Override
            public void onResponse(Call<ResponseArrayProductbyCat> call, Response<ResponseArrayProductbyCat> response) {
                if (response.body() != null){
                    List<ProductbyCategoryOverview> productList = response.body().getResponse();
                    ProductbyCategoryAdapter adapter = new ProductbyCategoryAdapter(Product_by_category.this,productList);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Product_by_category.this);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(adapter);
                }

            }

            @Override
            public void onFailure(Call<ResponseArrayProductbyCat> call, Throwable t) {

            }
        });

        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), category_screen.class);
            startActivity(intent);
        });
    }
}