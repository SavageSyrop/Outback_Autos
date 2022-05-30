package com.example.outback_autos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.media.Image;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class ModelActivity extends AppCompatActivity {
    private CarInfoDBHelper carInfoDBHelper;
    private View view;
    private TextView model;
    private ImageView image;
    private TextView power;
    private TextView speed;
    private TextView fuel;
    private TextView torque;
    private TextView clearance;
    private TextView drive;
    private TextView price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model);
        view = findViewById(R.id.model_layout);
        carInfoDBHelper = new CarInfoDBHelper(view.getContext());


        model = findViewById(R.id.model_label);
        image = findViewById(R.id.carImage);
        power = findViewById(R.id.power_label);
        speed = findViewById(R.id.speed_label);
        fuel = findViewById(R.id.fuel_label);
        torque = findViewById(R.id.torque_label);
        clearance = findViewById(R.id.clearance_label);
        drive = findViewById(R.id.drive_label);
        price = findViewById(R.id.price_label);


        Bundle extras = getIntent().getExtras();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        String chosenModel = extras.getString("model");
        toolbar.setTitle(R.string.model_name);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        if (extras != null) {
            ArrayList<String> data = carInfoDBHelper.getCarInfoRecords(CarInfoContract.CarInfoEntry.MODEL + "=?", new String[] {chosenModel}).get(0);
            model.setText(data.get(2));
            image.setImageDrawable(getResources().getDrawable( view.getContext().getResources().getIdentifier(data.get(3), "drawable", view.getContext().getPackageName())));
            power.setText(data.get(4)+" h.p.");
            speed.setText(data.get(5)+" km/h");
            fuel.setText(data.get(6)+" per 100 km");
            torque.setText(data.get(7)+ " rpm");
            clearance.setText(data.get(8)+ " mm");
            drive.setText(data.get(9));
            price.setText(data.get(10)+" $");
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}