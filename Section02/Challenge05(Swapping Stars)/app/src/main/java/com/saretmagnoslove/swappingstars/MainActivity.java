package com.saretmagnoslove.swappingstars;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void swapStar(View view) {

        Log.i("test", "button clicked");

        ImageView image = (ImageView) findViewById(R.id.StarWars);
        image.setImageResource(R.drawable.startrek);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
