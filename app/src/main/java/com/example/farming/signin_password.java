package com.example.farming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class signin_password extends AppCompatActivity {

    Button loginbtn;
    EditText userNameText, gmailText;
    TextInputLayout passwordText;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_password);

        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);

        loginbtn = findViewById(R.id.loggingbtn);
        userNameText = findViewById(R.id.username);
        passwordText = findViewById(R.id.password);

            loginbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!userNameText.getText().toString().isEmpty() &&
                            !passwordText.getEditText().getText().toString().isEmpty()) {
                        final RequestBody userName = RequestBody.create(MediaType.parse("text/plain"), userNameText.getText().toString());
                        final RequestBody password = RequestBody.create(MediaType.parse("text/plain"), passwordText.getEditText().getText().toString());
                        apiInterface.postFarmerLogin(userName, password).enqueue(new Callback<ResponseArrayFarmerLoginOverview>() {
                            @Override
                            public void onResponse(Call<ResponseArrayFarmerLoginOverview> call, Response<ResponseArrayFarmerLoginOverview> response) {
                                if (response.body() != null && response.body().getStatus() == 1){
                                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(signin_password.this);
                                    SharedPreferences.Editor editor = sharedPreferences.edit();

                                    editor.putBoolean("userLoggedInFlag", true);
                                    editor.putString("userId", response.body().getResponse().getId());

                                    editor.apply();
                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(intent);
                                } else{
                                    Toast.makeText(signin_password.this, "Please Provide Correct Details", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<ResponseArrayFarmerLoginOverview> call, Throwable t) {
                                Toast.makeText(signin_password.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                            }
                        });


                    } else {
                        Toast.makeText(signin_password.this, "Please Fill All The Required Fields", Toast.LENGTH_SHORT).show();
                    }
                }
                });


    }

}

