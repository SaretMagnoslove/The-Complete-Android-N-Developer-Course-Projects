package com.saretmagnoslove.databasedemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);

            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, age INT(3))");

            myDatabase.execSQL("INSERT INTO users (name,age) VALUES('Dracula',400)");

            myDatabase.execSQL("INSERT INTO users (name,age) VALUES ('BraTac',132)");

            Cursor c = myDatabase.rawQuery("SELECT * FROM users", null);

            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");

            c.moveToFirst();
            while (c != null) {

                Log.i("name",c.getString(nameIndex));
                Log.i("age",Integer.toString(c.getInt(ageIndex)));

                c.moveToNext();
            }
        }
        catch (Exception e) {

            e.printStackTrace();
        }

        try {

            SQLiteDatabase eventDB = this.openOrCreateDatabase("Events", MODE_PRIVATE, null);

            eventDB.execSQL("CREATE TABLE IF NOT EXISTS events (event VARCHAR, year INT(4))");

            eventDB.execSQL("INSERT INTO events (event, year) VALUES ('WW2', 1945)");

            eventDB.execSQL("INSERT INTO events (event, year) VALUES ('Wham', 1988)");

            Cursor c = eventDB.rawQuery("SELECT * FROM events", null);

            int eventIndex = c.getColumnIndex("event");
            int yearIndex = c.getColumnIndex("year");

            c.moveToFirst();

            while (c != null) {

                Log.i("Results - event", c.getString(eventIndex));
                Log.i("Results - year", Integer.toString(c.getInt(yearIndex)));

                c.moveToNext();
            }

        }
        catch (Exception e) {

            e.printStackTrace();
        }
    }
}
