package com.example.mobilemechanics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class UserActivity extends AppCompatActivity {
    EditText pass, user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        user = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.password);
     }
     public void loginBtn(View view){
        String User = user.getText().toString();
        String Pass = pass.getText().toString();

        background bg = new background(this);
        bg.execute(User, Pass);
     }
}