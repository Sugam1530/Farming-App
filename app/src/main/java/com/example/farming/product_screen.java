package com.example.farming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import Adapters.ProductAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class product_screen extends AppCompatActivity {

    ApiInterface apiInterface;
    RecyclerView recyclerView;

    TextView btnBack,filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_screen);

        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);
        recyclerView = findViewById(R.id.recyclerView);
        filter = findViewById(R.id.filter);

        apiInterface.getproduct().enqueue(new Callback<ResponseArrayProductOverview>() {
            @Override
            public void onResponse(Call<ResponseArrayProductOverview> call, Response<ResponseArrayProductOverview> response) {
                if (response.body() != null){
                    List<ProductOverview> productList = response.body().getResponse();
                    ProductAdapter adapter = new ProductAdapter(product_screen.this,productList);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(product_screen.this);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(adapter);
                } else{
                    Toast.makeText(product_screen.this, "Not Success", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ResponseArrayProductOverview> call, Throwable t) {
                Toast.makeText(product_screen.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });


        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}