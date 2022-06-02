package com.example.farming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class single_product_details extends AppCompatActivity {


    TextView btnBack, tvAddToCart, tvBuyNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_product_details);

        btnBack = findViewById(R.id.btnBack);
        tvAddToCart = findViewById(R.id.tvAddToCart);
        tvBuyNow = findViewById(R.id.tvBuyNow);

        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), product_screen.class);
            startActivity(intent);
        });

        tvAddToCart.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), cartView.class);
            startActivity(intent);
        });
    }
}