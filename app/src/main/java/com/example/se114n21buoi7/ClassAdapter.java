package com.example.se114n21buoi7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class ClassAdapter extends ArrayAdapter<Class> {
    private int resource;
    private ArrayList<Class> ListClass;
    public ClassAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Class> objects) {
        super(context, resource, objects);
        this.resource = resource;
        this.ListClass = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        ViewHolder viewHolder;
        if (v == null){
            v= LayoutInflater.from(getContext()).inflate(this.resource,null);
            viewHolder = new ViewHolder();
            viewHolder.textViewSTT = v.findViewById(R.id.textViewSTT);
            viewHolder.textViewClassId = v. findViewById(R.id.textViewClassId);
            viewHolder.textViewClassName = v.findViewById(R.id.textViewClassName);
            viewHolder.textStudentQuantity = v.findViewById(R.id.textStudentQuantity);
            v.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) v.getTag();
        }
        com.example.se114n21buoi7.Class s = getItem(position);
        if (s!=null){
            viewHolder.textViewSTT.setText(String.valueOf(position+1));
            viewHolder.textViewClassName.setText(s.getName());
            viewHolder.textViewClassId.setText(s.getId());
            viewHolder.textStudentQuantity.setText(String.valueOf(s.getStudents()));
        }
        return v;
    }

    private class ViewHolder{
        TextView textViewClassId,textViewSTT, textViewClassName,textStudentQuantity;
    }
}
