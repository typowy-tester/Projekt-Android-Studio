package com.example.projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class PricePaintingActivity extends AppCompatActivity {
    static final String widthName = "com.example.projektx.width";
    static final String lengthName = "com.example.projektx.length";
    static final String heightName = "com.example.projektx.height";
    static final String paintingCost = "com.example.projektx.paintingCost";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price_painting);

        getSupportActionBar().setTitle("Mirek budowlaniec");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
    }

    public void policz(View v) {
        Intent i = new Intent(this, KosztorysActivity.class);
        EditText szerokośćTE = (EditText) findViewById(R.id.widthET);
        float szerokość = Float.parseFloat(szerokośćTE.getText().toString());
        i.putExtra(widthName, szerokość);
        EditText dlugośćTE = (EditText) findViewById(R.id.lenghtET);
        float dlugość = Float.parseFloat(dlugośćTE.getText().toString());
        i.putExtra(lengthName, dlugość);
        EditText wysokoscTE = (EditText) findViewById(R.id.heightET);
        float wysokość = Float.parseFloat(wysokoscTE.getText().toString());
        i.putExtra(heightName, wysokość);
        startActivity(i);
    }

    public  void  ustawienia(View v) {
        Intent i = new Intent(this, RobociznaActivity.class);
        startActivity(i);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.painting_options_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem Item) {
        if (Item.getItemId() == android.R.id.home)  {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);

        }
        if (Item.getItemId() == R.id.ustawienia) {
            Intent intent = new Intent(getApplicationContext(), RobociznaActivity.class);

            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

            return true;
        }

        return false;
    }

}