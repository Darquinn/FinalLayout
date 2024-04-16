package com.example.finallayout.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finallayout.Class.MyClass;
import com.example.finallayout.DAO.ClassDAO;
import com.example.finallayout.R;

public class UpdateActivity extends AppCompatActivity {

    EditText up_className, up_classSign;
    TextView up_classID;
    Spinner up_major, up_base, up_lesson;
    Button up_btnSuccess;
    ImageView imgBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        addControls();
        setBundle();
        setSpinner();
        addEvents();
    }

    private void setBundle() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("classInfo");

        up_className.setText(bundle.getString("name").toString());
        up_classSign.setText(bundle.getString("sign").toString());
        up_classID.setText(bundle.getString("id").toString());
    }

    private void setSpinner() {
        String[] items = new String[]{"Công nghệ thông tin", "Luật", "Lý luận chính trị"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(UpdateActivity.this, android.R.layout.simple_spinner_dropdown_item, items);
        up_major.setAdapter(adapter);

        String[] items2 = new String[]{"1-3", "4-6", "7-9","10-12","13-15"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(UpdateActivity.this, android.R.layout.simple_spinner_dropdown_item, items2);
        up_lesson.setAdapter(adapter2);

        String[] items3 = new String[]{"Sư Vạn Hạnh", "Hóc Môn", "Cao Thắng", "Trường Sơn", "Thất Sơn"};
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(UpdateActivity.this, android.R.layout.simple_spinner_dropdown_item, items3);
        up_base.setAdapter(adapter3);
    }

    private void addEvents() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        up_btnSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyClass myClass = new MyClass();
                myClass.setName(up_className.getText().toString());
                myClass.setSign(up_classSign.getText().toString());
                myClass.setId(up_classID.getText().toString());
                myClass.setMajor(up_major.getSelectedItem().toString());
                myClass.setLesson(up_lesson.getSelectedItem().toString());
                myClass.setBase(up_base.getSelectedItem().toString());
                myClass.setTeacher(null);

                ClassDAO classDAO1 = new ClassDAO(UpdateActivity.this);
                long kq = classDAO1.UpdateClass(myClass);
                if (kq <= 0)
                    Toast.makeText(UpdateActivity.this, "Chỉnh sửa lớp học phần thất bại", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(UpdateActivity.this, "Chỉnh sửa lớp học phần thành công", Toast.LENGTH_LONG).show();

                startActivity(new Intent(UpdateActivity.this, MainActivity.class));
            }
        });
    }

    private void addControls() {
        up_className = findViewById(R.id.up_className);
        up_classSign = findViewById(R.id.up_classSign);
        up_classID = findViewById(R.id.up_classID);
        up_major = (Spinner) findViewById(R.id.up_major);
        up_lesson = (Spinner) findViewById(R.id.up_lesson);
        up_base = (Spinner) findViewById(R.id.up_base);
        up_btnSuccess = findViewById(R.id.up_btnSuccess);

        imgBack = findViewById(R.id.imgBack);
    }
}