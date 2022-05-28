package com.example.farming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Carousel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import Adapters.Adapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class product_screen extends AppCompatActivity {

    ApiInterface apiInterface;
    RecyclerView recyclerView;

    TextView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_screen);

        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);
        recyclerView = findViewById(R.id.recyclerView);

        apiInterface.getproduct().enqueue(new Callback<ResponseArray>() {
            @Override
            public void onResponse(Call<ResponseArray> call, Response<ResponseArray> response) {
                if (response.body() != null){
                    Toast.makeText(product_screen.this, "Success", Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(product_screen.this, "Not Success", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ResponseArray> call, Throwable t) {
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