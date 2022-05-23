package com.example.farming;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Enter_mobile_number extends AppCompatActivity {


    EditText enterMobileNumber ;
    Button getOTPButton ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_mobile_number);

        enterMobileNumber = findViewById(R.id.input_mobile_number);
        getOTPButton = findViewById(R.id.buttongetotp);


        final ProgressBar progressBar = findViewById(R.id.progressbar_sending_OTP);


        getOTPButton.setOnClickListener((view) -> {

            if (!enterMobileNumber.getText().toString().trim().isEmpty()) {
                if ((enterMobileNumber.getText().toString().trim()).length() == 10) {


                    progressBar.setVisibility(View.VISIBLE);
                    getOTPButton.setVisibility(View.INVISIBLE);

                    PhoneAuthProvider.getInstance().verifyPhoneNumber(
                            "+91" + enterMobileNumber.getText().toString(),
                            60,
                            TimeUnit.SECONDS, Enter_mobile_number.this,
                            new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                                @Override
                                public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                    progressBar.setVisibility(View.GONE);
                                    getOTPButton.setVisibility(View.VISIBLE);
                                }

                                @Override
                                public void onVerificationFailed(@NonNull FirebaseException e) {

                                    progressBar.setVisibility(View.GONE);
                                    getOTPButton.setVisibility(View.VISIBLE);
                                    Toast.makeText(Enter_mobile_number.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                                }

                                @Override
                                public void onCodeSent(@NonNull String backendotp, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                    progressBar.setVisibility(View.GONE);
                                    getOTPButton.setVisibility(View.VISIBLE);

                                    Intent intent = new Intent(getApplicationContext(), verify_otp_two.class);
                                    intent.putExtra("mobile", enterMobileNumber.getText().toString());
                                    intent.putExtra("backendotp", backendotp);
                                    startActivity(intent);
                                }
                            }
                    );

                } else {
                    Toast.makeText(Enter_mobile_number.this, "Please Enter Correct Number", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(Enter_mobile_number.this, "Enter Mobile Number", Toast.LENGTH_SHORT).show();

            }
        });
    }
}