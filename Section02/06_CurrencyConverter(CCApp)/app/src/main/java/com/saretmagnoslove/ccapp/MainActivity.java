package com.saretmagnoslove.ccapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void convert(View view) {

        EditText Dollars = (EditText) findViewById(R.id.Dollars);

        Double DollarsDouble = Double.parseDouble(Dollars.getText().toString());

        Double PoundsDouble = DollarsDouble * 0.75;

        Toast.makeText(MainActivity.this,
                "£" + String.format("%.2f", PoundsDouble), Toast.LENGTH_SHORT).show();



        Log.i("amout ", Dollars.getText().toString());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
