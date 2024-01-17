package com.example.finallayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

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

    ArrayList<MyClass> myList;
    MyArrayAdapter myAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        myList = new ArrayList<>();
        for (int i =  0; i < name.length; i++){
            myList.add(new MyClass(name[i], id[i], major[i]));
        }
        myAdapter = new MyArrayAdapter(MainActivity.this, R.layout.layout_item, myList);
        listView.setAdapter(myAdapter);


    }
}