package com.example.farming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class farmer_profile extends AppCompatActivity {

    ApiInterface apiInterface;
    TextView tvName, tvUserName, tvEmail, tvWalletBalance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_profile);

        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);
        tvName = findViewById(R.id.tvname);
        tvUserName = findViewById(R.id.tvusername);
        tvEmail = findViewById(R.id.tvemail);
        tvWalletBalance = findViewById(R.id.tvwalletbalance);


        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(farmer_profile.this);
        String userId = preferences.getString("userId", "");
        apiInterface.getFarmerProfile(Integer.parseInt(userId)).enqueue(new Callback<ResponseArrayFarmerProfileOverview>() {
            @Override
            public void onResponse(Call<ResponseArrayFarmerProfileOverview> call, Response<ResponseArrayFarmerProfileOverview> response) {
                if (response.body() != null && response.body().getResponse() != null){
                    tvName.setText(response.body().getResponse().getName());
                    tvUserName.setText(response.body().getResponse().getUsername());
                    tvEmail.setText(response.body().getResponse().getEmail());
                    tvWalletBalance.setText(response.body().getResponse().getWallet_balance());
                    Toast.makeText(farmer_profile.this, "Success", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(farmer_profile.this, "Not Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseArrayFarmerProfileOverview> call, Throwable t) {
                Toast.makeText(farmer_profile.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}