package com.example.se114n21buoi7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class sub_activity extends AppCompatActivity {

    TextView textViewClassId,textViewClassName,textStudentQuantity;
    ListView listViewStudent;
    ImageView imageViewBack;
    ArrayList<Student> ListStudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        textViewClassId =findViewById(R.id.textViewClassId);
        textViewClassName =findViewById(R.id.textViewClassName);
        textStudentQuantity =findViewById(R.id.textStudentQuantity);
        listViewStudent = findViewById(R.id.listViewStudent);
        imageViewBack = findViewById(R.id.imageViewBack);
        Intent intent = getIntent();
        Class data = (Class) intent.getSerializableExtra("data");
        ListStudent = data.getArraySubjects();
        textViewClassId.setText(data.getId());
        textViewClassName.setText(data.getName());
        textStudentQuantity.setText(String.valueOf(ListStudent.size()));
        StudentAdapter studentAdapter = new StudentAdapter(this,R.layout.custom_item_list_student,ListStudent);
        listViewStudent.setAdapter(studentAdapter);

        studentAdapter.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                textStudentQuantity.setText(String.valueOf(studentAdapter.getListStudent().size()));

            }
        });
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}