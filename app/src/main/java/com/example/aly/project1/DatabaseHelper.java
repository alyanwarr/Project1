package com.example.aly.project1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by aly on 11/18/16.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "APPDB.db";
    private static final String TABLE_NAME = "users";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_USERNAME = "USERNAME";
    private static final String COLUMN_EMAIL = "EMAIL";
    private static final String COLUMN_PASS = "PASS";
    private static final String COLUMN_PROFILE_PIC = "PROFILE_PIC";
    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table users(ID integer primary key not null, " +
            "USERNAME text not null, EMAIL text not null, PASS text not null, PROFILE_PIC not null);";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(TABLE_CREATE);
        this.db = db;

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    String query = "DROP TABLE IF EXSITS " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);

    }

    public void insertUser(Users c) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String qq = "select * from users";
        Cursor crr = db.rawQuery(qq, null);
        int count = crr.getCount();
        values.put(COLUMN_ID,count);
        values.put(COLUMN_USERNAME, c.getUname());
        values.put(COLUMN_EMAIL, c.getEmail());
        values.put(COLUMN_PASS, c.getPass());
    db.insert(TABLE_NAME,null, values);
        db.close();
    }

    public String searchPass(String uname) {
        db = this.getReadableDatabase();
        String q = "select USERNAME, PASS from "+TABLE_NAME;
        Cursor cur = db.rawQuery(q, null);
        String a, b;
        b = "not found";
        if (cur.moveToFirst())
        {
            do {
                a = cur.getString(0);
                if(a.equals(uname))
                {
                    b = cur.getString(1);
                    break;
                }
            }
            while(cur.moveToNext());

        }
        return b ;
    }
}

