package com.example.farming;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.Result;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import me.dm7.barcodescanner.zxing.ZXingScannerView;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class scannerView extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    ZXingScannerView scannerView;
    ApiInterface apiInterface ;
    String farmerId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scannerView = new ZXingScannerView(this);
        setContentView(scannerView);
        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);
        Dexter.withContext(getApplicationContext())
                .withPermission(Manifest.permission.CAMERA)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        scannerView.startCamera();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();
                    }
                }).check();
    }

    @Override
    public void handleResult(Result result) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(scannerView.this);
        String userId = preferences.getString("userId", "");
        if(getIntent().getStringExtra("calling_activity").equals("walletView")) {
            Wallet_view.scantext.setText(result.getText());
            onBackPressed();
            Wallet_view.scantext.setVisibility(View.VISIBLE);
            String[] walletTopUp = result.getText().split("//");
            apiInterface.getWalletScan(Integer.parseInt(walletTopUp[1]),Integer.parseInt(userId)).enqueue(new Callback<WalletScanOverview>() {
                @Override
                public void onResponse(Call<WalletScanOverview> call, Response<WalletScanOverview> response) {
                    startActivity(new Intent(scannerView.this, Wallet_view.class ));
                }

                @Override
                public void onFailure(Call<WalletScanOverview> call, Throwable t) {

                }
            });
        }
        else if(getIntent().getStringExtra("calling_activity").equals("activityFavourite"))
        {
            activity_favourite.scantext.setText(result.getText());
            onBackPressed();
            activity_favourite.scantext.setVisibility(View.VISIBLE);
            String[] walletTopUp = result.getText().split("//");
            apiInterface.getWalletScan(Integer.parseInt(walletTopUp[1]),Integer.parseInt(userId)).enqueue(new Callback<WalletScanOverview>() {
                @Override
                public void onResponse(Call<WalletScanOverview> call, Response<WalletScanOverview> response) {
                    startActivity(new Intent(scannerView.this, activity_favourite.class ));
                }

                @Override
                public void onFailure(Call<WalletScanOverview> call, Throwable t) {

                }
            });
        }
        else
            Toast.makeText(this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
        if (result.getText() != null) {

        } else {
            if(getIntent().getStringExtra("calling_activity").equals("walletView"))
                Wallet_view.scantext.setVisibility(View.GONE);
            else if(getIntent().getStringExtra("calling_activity").equals("activityFavourite"))
                activity_favourite.scantext.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        scannerView.stopCamera();
    }

    @Override
    protected void onResume() {
        super.onResume();
        scannerView.setResultHandler(this);
        scannerView.startCamera();
    }
}