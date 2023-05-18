package com.example.se114n21buoi7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listViewClass;
    ArrayList<Class> ListClass;
    ClassDAO classDAO;
    ClassAdapter classAdapter;

    @Override
    protected void onResume() {
        super.onResume();
        ListClass = classDAO.AllClass();
        classAdapter = new ClassAdapter(this,R.layout.custom_item_list_class,ListClass);
        listViewClass.setAdapter(classAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewClass = findViewById(R.id.listViewClass);
        classDAO = new ClassDAO(MainActivity.this);

        listViewClass.setOnItemClickListener((adapterView, view, i, l) -> {
            Class item = ListClass.get(i);
            Intent intent = new Intent(getApplicationContext(),sub_activity.class);
            intent.putExtra("data",item);
            startActivity(intent);
        });

    }
}