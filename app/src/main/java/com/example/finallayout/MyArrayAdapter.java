package com.example.finallayout;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<MyClass>{
    Activity context;
    int idLayout;
    ArrayList<MyClass> myList;

    public MyArrayAdapter(Activity context, int idLayout, ArrayList<MyClass> myList) {
        super(context, idLayout, myList);
        this.context = context;
        this.idLayout = idLayout;
        this.myList = myList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater myFlater = context.getLayoutInflater();
        convertView = myFlater.inflate(idLayout, null);
        MyClass myClass = myList.get(position);

        TextView className = convertView.findViewById(R.id.txt_className);
        className.setText(myClass.getName());
        TextView classID = convertView.findViewById(R.id.txt_classID);
        classID.setText(myClass.getId());
        TextView classMajor = convertView.findViewById(R.id.txt_classMajor);
        classMajor.setText(myClass.getMajor());

        return convertView;
    }
}
