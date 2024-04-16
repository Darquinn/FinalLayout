package com.example.finallayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.finallayout.Activity.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginTeacherActivity extends AppCompatActivity {
    private EditText userteacher,passteacher,passtwoteacher;
    private Button btnloginteacher, btnsignupteacher,btnbackother;
    private FirebaseAuth mAuth;
    private boolean isPasswordCorrect = false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginteacher);
        mAuth=FirebaseAuth.getInstance();
        userteacher=findViewById(R.id.UserTeacher);
        passteacher=findViewById(R.id.PassTeacher);
        passtwoteacher=findViewById(R.id.Passwordtwo);
        btnloginteacher=findViewById(R.id.btnLoginTeacher);
        btnsignupteacher=findViewById(R.id.btnSignupTeacher);
        btnbackother=findViewById(R.id.btnbackother);

        btnloginteacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        btnsignupteacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });
        btnbackother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
            }
        });
    }
    private void login() {
        String userdit,passdit,passtwodit;
        userdit=userteacher.getText().toString();
        passdit=passteacher.getText().toString();
        passtwodit=passtwoteacher.getText().toString();
        if(TextUtils.isEmpty(userdit)) {
            Toast.makeText(this,"Vui lòng điền Tên đăng nhập",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(passdit)){
            Toast.makeText(this,"Vui lòng nhập password",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(passtwodit)){
            Toast.makeText(this,"Vui lòng nhập mật khẩu cấp 2",Toast.LENGTH_SHORT).show();
            return;
        }
        if(passtwodit.equals("truonghuflit")){
            isPasswordCorrect=true;
        }else {
            isPasswordCorrect=false;
        }
        if (isPasswordCorrect) {
            mAuth.signInWithEmailAndPassword(userdit, passdit).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginTeacherActivity.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Đăng nhập không thành công", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else {
            Toast.makeText(this, "Mật khẩu cấp 2 không đúng", Toast.LENGTH_SHORT).show();
        }
    }
    private void signup() {
        Intent i = new Intent(LoginTeacherActivity.this, SignupTeacherActivity.class);
        startActivity(i);
    }
    private void back(){
        Intent i =new Intent(LoginTeacherActivity.this, LoginUserActivity.class);
        startActivity(i);
    }

}
