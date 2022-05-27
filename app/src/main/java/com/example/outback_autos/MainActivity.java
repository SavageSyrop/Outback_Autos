package com.example.outback_autos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        toolbar.setOverflowIcon(getResources().getDrawable(R.drawable.ic_more));
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
            case R.id.fordButton:
                intent.putExtra("brand", "Ford");
                break;
            case R.id.chevroletButton:
                intent.putExtra("brand", "Chevrolet");
                break;
            case R.id.hyundaiButton:
                intent.putExtra("brand", "Hyundai");
                break;
            case R.id.opelButton:
                intent.putExtra("brand", "Opel");
                break;
            case R.id.subaruButton:
                intent.putExtra("brand", "Subaru");
                break;
            case R.id.volkswagenButton:
                intent.putExtra("brand", "Volkswagen");
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
        }
        return true;
    }


}