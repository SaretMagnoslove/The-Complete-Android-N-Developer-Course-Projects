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

            myDatabase.execSQL("INSERT INTO users (name,age) VALUES ('Lord Rahl',93)");

            myDatabase.execSQL("INSERT INTO users (name,age) VALUES ('Buffy',23)");

            Cursor c = myDatabase.rawQuery("SELECT * FROM users", null);
/*
            Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE age > 100", null);
            Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE age > 100 AND name='Dracula'", null);
            Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE name LIKE 'D%'", null);
            Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE age > 100 AND name LIKE '%u%'", null);
            Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE age > 100 LIMIT 1", null);
*/
            // myDatabase.execSQL("DELETE FROM users WHERE name = 'BraTac' LIMIT 1");

            //myDatabase.execSQL("UPDATE users SET age = 123 WHERE name = 'BraTac' LIMIT 1");

            /*myDatabase.execSQL("DELETE FROM users WHERE id IN (SELECT id FROM users " +
                    "WHERE name = 'BraTac' LIMIT 1)"); */

            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS Newusers (name VARCHAR, age INT(3)," +
                    "id INTEGER PRIMARY KEY)");

            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, age INT(3))");

            myDatabase.execSQL("INSERT INTO Newusers (name,age) VALUES('Dracula',400)");

            myDatabase.execSQL("INSERT INTO Newusers (name,age) VALUES ('BraTac',132)");

            myDatabase.execSQL("INSERT INTO Newusers (name,age) VALUES ('Lord Rahl',93)");

            myDatabase.execSQL("INSERT INTO Newusers (name,age) VALUES ('Buffy',23)");

            myDatabase.execSQL("DELETE FROM Newusers WHERE id = 1");

            Cursor curse = myDatabase.rawQuery("SELECT * FROM Newusers", null);

            int nameIndex = curse.getColumnIndex("name");
            int ageIndex = curse.getColumnIndex("age");
            int idIndex = curse.getColumnIndex("id");

            c.moveToFirst();
            while (curse != null) {

                Log.i("userResults - name",curse.getString(nameIndex));
                Log.i("userResults - age",Integer.toString(curse.getInt(ageIndex)));
                Log.i("userResults - id",Integer.toString(curse.getInt(idIndex)));

                curse.moveToNext();

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
