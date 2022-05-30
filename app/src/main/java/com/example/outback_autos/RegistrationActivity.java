package com.example.outback_autos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RegistrationActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private TextView passwordView;
    private TextView loginView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        sharedPreferences = getSharedPreferences("MyPreferences",Context.MODE_PRIVATE);
        passwordView = findViewById(R.id.password_textField);
        loginView = findViewById(R.id.login_textField);
    }

    public void registerConfirm(View view) {
        Set<String> loginPassword = sharedPreferences.getStringSet("LoginPassword", new HashSet<>());

        String enteredLogin = loginView.getText().toString();
        String enteredPassword =  passwordView.getText().toString();

        for (String login: loginPassword){
            login = login.split(":")[0];
            if (login.equals(enteredLogin)){
                Toast.makeText(this, "Such login already exists!", Toast.LENGTH_SHORT).show();
                return;
            } else {
                continue;
            }
        }
        loginPassword.add(enteredLogin+":"+enteredPassword);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putStringSet("LoginPassword",loginPassword);
        editor.commit();
        Toast.makeText(this, "Successfully registered!", Toast.LENGTH_SHORT).show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent loginIntent = new Intent(RegistrationActivity.this,LoginActivity.class);
                startActivity(loginIntent);
                finish();
            }
        },2000);
    }

    public void generateRandomPassword(View view) {
        int len = 8;
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghi"
                +"jklmnopqrstuvwxyz!@#$%&";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        Toast.makeText(this, "Generated password: "+sb.toString(), Toast.LENGTH_LONG).show();
        passwordView.setText(sb.toString());
    }
}