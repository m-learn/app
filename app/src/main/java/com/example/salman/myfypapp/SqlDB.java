package com.example.salman.myfypapp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;//class responsible for managing the database ... creation/ editing etc

public class SqlDB extends SQLiteOpenHelper {
    public final static String DATABASE_NAME = "com.example.salman.myfypapp";
    public static final String HIGHSCORE_TABLE_NAME = "allscores";
    public static final String CONFIG_TABLE = "config";


    public SqlDB(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + HIGHSCORE_TABLE_NAME
                + "(score integer, playtime text)");
        db.execSQL("create table " + CONFIG_TABLE + "(key text, val text)");

        db.execSQL("Insert Into " + CONFIG_TABLE + "(key, val) Values('sound', 'on')");
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + HIGHSCORE_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + CONFIG_TABLE);
        onCreate(db);
    }

    public boolean insertScore(int score) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("score", score);
        contentValues.put("playtime", format.format(new Date()));

        db.insert(HIGHSCORE_TABLE_NAME, null, contentValues);
        return true;
    }

    public ArrayList<Score> getTop10() {
        ArrayList<Score> array_list = new ArrayList<Score>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select score, playtime from "
                        + HIGHSCORE_TABLE_NAME + " Order By score DESC, playtime DESC LIMIT 10",
                null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            Score score = new Score(res.getInt(res
                    .getColumnIndex("score")), res.getString(res
                    .getColumnIndex("playtime")));
            array_list.add(score);
            res.moveToNext();
        }
        return array_list;
    }

    public String getConfigValue(String key) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select val from " + CONFIG_TABLE
                + " Where key = '" + key + "'", null);
        res.moveToFirst();
        String val = res.getString(0);
        return val;
    }

    public void updateConfigValue(String key, String value) {
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL("Delete From " + CONFIG_TABLE + " Where key = '" + key + "'");
        db.execSQL("Insert Into " + CONFIG_TABLE + "(key, val) Values ('" + key
                + "', '" + value + "')");
    }
}