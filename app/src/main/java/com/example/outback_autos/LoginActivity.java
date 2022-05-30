package com.example.outback_autos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;

public class LoginActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private TextView passwordView;
    private TextView loginView;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        passwordView = findViewById(R.id.password_textField);
        loginView = findViewById(R.id.login_textField);
        checkBox = findViewById(R.id.checkBox);
        sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        Boolean rememberME = sharedPreferences.getBoolean("Remember",false);

        if (rememberME){
            Intent homeIntent = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(homeIntent);
            finish();
        }
    }

    public void signIn(View view){
        Set<String> loginPasswords = sharedPreferences.getStringSet("LoginPassword",null);

        if (loginPasswords==null){
            Toast.makeText(this, "Such login doesn't exists!", Toast.LENGTH_SHORT).show();
            return;
        } else {
            String login = loginView.getText().toString();
            String password = passwordView.getText().toString();
            if (loginPasswords.contains(login+":"+password)){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                if (checkBox.isChecked()){
                    editor.putBoolean("Remember",true);
                }
                editor.putString("CurrentLogin",login);
                editor.putString("CurrentPassword",password);
                editor.commit();
                Toast.makeText(this, "Welcome to Outback!", Toast.LENGTH_SHORT).show();
                Intent regIntent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(regIntent);
                finish();
            }
            else {
                Toast.makeText(this, "Wrong login or password!", Toast.LENGTH_SHORT).show();
                return;
            }
        }
    }

    public void signUp(View view){
        Intent regIntent = new Intent(LoginActivity.this,RegistrationActivity.class);
        startActivity(regIntent);
        finish();
    }
}