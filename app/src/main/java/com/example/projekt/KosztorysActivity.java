package com.example.projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.widget.EditText;

public class KosztorysActivity extends AppCompatActivity {
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kosztorys);
        pref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        getSupportActionBar().setTitle("Kosztorys");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowCustomEnabled(true);

        Intent i = getIntent();
        float width = i.getFloatExtra(PricePaintingActivity.widthName, 0);
        float length = i.getFloatExtra(PricePaintingActivity.lengthName, 0);
        float height = i.getFloatExtra(PricePaintingActivity.heightName, 0);

        float wallArea = 2 * (width * height) + 2 * (length * height);
        float ceilArea = width * length;

        EditText result = (EditText) findViewById(R.id.resultET);
        result.setText("Całkowita powierzchnia Scian: "+ wallArea + "m^2\n");
        result.setText(result.getText() + "Powierzchnia podłogi / sufitu: "+ ceilArea + "m^2\n");

        float paintingCost = pref.getFloat(PricePaintingActivity.paintingCost, 0);

        float wallCost = wallArea * paintingCost;
        float ceilCost = ceilArea * paintingCost;

        result.setText(result.getText() + "Koszt malowania ścian: " + wallCost + "zł\n");
        result.setText(result.getText() + "Koszt malowania sufitu: " + ceilCost + "zł\n");
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home)  {
            Intent intent = new Intent(this, PricePaintingActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);

        }
        return super.onOptionsItemSelected(menuItem);
    }
}