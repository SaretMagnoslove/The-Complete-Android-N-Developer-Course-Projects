package com.saretmagnoslove.movinganimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.nio.InvalidMarkException;

public class MainActivity extends AppCompatActivity {

    public void move (View view) {

        ImageView cloud = (ImageView) findViewById(R.id.cloud);
        /*
        cloud.animate().translationXBy(-2000f).setDuration(2000);
        cloud.animate().translationXBy(2000f).setDuration(2000);
        cloud.animate().rotation(360f).setDuration(2000);
        cloud.animate().scaleX(0.5f).scaleY(0.5f).setDuration(2000);
        */

        cloud.animate()
                .translationXBy(2000f)
                .translationYBy(2000f)
                .rotation(3600f)
                .setDuration(2000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageView could = (ImageView) findViewById(R.id.cloud);
        could.setTranslationX(-2000f);
        could.setTranslationY(-2000f);
    }
}
