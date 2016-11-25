package com.example.bassant.movieapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Bassant on 11/22/2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "moveApp.db";
    public static final String TABLE_NAME = "movieTable";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "POSTER";
    public static final String COL_3 = "TITLE";
    public static final String COL_4 = "OVERVIEW";
    public static final String COL_5 = "DATE";
    public static final String COL_6 = "RATE";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table "+TABLE_NAME+" (ID INTEGER PRIMARY KEY,POSTER TEXT NOT NULL,TITLE TEXT NOT NULL,OVERVIEW TEST NOT NULL,DATE TEST NOT NULL,RATE TEST NOT NULL)");
        //elfra8 abl we ba3d + fe "" 3shan strings matlza2sh fe ba3d
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLR IF EXISTS"+TABLE_NAME);
        onCreate(sqLiteDatabase);

    }
    public boolean insertData(String poster,String title ,String overview,int id,String date,String rate)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,poster);
        contentValues.put(COL_3,title);
        contentValues.put(COL_4,overview);
        contentValues.put(COL_5,date);
        contentValues.put(COL_6,rate);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result == -1)
        {
            return false;
        }else {return true;}
    }

    public Cursor getAllData ()
    {
      //  SQLiteDatabase db = this.getWritableDatabase();
         SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;

    }
}
