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

public class RegisterActivity extends AppCompatActivity {
EditText et_reg_email, et_reg_pass;
FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        et_reg_email = findViewById(R.id.reg_mailid);
        et_reg_pass=findViewById(R.id.reg_pass);
        mAuth = FirebaseAuth.getInstance();


    }

    public void register(View view) {
        String usermail = et_reg_email.getText().toString();
        String userpass = et_reg_pass.getText().toString();

        if(usermail.isEmpty()|| userpass.isEmpty()){
            Toast.makeText(this, "Empty!! Enter all Details", Toast.LENGTH_SHORT).show();
        }else{
            mAuth .createUserWithEmailAndPassword(usermail,userpass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(RegisterActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(RegisterActivity.this, MainActivity.class);
                        startActivity(i);
                    }
                }
            });

        }

    }

    public void openlogin(View view) {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}