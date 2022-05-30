package com.example.outback_autos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class SelectModelActivity extends AppCompatActivity {
    private CarInfoDBHelper carInfoDBHelper;
    private View view;
    private TextView brandName;
    private TextView brandInfo;
    private ImageView brandPic;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_model);

        view = findViewById(R.id.select_model_layout);
        carInfoDBHelper = new CarInfoDBHelper(view.getContext());
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.brand_name);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        brandName = findViewById(R.id.brand_label);
        brandInfo = findViewById(R.id.brand_info);
        brandPic = findViewById(R.id.brand_pic);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("brand");
            ArrayList<ArrayList<String>> dataModels = carInfoDBHelper.getCarInfoRecords(CarInfoContract.CarInfoEntry.BRAND + "=?", new String[]{value});
            ArrayList<String> dataBrands = carInfoDBHelper.getBrandInfoRecords(CarInfoContract.CarInfoEntry.BRAND + "=?", new String[]{value});
            ArrayList<String> models = new ArrayList<>();
            for (ArrayList<String> row : dataModels) {
                models.add(row.get(2));
            }

            brandName.setText(dataBrands.get(1));
            brandPic.setImageDrawable(getResources().getDrawable( view.getContext().getResources().getIdentifier(dataBrands.get(2), "drawable", view.getContext().getPackageName())));
            brandInfo.setText(dataBrands.get(3));


            ArrayAdapter<String> modelsAdapter = createSpinnerAdapter(models.toArray(new String[0]));
            spinner = (Spinner) findViewById(R.id.spinner);
            spinner.setAdapter(modelsAdapter);
        }

        spinner.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                ((TextView) spinner.getSelectedView()).setTextColor(Color.WHITE);
            }
        });

    }

    private ArrayAdapter<String> createSpinnerAdapter(String[] listItems) {
        return new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_spinner_dropdown_item, listItems) {


            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView textView = (TextView) view;

                textView.setTextColor(Color.BLACK);

                return view;
            }
        };
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public void openModel(View view) {
        Intent intent = new Intent(SelectModelActivity.this, ModelActivity.class);
        intent.putExtra("model", spinner.getSelectedItem().toString());
        startActivity(intent);
    }
}