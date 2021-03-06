package com.example.farming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
    TextView btnBack, applyCoupon;
    public static TextView totalPriceText;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_view);

        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);
        recyclerView = findViewById(R.id.recyclerView);
        totalPriceText = findViewById(R.id.totalPriceText);
        relativeLayout = findViewById(R.id.bottomPriceDetails);
        applyCoupon = findViewById(R.id.applyCoupon);


        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(cartView.this);
        String userId = preferences.getString("userId", "");
        apiInterface.getAllCartProduct(Integer.parseInt(userId)).enqueue(new Callback<ResponseArrayGetAllCartProduct>() {
            @Override
            public void onResponse(Call<ResponseArrayGetAllCartProduct> call, Response<ResponseArrayGetAllCartProduct> response) {
                if (response.body() != null && response.body().getResponse().size()> 0){
                    relativeLayout.setVisibility(View.VISIBLE);
                    List<GetAllCartProduct> productList = response.body().getResponse();
                    AddToCartAdapter adapter = new AddToCartAdapter(cartView.this,productList);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(cartView.this);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(adapter);
                    DividerItemDecoration itemDecoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
                    recyclerView.addItemDecoration(itemDecoration);
                } else{
                    relativeLayout.setVisibility(View.GONE);
                    Toast.makeText(cartView.this, "Your cart is empty", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseArrayGetAllCartProduct> call, Throwable t) {
                relativeLayout.setVisibility(View.GONE);
                Toast.makeText(cartView.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        apiInterface.getTotalCartPrice(Integer.parseInt(userId)).enqueue(new Callback<ResponseArrayTotalCartPrice>() {
            @Override
            public void onResponse(Call<ResponseArrayTotalCartPrice> call, Response<ResponseArrayTotalCartPrice> response) {
                if (response.body() != null && response.body().getResponse() != null){
                    totalPriceText.setText(response.body().getResponse().get(0).getTotal_sum());
                } else{
                }
            }

            @Override
            public void onFailure(Call<ResponseArrayTotalCartPrice> call, Throwable t) {
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

        applyCoupon.setOnClickListener(v -> {
            BottomSheetFragment bottomSheetFragment = new BottomSheetFragment();
            bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());
        });
    }
}