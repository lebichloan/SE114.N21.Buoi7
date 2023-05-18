package com.example.se114n21buoi7;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    private Context context;
    public Database(@Nullable Context context) {
        super(context, "QuanLy.sqlite", null, 1);
        this.context = context;
    }

    public void QueryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }
    public Cursor GetData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql,null);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS Class(Id VARCHAR PRIMARY KEY, Name VARCHAR)";
        sqLiteDatabase.execSQL(sqlCreate);
        sqlCreate = "CREATE TABLE IF NOT EXISTS Student(Id VARCHAR PRIMARY KEY, Name VARCHAR, Dob VARCHAR, ClassId VARCHAR)";
        sqLiteDatabase.execSQL(sqlCreate);
        sqlCreate = "CREATE TABLE IF NOT EXISTS Account(Username VARCHAR PRIMARY KEY, Password VARCHAR)";
        sqLiteDatabase.execSQL(sqlCreate);

        String sqlInsert0 = "INSERT INTO Account VALUES('user','123')";
        sqLiteDatabase.execSQL(sqlInsert0);


        String sqlInsert1 = "INSERT INTO Class VALUES('LH001','ABC')";
        sqLiteDatabase.execSQL(sqlInsert1);

        String sqlInsert11 = "INSERT INTO Student VALUES('SV001','Nguyễn Văn A','15/02/2003','LH001')";
        sqLiteDatabase.execSQL(sqlInsert11);
        String sqlInsert12 = "INSERT INTO Student VALUES('SV002','Nguyễn Văn B','15/02/2003','LH001')";
        sqLiteDatabase.execSQL(sqlInsert12);
        String sqlInsert13 = "INSERT INTO Student VALUES('SV003','Nguyễn Văn C','15/02/2003','LH001')";
        sqLiteDatabase.execSQL(sqlInsert13);
        String sqlInsert14 = "INSERT INTO Student VALUES('SV004','Nguyễn Văn D','15/02/2003','LH001')";
        sqLiteDatabase.execSQL(sqlInsert14);

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

