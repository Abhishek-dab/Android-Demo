package com.example.emailpasswordauthentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
EditText et_login_email, et_login_pass;
FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_login_email= findViewById(R.id.login_user);
        et_login_pass = findViewById(R.id.login_pass);
        mAuth = FirebaseAuth.getInstance();
    }

    public void login(View view) {
        String usermail = et_login_email.getText().toString();
        String password = et_login_pass.getText().toString();

        mAuth.signInWithEmailAndPassword(usermail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void openforget(View view) {
        Intent i = new Intent(this, ForgetPasswordActivity.class);
        startActivity(i);
    }

    public void openregister(View view) {
        Intent i = new Intent(this,RegisterActivity.class);
        startActivity(i);
    }
}