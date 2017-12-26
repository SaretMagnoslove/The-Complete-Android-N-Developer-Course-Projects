package com.saretmagnoslove.userpass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public void Login(View view) {

        EditText User = (EditText) findViewById(R.id.User);
        EditText Pass = (EditText) findViewById(R.id.Pass);

        Log.i("User ", User.getText().toString());
        Log.i("Pass ", Pass.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
