package com.saretmagnoslove.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int n;

    public void makeToast (String string) {

        Toast.makeText(MainActivity.this, string, Toast.LENGTH_SHORT).show();
    }

    public void guess(View view) {

        EditText guessText = (EditText) findViewById(R.id.guessText);

        int guessInt = Integer.parseInt(guessText.getText().toString());

        if (guessInt > n)  {

            makeToast("Lower!");

        } else if (guessInt < n) {

            makeToast("Higer");

        } else {

            makeToast("Wow! You got it! Now try again...");

            Random rand = new Random();
            n = rand.nextInt(20) + 1;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random rand = new Random();
        int n = rand.nextInt(20) + 1;

    }
}
