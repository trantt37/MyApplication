package com.example.carolinebudwell.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObservable;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by TTT on 3/21/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "entries.db";
    private static final String TABLE_NAME = "entries";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_SYNONYM = "synonym";
    private static final String COLUMN_ANTONYM = "antonym";
    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table entries (_id integer primary key autoincrement, " +
            "synonym text not null, antonym text not null);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    public void insertEntry(Entry e) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_SYNONYM, e.getSynonym());
        values.put(COLUMN_ANTONYM, e.getAntonym());
        db.insert(TABLE_NAME, null, values);
    }

    public String searchPair(String word) {
        db = this.getReadableDatabase();
        String query = "select synonym, antonym from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a="";
        String b="";
        if (cursor.moveToFirst()) {
            do {
                a = cursor.getString(0);
                b = cursor.getString(1);
                if(word.equalsIgnoreCase(a))
                    return b;
                if(word.equalsIgnoreCase(b))
                    return a;
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return "";
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
