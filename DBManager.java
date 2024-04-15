package com.example.storagetest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {

    DBHelper dbHelper;

    public DBManager(Context context){
        dbHelper = new DBHelper(context);
    }

    public long addNotes(String title, String text) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.TITLE, title);
        contentValues.put(DBHelper.BODY, text);
        //



        long x = dbOpen().insert(DBHelper.TABLE_NAME, null, contentValues);

        dbClose();
        //
        return x;
    }

    public Cursor getNotes(){
        return dbOpen().rawQuery("SELECT * FROM "+DBHelper.TABLE_NAME+" WHERE 1", null);
    }

    public SQLiteDatabase dbOpen(){
        return dbHelper.getWritableDatabase();
    }
    public void dbClose() {
        dbHelper.close();
    }

}
