package com.example.finallayout.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finallayout.Activity.ClassActivity;
import com.example.finallayout.Class.MyClass;
import com.example.finallayout.R;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
    private List<MyClass> classItemList;
    private Context context;

    public HomeAdapter(Context context, List<MyClass> classItemList) {
        this.context = context;
        this.classItemList = classItemList;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        return new HomeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        MyClass classItem = classItemList.get(position);
        holder.name.setText(classItem.getName());
        holder.id.setText(classItem.getId());
        holder.major.setText(classItem.getMajor());

        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickGoToDetail(classItem);
            }
        });
    }

    private void onClickGoToDetail(MyClass classItem){
        Intent intent = new Intent(context, ClassActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object class", classItem);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return classItemList.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder{
        TextView name,id,major;
        LinearLayout layoutItem;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txt_className);
            id = itemView.findViewById(R.id.txt_classID);
            major = itemView.findViewById(R.id.txt_classMajor);
            layoutItem = itemView.findViewById((R.id.layoutItem));

        }
    }

}
