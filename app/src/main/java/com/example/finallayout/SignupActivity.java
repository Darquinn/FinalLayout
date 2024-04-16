package com.example.finallayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finallayout.Activity.LoginActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {

    Button btnSignup, btnBack;
    private FirebaseAuth mAuth;
    private EditText useredit,passedit,confirmedit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth=FirebaseAuth.getInstance();
        useredit=findViewById(R.id.edtUsername);
        passedit=findViewById(R.id.edtPassword);
        confirmedit=findViewById(R.id.edtConfirm);
        btnSignup=findViewById(R.id.btnSignup);
        btnBack = findViewById(R.id.btnBack);
        addEvents();
    }

    private void addEvents() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(myIntent);
                finish();
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });
    }
    private void signup() {
        String user,pass,confirm;
        user=useredit.getText().toString();
        pass=passedit.getText().toString();
        confirm=confirmedit.getText().toString();
        mAuth.createUserWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Tạo tài khoản thành công",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(SignupActivity.this,LoginActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(),"Tạo tài khoản không thành công",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}