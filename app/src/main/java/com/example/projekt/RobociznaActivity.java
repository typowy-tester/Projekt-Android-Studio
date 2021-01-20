package com.example.projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class RobociznaActivity extends AppCompatActivity {
    SharedPreferences pref;
    EditText paintingET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robocizna);

        getSupportActionBar().setTitle("Ustawienia");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowCustomEnabled(true);

        pref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        paintingET = (EditText) findViewById(R.id.paintingCostET);
        float kosztMalowania = pref.getFloat(PricePaintingActivity.paintingCost, 0);
        paintingET.setText(Float.toString(kosztMalowania));
    }

    public void zapisz(View v) {
        SharedPreferences.Editor e = pref.edit();

        float kosztMalowania = Float.parseFloat(paintingET.getText().toString());
        e.putFloat(PricePaintingActivity.paintingCost, kosztMalowania);
        e.apply();
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