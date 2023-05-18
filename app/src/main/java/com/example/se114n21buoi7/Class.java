package com.example.se114n21buoi7;

import java.io.Serializable;
import java.util.ArrayList;

public class Class implements Serializable {
    private String Id;
    private String Name;
    private int Students;

    private ArrayList<com.example.se114n21buoi7.Student> arraySubjects;

    public Class(String id, String name, int students, ArrayList<Student> arraySubjects) {
        Id = id;
        Name = name;
        Students = students;
        this.arraySubjects = arraySubjects;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getStudents() {
        return arraySubjects.size();
    }

    public void setStudents(int students) {
        Students = students;
    }

    public ArrayList<Student> getArraySubjects() {
        return arraySubjects;
    }

    public void setArraySubjects(ArrayList<Student> arraySubjects) {
        this.arraySubjects = arraySubjects;
    }
}
