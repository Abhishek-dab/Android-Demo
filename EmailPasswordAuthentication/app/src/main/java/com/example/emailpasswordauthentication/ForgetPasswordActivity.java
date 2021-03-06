package com.example.emailpasswordauthentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPasswordActivity extends AppCompatActivity {
EditText et_forget_mail;
FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        et_forget_mail = findViewById(R.id.forget_mailid);
        mAuth = FirebaseAuth.getInstance();

    }

    public void resetpass(View view) {
String emailid = et_forget_mail.getText().toString();
mAuth.sendPasswordResetEmail(emailid).addOnCompleteListener(new OnCompleteListener<Void>() {
    @Override
    public void onComplete(@NonNull Task<Void> task) {
        if(task.isSuccessful()){
            Toast.makeText(ForgetPasswordActivity.this, "Password reset link has been sent to your email", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(ForgetPasswordActivity.this, "Incorrect Mailid !! LOL.", Toast.LENGTH_SHORT).show();
        }
    }
});
    }
}