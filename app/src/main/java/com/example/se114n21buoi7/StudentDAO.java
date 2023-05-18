package com.example.se114n21buoi7;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class StudentDAO {
    Database database;
    public  StudentDAO(Context context){
        database = new Database(context);
    }

    public ArrayList<Student> AllStudentByClass(String ClassId){
        String sql = "SELECT * FROM Student WHERE ClassId ='"+ClassId +"'";
        ArrayList<Student> ListStudent = new ArrayList<>();
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        while (cursor.moveToNext()){
            String Id = cursor.getString(0);
            String Name = cursor.getString(1);
            String Dob = cursor.getString(2);
            Student item = new Student(Id,Name,Dob);
            ListStudent.add(item);
        }
        return ListStudent;
    }

    public  void Remove(String Id){
        String sql = "DELETE FROM Student WHERE Id ='" +Id+"'";
        SQLiteDatabase db = database.getReadableDatabase();
        db.execSQL(sql);
    }
}
