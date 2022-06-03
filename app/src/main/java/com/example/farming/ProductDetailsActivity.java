package com.example.farming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailsActivity extends AppCompatActivity {

    ApiInterface apiInterface;
    TextView tvProductName,tvProductDetails,tvmrpProductPrice, tvspProductPrice,btnBack, tvAddToCart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_product_details);

        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);
        tvProductName = findViewById(R.id.product_name);
        tvProductDetails = findViewById(R.id.product_details);
        tvmrpProductPrice = findViewById(R.id.tvmrpProductPrice);
        tvspProductPrice = findViewById(R.id.tvspProductPrice);
        btnBack = findViewById(R.id.btnBack);
        tvAddToCart = findViewById(R.id.tvAddToCart);



        apiInterface.getSingleProductDetails(Integer.parseInt(getIntent().getStringExtra(getString(R.string.productId)))).enqueue(new Callback<ResponseArraySingleProductOverview>() {
            @Override
            public void onResponse(Call<ResponseArraySingleProductOverview> call, Response<ResponseArraySingleProductOverview> response) {
                if (response.body() != null && response.body().getResponse() != null){
                    tvProductName.setText(response.body().getResponse().getSingleProductDetails_name());
                    tvProductDetails.setText(response.body().getResponse().getSingleProduct_details());
                    tvmrpProductPrice.setText(response.body().getResponse().getMrp());
                    tvspProductPrice.setText(response.body().getResponse().getSp());
                } else {
                    Toast.makeText(ProductDetailsActivity.this, "Not Success", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseArraySingleProductOverview> call, Throwable t) {
                Toast.makeText(ProductDetailsActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), product_screen.class);
            startActivity(intent);
        });

        tvAddToCart.setOnClickListener(view -> {
//            apiInterface.postAddToCart().enqueue(new Callback<AddToCartOverview>() {
//                @Override
//                public void onResponse(Call<AddToCartOverview> call, Response<AddToCartOverview> response) {
//
//
//                }
//
//                @Override
//                public void onFailure(Call<AddToCartOverview> call, Throwable t) {
//
//                }
//            });
            Intent intent = new Intent(getApplicationContext(), cartView.class);
            startActivity(intent);
        });
    }
}