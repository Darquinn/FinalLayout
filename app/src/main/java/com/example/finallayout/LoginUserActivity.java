package com.example.finallayout;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.finallayout.Activity.LoginActivity;

public class LoginUserActivity extends AppCompatActivity {

    private Button btnLoginTeacher,btnSignupStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phanquyenuser);

        btnLoginTeacher = findViewById(R.id.btnLoginTeacher);
        btnSignupStudent=findViewById(R.id.btnSignupStudent);
        btnLoginTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginUserActivity.this, LoginTeacherActivity.class);
                startActivity(intent);
            }
        });
        btnSignupStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginUserActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}