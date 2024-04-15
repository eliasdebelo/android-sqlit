package com.example.storagetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "db_test.db";

    // Table Name
    public static final String TABLE_NAME = "Notes";
    // Table columns
    public static final String _ID = "_id";
    public static final String TITLE = "title";
    public static final String BODY = "body";

    public static final String CREATE_TABLE =
            "CREATE TABLE "+TABLE_NAME+"("+_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+TITLE+" TEXT, "+BODY+" TEXT)";
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS "+TABLE_NAME;

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }
}
