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

public class scannerView extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    ZXingScannerView scannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scannerView = new ZXingScannerView(this);
        setContentView(scannerView);

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
        if(getIntent().getStringExtra("calling_activity").equals("walletView")) {
            Wallet_view.scantext.setText(result.getText());
            onBackPressed();
            Wallet_view.scantext.setVisibility(View.VISIBLE);
        }
        else if(getIntent().getStringExtra("calling_activity").equals("activityFavourite"))
        {
            activity_favourite.scantext.setText(result.getText());
            onBackPressed();
            activity_favourite.scantext.setVisibility(View.VISIBLE);
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