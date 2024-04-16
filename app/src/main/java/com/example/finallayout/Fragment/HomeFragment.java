package com.example.finallayout.Fragment;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.finallayout.Activity.CreateActivity;
import com.example.finallayout.Activity.MainActivity;
import com.example.finallayout.Class.MyClass;
import com.example.finallayout.Adapter.HomeAdapter;
import com.example.finallayout.DAO.ClassDAO;
import com.example.finallayout.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class HomeFragment extends Fragment{

    String[] name = {"Đại cương pháp luật Việt Nam",
            "Tư tưởng Hồ Chí Minh",
            "Lý thuyết đồ thị",
            "Mạng máy tính",
            "Lập trình trên thiết bị di động",
            "Phân tích và thiết kế phần mềm"
    };
    String[] id = {"232101005211",
            "232101009281",
            "232122112307",
            "232122113415",
            "232123038407",
            "232125008402"
    };
    String[] major = {"Luật",
            "Lý luận chính trị",
            "Công nghệ thông tin",
            "Công nghệ thông tin",
            "Công nghệ thông tin",
            "Công nghệ thông tin",
    };
    private MyClass dataClass;
    private List<MyClass> classItemList;
    private ClassDAO classDAO;
    private RecyclerView classRecycleView;
    private HomeAdapter homeAdapter;
    Context context;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        // set Floating Button
        FloatingActionButton fab;
        fab = rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), CreateActivity.class);
                startActivity(myIntent);
            }
        });


        classDAO = new ClassDAO(getActivity());
        classItemList = classDAO.getAllClass();
        classRecycleView = rootView.findViewById(R.id.homeRecycleView);
        classRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        homeAdapter = new HomeAdapter(getActivity(), classItemList);
        classRecycleView.setAdapter(homeAdapter);

        return rootView;
    }

    private List<MyClass> generateHomeItems() {
        List<MyClass> homeItems = new ArrayList<>();
        for (int i = 0; i < name.length; i++) {
            homeItems.add(new MyClass(name[i], id[i], major[i]));
        }
        return homeItems;
    }


}