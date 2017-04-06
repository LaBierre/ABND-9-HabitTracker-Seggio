package com.example.standard.habittracker.data;

import android.provider.BaseColumns;

/**
 * Created by vince on 06.04.2017.
 */

public final class HabitTrackerContract {

    public static abstract class HabitTrackerEnty implements BaseColumns{

        public static final String COLUMN_ID = BaseColumns._ID;
        public static final String TABLE_NAME = "habits";
        public static final String COLUMN_DAY = "day";
        public static final String COLUMN_TODO = "todo";
        public static final String COLUMN_TODO_STATUS = "status";

        //Possible values for the to-do status
        public static final int TODO_UNDONE = 0;
        public static final int TODO_DONE = 1;
    }
}
