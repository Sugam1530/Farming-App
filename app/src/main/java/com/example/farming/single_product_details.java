package com.example.farming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import Adapters.ProductAdapter;
import Adapters.ProductDetailsAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class single_product_details extends AppCompatActivity {


    TextView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_product_details);
    }
}