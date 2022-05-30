package com.example.outback_autos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends AppCompatActivity {
SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        toolbar.setOverflowIcon(getResources().getDrawable(R.drawable.ic_more));

        sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
    }


    public void callIntent(View view){
        Uri number = Uri.parse("tel:2281488");
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
        if (checkIntent(callIntent)) {
            startActivity(callIntent);
        }
    }

    public void webIntent(View view){
        Uri webpage = Uri.parse("https://savagesyrop.github.io/");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        if (checkIntent(webIntent)) {
            startActivity(webIntent);
        }
    }

    public void mapIntent(View view){
        Uri location = Uri.parse("geo:0,0?q=Westside+Auto+Wholesale");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);

        if (checkIntent(mapIntent)) {
            startActivity(mapIntent);
        }
    }

    public void openYoutube(View view){
        Uri webpage = Uri.parse("https://www.youtube.com/channel/UCQZ__ST6OA5GBB1wqlFMeTA");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        if (checkIntent(webIntent)) {
            startActivity(webIntent);
        }
    }

    public void openInstagram(View view){
        Uri webpage = Uri.parse("https://www.instagram.com/westsideauto");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        if (checkIntent(webIntent)) {
            startActivity(webIntent);
        }
    }

    public void openFacebook(View view){
        Uri webpage = Uri.parse("https://www.facebook.com/westsideautowholesale");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        if (checkIntent(webIntent)) {
            startActivity(webIntent);
        }
    }

    public void startSelect(View view){
        Intent intent = new Intent(MainActivity.this, SelectModelActivity.class);
        switch (view.getId()) {
            case R.id.alfa_romeoButton:
                intent.putExtra("brand", "Alfa Romeo");
                break;
            case R.id.bmwButton:
                intent.putExtra("brand", "BMW");
                break;
            case R.id.chevroletButton:
                intent.putExtra("brand", "Chevrolet");
                break;
            case R.id.dodgeButton:
                intent.putExtra("brand", "Dodge");
                break;
            case R.id.fordButton:
                intent.putExtra("brand", "Ford");
                break;
            case R.id.hondaButton:
                intent.putExtra("brand", "Honda");
                break;
            case R.id.hyundaiButton:
                intent.putExtra("brand", "Hyundai");
                break;
            case R.id.koenigseggButton:
                intent.putExtra("brand", "Koenigsegg");
                break;
            case R.id.mercedesButton:
                intent.putExtra("brand", "Mercedes");
                break;
            case R.id.mitsubishiButton:
                intent.putExtra("brand", "Mitsubishi");
                break;
            case R.id.nissanButton:
                intent.putExtra("brand", "Nissan");
                break;
            case R.id.opelButton:
                intent.putExtra("brand", "Opel");
                break;
            case R.id.porscheButton:
                intent.putExtra("brand", "Porsche");
                break;
            case R.id.skodaButton:
                intent.putExtra("brand", "Skoda");
                break;
            case R.id.subaruButton:
                intent.putExtra("brand", "Subaru");
                break;
            case R.id.uazButton:
                intent.putExtra("brand", "UAZ");
                break;
            case R.id.volkswagenButton:
                intent.putExtra("brand", "Volkswagen");
                break;
            case R.id.volvoButton:
                intent.putExtra("brand", "Volvo");
                break;
        }
        startActivity(intent);
    }

    public Boolean checkIntent(Intent intent) {
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, 0);
        return activities.size() > 0;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.menuAbout:{
                Intent intent = new Intent(MainActivity.this, AboutAppActivity.class);
                startActivity(intent);
                break;
            }

            case R.id.menuHowToUse: {
                Intent intent = new Intent(MainActivity.this, HowToUseActivity.class);
                startActivity(intent);
                break;
            }

            case R.id.exit:{
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("Remember",false);
                editor.commit();
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            }

            case R.id.deleteAccount:{
                Intent intent = new Intent(MainActivity.this, DeleteAccountActivity.class);
                startActivity(intent);
                finish();
                break;
            }
        }
        return true;
    }




}