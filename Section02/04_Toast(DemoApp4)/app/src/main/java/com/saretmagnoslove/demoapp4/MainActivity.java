package com.saretmagnoslove.demoapp4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void clickFunction(View view) {

        EditText Name = (EditText) findViewById(R.id.Name);

        Toast.makeText(MainActivity.this, Name.getText().toString() + "?", Toast.LENGTH_LONG).show();



        Log.i("Name", Name.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
