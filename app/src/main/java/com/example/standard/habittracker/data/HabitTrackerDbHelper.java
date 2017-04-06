package com.example.standard.habittracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.standard.habittracker.data.HabitTrackerContract.HabitTrackerEnty;

/**
 * Created by vince on 06.04.2017.
 */

public class HabitTrackerDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = HabitTrackerDbHelper.class.getSimpleName();

    /** Name of the database file */
    private static final String DATABASE_NAME = "habittracker.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 2;

    public HabitTrackerDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This is called when the database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_CREATE_HABITS_TABLE = "CREATE TABLE " + HabitTrackerEnty.TABLE_NAME + " ("
                + HabitTrackerEnty._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitTrackerEnty.COLUMN_DAY + " TEXT NOT NULL, "
                + HabitTrackerEnty.COLUMN_TODO + " TEXT, "
                + HabitTrackerEnty.COLUMN_TODO_STATUS + " INTEGER NOT NULL DEFAULT 0);";

        db.execSQL(SQL_CREATE_HABITS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + HabitTrackerEnty.TABLE_NAME + ";");

        // Create tables again
        onCreate(db);
    }
}
