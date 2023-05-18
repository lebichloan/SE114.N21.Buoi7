package com.example.se114n21buoi7;

import java.io.Serializable;

public class Student implements Serializable {
    private String Id;
    private String Name;
    private String Dob;

    public Student(String id, String name, String dob) {
        Id = id;
        Name = name;
        Dob = dob;
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

    public String getDob() {
        return Dob;
    }

    public void setDob(String dob) {
        Dob = dob;
    }
}
