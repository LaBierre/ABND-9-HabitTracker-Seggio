package com.example.standard.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.standard.habittracker.data.HabitTrackerDbHelper;

import com.example.standard.habittracker.data.HabitTrackerContract.HabitTrackerEnty;

public class HabitTrackerActivity extends AppCompatActivity {

    private HabitTrackerDbHelper mDbHelper;
    private Cursor cursor;

    public static final String LOG_TAG = HabitTrackerActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit_tracker);

        mDbHelper = new HabitTrackerDbHelper(this);

        insertData();
        readData();
    }

    private void insertData(){

        // Gets the data repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues valuesOne = new ContentValues();

        valuesOne.put(HabitTrackerEnty.COLUMN_DAY, "Monday");
        valuesOne.put(HabitTrackerEnty.COLUMN_TODO, "Laundry");
        valuesOne.put(HabitTrackerEnty.COLUMN_TODO_STATUS, HabitTrackerEnty.TODO_UNDONE);

        //Insert the new row
        db.insert(HabitTrackerEnty.TABLE_NAME, null, valuesOne);


        // Create a second new map of values, where column names are the keys
        ContentValues valuesTwo = new ContentValues();

        valuesTwo.put(HabitTrackerEnty.COLUMN_DAY, "Tuesday");
        valuesTwo.put(HabitTrackerEnty.COLUMN_TODO, "Garden");
        valuesTwo.put(HabitTrackerEnty.COLUMN_TODO_STATUS, HabitTrackerEnty.TODO_DONE);

        //Insert the new row
        db.insert(HabitTrackerEnty.TABLE_NAME, null, valuesTwo);
    }

    private Cursor readData(){

        // To access my database, i instantiate my subclass of SQLiteOpenHelper
        // and pass the context, which is the current activity.
        HabitTrackerDbHelper mDbHelper = new HabitTrackerDbHelper(this);

        // Create and/or open a database to read from it
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        try {
            // Perform this raw SQL query "SELECT * FROM pets" with db.query
            String[] position = {
                    HabitTrackerEnty.COLUMN_ID,
                    HabitTrackerEnty.COLUMN_DAY,
                    HabitTrackerEnty.COLUMN_TODO,
                    HabitTrackerEnty.COLUMN_TODO_STATUS
            };

            cursor = db.query(HabitTrackerEnty.TABLE_NAME, position,null, null, null, null, null);

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            cursor.moveToFirst();
            cursor.close();
            db.close();
        }
        return cursor;
    }
}
