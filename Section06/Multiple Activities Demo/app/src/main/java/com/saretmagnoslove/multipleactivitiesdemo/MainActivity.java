package com.saretmagnoslove.multipleactivitiesdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public void toSecondActivity(View view) {

        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        intent.putExtra("UserName", "Clark");

        startActivity(intent );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
