package com.example.se114n21buoi7;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.se114n21buoi7.R;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends ArrayAdapter<Student> {

    private int resource;
    private ArrayList<Student> ListStudent;

    public ArrayList<Student> getListStudent() {
        return ListStudent;
    }

    public StudentAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Student> objects) {
        super(context, resource, objects);
        this.resource = resource;
        this.ListStudent = objects;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        ViewHolder viewHolder;
        if (v == null){
            v= LayoutInflater.from(getContext()).inflate(this.resource,null);
            viewHolder = new ViewHolder();
            viewHolder.textViewStudentId = v. findViewById(R.id.textViewStudentId);
            viewHolder.textViewStudentName = v.findViewById(R.id.textViewStudentName);
            viewHolder.textViewStudentDob = v.findViewById(R.id.textViewStudentDob);
            viewHolder.buttonRemove = v.findViewById(R.id.buttonRemove);
            v.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) v.getTag();
        }
        Student s = getItem(position);
        if (s!=null){
            viewHolder.textViewStudentId.setText(s.getId());
            viewHolder.textViewStudentName.setText(s.getName());
            viewHolder.textViewStudentDob.setText(s.getDob());
            View v2 = v;
            StudentAdapter t = this;
            viewHolder.buttonRemove.setOnClickListener(view -> {
                StudentDAO studentDAO = new StudentDAO(v2.getContext());
                studentDAO.Remove(s.getId());
                ListStudent.remove(s);
                Toast.makeText(getContext(), "Đã xóa sinh viên!", Toast.LENGTH_SHORT).show();
                t.notifyDataSetChanged();
            });
        }
        return v;
    }
    private class ViewHolder{
        TextView textViewStudentId,textViewStudentName,textViewStudentDob;
        ImageButton buttonRemove;
    }
}
