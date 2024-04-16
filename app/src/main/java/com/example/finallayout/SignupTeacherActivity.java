package com.example.finallayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupTeacherActivity extends AppCompatActivity {
    Button btnSignupTeacher, btnBackTeacher;
    private FirebaseAuth mAuth;
    private EditText userteacher, passteacher, confirmteacher, passtwoteacher;
    ;
    private boolean isPasswordCorrect = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signupteacher);
        mAuth = FirebaseAuth.getInstance();
        userteacher = findViewById(R.id.UserTeacher);
        passteacher = findViewById(R.id.PassTeacher);
        confirmteacher = findViewById(R.id.ConfirmTeacher);
        btnSignupTeacher = findViewById(R.id.btnSignupTeacher);
        btnBackTeacher = findViewById(R.id.btnBackTeacher);
        passtwoteacher = findViewById(R.id.Passwordtwo);
        addEvents();
    }

    private void addEvents() {
        btnBackTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(SignupTeacherActivity.this, LoginTeacherActivity.class);
                startActivity(myIntent);
                finish();
            }
        });

        btnSignupTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });
    }

    private void signup() {
        String userdit, passdit, confirmdit, passtwodit;
        userdit = userteacher.getText().toString();
        passdit = passteacher.getText().toString();
        confirmdit = confirmteacher.getText().toString();
        passtwodit = passtwoteacher.getText().toString();

        if (TextUtils.isEmpty(userdit)) {
            Toast.makeText(this, "Vui lòng điền Tên Đăng Nhập", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(passdit)) {
            Toast.makeText(this, "Vui lòng điền mật khẩu", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(confirmdit)) {
            Toast.makeText(this, "Vui lòng nhập lại mật khẩu", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(passtwodit)) {
            Toast.makeText(this, "Vui lòng nhập mật khẩu cấp 2", Toast.LENGTH_SHORT).show();
            return;
        }
        if (passtwodit.equals("truonghuflit")) {
            isPasswordCorrect = true;
        } else {
            isPasswordCorrect = false;
        }
        if (isPasswordCorrect) {
            mAuth.createUserWithEmailAndPassword(userdit, passdit).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "Đăng kí thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignupTeacherActivity.this, LoginTeacherActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Đăng kí không thành công", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else {
            Toast.makeText(this, "Mật khẩu cấp 2 không đúng", Toast.LENGTH_SHORT).show();
        }
    }
}

