package com.example.outback_autos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class DeleteAccountActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private TextView passwordView;
    private TextView loginView;
    private ImageButton girlButton;
    private Integer nextSoundIndex=16;
    private Integer [] sounds = {R.raw.ayaya,R.raw.bcs,R.raw.fiftyfour,R.raw.genji_ult,R.raw.hanzo_ult,
    R.raw.krol,R.raw.mada,R.raw.mcree,R.raw.moan,R.raw.ohlala,R.raw.reaper_angry,R.raw.reaper_dislike,R.raw.reaper_monkey,
    R.raw.reaper_ult,R.raw.tuturu,R.raw.uwu,R.raw.wee_wee,R.raw.widow_feel,R.raw.wow};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_account);

        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.parseColor("#FB3A70"));

        Toolbar toolbar = (Toolbar) findViewById(R.id.htu_toolbar);
        toolbar.setTitle("Delete account");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        passwordView = findViewById(R.id.password_textField);
        loginView = findViewById(R.id.login_textField);
        girlButton = findViewById(R.id.deletePic);
    }

    public void deleteConfirm(View view) {
        Set<String> loginPasswordSet = sharedPreferences.getStringSet("LoginPassword", new HashSet<>());

        String enteredLogin = loginView.getText().toString();
        String enteredPassword =  passwordView.getText().toString();
        String loginPassword = enteredLogin+":"+enteredPassword;
        if (enteredLogin.equals(sharedPreferences.getString("CurrentLogin",null)) && enteredPassword.equals(sharedPreferences.getString("CurrentPassword",null))){
            loginPasswordSet.remove(loginPassword);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putStringSet("LoginPassword",loginPasswordSet);
            editor.putBoolean("Remember", false);
            editor.commit();
            Toast.makeText(this, "Account deleted!", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Wrong login or password", Toast.LENGTH_SHORT).show();
            return;
        }

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent loginIntent = new Intent(DeleteAccountActivity.this,LoginActivity.class);
                startActivity(loginIntent);
                finish();
            }
        },2000);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {

            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public void makeSound(View view){
        if (nextSoundIndex==sounds.length)
            nextSoundIndex=0;
        MediaPlayer mp = MediaPlayer.create(this, sounds[nextSoundIndex]);
        mp.start();
        girlButton.setEnabled(false);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                nextSoundIndex++;
                girlButton.setEnabled(true);
            }
        },2000);
    }
}