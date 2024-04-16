package com.example.finallayout.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.finallayout.Class.MyClass;
import com.example.finallayout.DAO.ClassDAO;
import com.example.finallayout.Fragment.HomeFragment;
import com.example.finallayout.R;

public class CreateActivity extends AppCompatActivity {

    EditText cr_className, cr_classID, cr_classSign;
    Spinner spn_major, spn_base, spn_lesson;
    Button cr_btnSuccess;

    ClassDAO classDAO;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        addControls();
        setSpinner();
        addEvents();
        setToolbar();
    }

    private void setToolbar() {
        ImageView imgBack = findViewById(R.id.imgBack);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void addEvents() {
        cr_btnSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyClass myClass = new MyClass();
                myClass.setName(cr_className.getText().toString());
                myClass.setId(cr_classID.getText().toString());
                myClass.setSign(cr_classSign.getText().toString());
                myClass.setMajor(spn_major.getSelectedItem().toString());
                myClass.setLesson(spn_lesson.getSelectedItem().toString());
                myClass.setBase(spn_base.getSelectedItem().toString());
                myClass.setTeacher(null);

                ClassDAO classDAO1 = new ClassDAO(CreateActivity.this);
                long kq = classDAO1.CreateClass(myClass);
                if (kq <= 0)
                    Toast.makeText(CreateActivity.this, "Tạo lớp học phần thất bại", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(CreateActivity.this, "Tạo lớp học phần thành công", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setSpinner() {
        String[] items = new String[]{"Công nghệ thông tin", "Luật", "Lý luận chính trị"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spn_major.setAdapter(adapter);

        String[] items2 = new String[]{"1-3", "4-6", "7-9","10-12","13-15"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items2);
        spn_lesson.setAdapter(adapter2);

        String[] items3 = new String[]{"Sư Vạn Hạnh", "Hóc Môn", "Cao Thắng", "Trường Sơn", "Thất Sơn"};
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items3);
        spn_base.setAdapter(adapter3);
    }

    private void addControls() {
        cr_className = findViewById(R.id.cr_className);
        cr_classID = findViewById(R.id.cr_classID);
        cr_classSign = findViewById(R.id.cr_classSign);
        spn_major = findViewById(R.id.spn_major);
        spn_lesson = findViewById(R.id.spn_lesson);
        spn_base = findViewById(R.id.spn_base);
        cr_btnSuccess = findViewById(R.id.cr_btnSuccess);
    }
}