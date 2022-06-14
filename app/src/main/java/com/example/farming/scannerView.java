package com.example.farming;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
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
        final RequestBody amountRequestBody = RequestBody.create(MediaType.parse("text/plain"), String.valueOf(27));
        final RequestBody farmerIdRequestBody = RequestBody.create(MediaType.parse("text/plain"), String.valueOf(1));
        if(getIntent().getStringExtra("calling_activity").equals("walletView")) {
            Wallet_view.scantext.setText(result.getText());
            onBackPressed();
            Wallet_view.scantext.setVisibility(View.VISIBLE);
            apiInterface.getWalletScan(amountRequestBody,farmerIdRequestBody).enqueue(new Callback<WalletScanOverview>() {
                @Override
                public void onResponse(Call<WalletScanOverview> call, Response<WalletScanOverview> response) {
                    Wallet_view.tvTotalMoney.setText(Integer.parseInt(Wallet_view.tvTotalMoney.getText().toString())+27) ;
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
            apiInterface.getWalletScan(amountRequestBody,farmerIdRequestBody).enqueue(new Callback<WalletScanOverview>() {
                @Override
                public void onResponse(Call<WalletScanOverview> call, Response<WalletScanOverview> response) {
                    activity_favourite.tvTotalMoney.setText(Integer.parseInt(activity_favourite.tvTotalMoney.getText().toString())+27) ;
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