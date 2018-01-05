package com.saretmagnoslove.fadeswitch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void fade (View view) {

        ImageView cloud = (ImageView) findViewById(R.id.cloud);
        ImageView sephiroth = (ImageView) findViewById(R.id.sephiroth);

        cloud.animate().alpha(0f).setDuration(2000);
        sephiroth.animate().alpha(1f).setDuration(2000);
    }
    public void fadeBack (View view) {

        ImageView cloud = (ImageView) findViewById(R.id.cloud);
        ImageView sephiroth = (ImageView) findViewById(R.id.sephiroth);

        cloud.animate().alpha(1f).setDuration(2000);
        sephiroth.animate().alpha(0f).setDuration(2000);


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
