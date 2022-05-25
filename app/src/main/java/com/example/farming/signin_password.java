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

public class signin_password extends AppCompatActivity {

    Button loginbtn;
    EditText userNameText, gmailText;
    TextInputLayout passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_password);

        loginbtn = findViewById(R.id.loggingbtn);
        userNameText = findViewById(R.id.username);
        gmailText = findViewById(R.id.gmail);
        passwordText = findViewById(R.id.password);

            loginbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!userNameText.getText().toString().isEmpty() &&
                            !gmailText.getText().toString().isEmpty() &&
                            !passwordText.toString().isEmpty()) {
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(signin_password.this);
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        editor.putBoolean("userLoggedInFlag", true);

                        editor.apply();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);

                    } else {
                        Toast.makeText(signin_password.this, "Please Fill All The Required Fields", Toast.LENGTH_SHORT).show();
                    }
                }
                });


    }
}