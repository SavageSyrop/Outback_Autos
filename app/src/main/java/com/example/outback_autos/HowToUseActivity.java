package com.example.outback_autos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class HowToUseActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    TextView userView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_use);

        Toolbar toolbar = (Toolbar) findViewById(R.id.htu_toolbar);
        toolbar.setTitle("How to use");
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        userView = findViewById(R.id.userGreet);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        String currentLogin = sharedPreferences.getString("CurrentLogin",null);
        userView.setText("Hey, "+ currentLogin+"!");


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}