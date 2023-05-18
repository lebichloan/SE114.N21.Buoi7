package com.example.se114n21buoi7;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class ClassDAO {
    Database database;
    StudentDAO studentDAO;
    public  ClassDAO(Context context){
        database = new Database(context);
        studentDAO = new StudentDAO(context);
    }

    public ArrayList<Class> AllClass(){
        String sql = "SELECT * FROM Class";
        ArrayList<Class> ListClass = new ArrayList<>();
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        while (cursor.moveToNext()){
            String Id = cursor.getString(0);
            String Name = cursor.getString(1);
             ArrayList<Student> ListStudent = studentDAO.AllStudentByClass(Id);
            int Students = ListStudent.size();
            Class item = new Class(Id,Name,Students, ListStudent);
            ListClass.add(item);
        }
        return ListClass;
    }
}

