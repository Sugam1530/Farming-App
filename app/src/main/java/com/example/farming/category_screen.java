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

import Adapters.CategoryAdapter;
import Adapters.ProductAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class category_screen extends AppCompatActivity {

    ApiInterface apiInterface;
    RecyclerView recyclerView;

    TextView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_screen);

        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);
        recyclerView = findViewById(R.id.recyclerView);

        apiInterface.getcategory().enqueue(new Callback<ResponseArrayCategoryOverview>() {
            @Override
            public void onResponse(Call<ResponseArrayCategoryOverview> call, Response<ResponseArrayCategoryOverview> response) {
                if (response.body() != null){
                    List<CategoryOverview> categoryList = response.body().getResponse();
                    CategoryAdapter adapter = new CategoryAdapter(category_screen.this,categoryList);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(category_screen.this);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(adapter);

                    Toast.makeText(category_screen.this, "Success", Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(category_screen.this, "Not Success", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseArrayCategoryOverview> call, Throwable t) {
                Toast.makeText(category_screen.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

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