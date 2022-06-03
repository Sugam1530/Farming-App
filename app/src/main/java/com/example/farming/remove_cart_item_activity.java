package com.example.farming;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class remove_cart_item_activity extends AppCompatActivity {

    TextView removeCartItem;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_addtocart_item);

        removeCartItem = findViewById(R.id.removeCartItem);
        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);

        removeCartItem.setOnClickListener(view -> {
            apiInterface.getRemoveSingleCartItem(Integer.parseInt(getIntent().getStringExtra(getString(R.string.productId)))).enqueue(new Callback<RemoveCartItem>() {
                @Override
                public void onResponse(Call<RemoveCartItem> call, Response<RemoveCartItem> response) {
                    Toast.makeText(remove_cart_item_activity.this, "Cart Item Deleted, Please Refresh", Toast.LENGTH_SHORT).show();

                }

                @Override
                public void onFailure(Call<RemoveCartItem> call, Throwable t) {
                    Toast.makeText(remove_cart_item_activity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        });
    }
}
