package com.example.bassant.movieapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Bassant on 11/22/2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "moveApp.dp";
    public static final String TABLE_NAME = "movieTable";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "POSTER";
    public static final String COL_3 = "TITLE";
    public static final String COL_4 = "OVERVIEW";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
       // SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table "+TABLE_NAME+" (ID INTEGER PRIMARY KEY AUTOINCREMENT,POSTER TEXT,TITLE TEXT,OVERVIEW TEST)");
        //elfra8 abl we ba3d + fe "" 3shan strings matlza2sh fe ba3d
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLR IF EXISTS"+TABLE_NAME);
        onCreate(sqLiteDatabase);

    }
}
