package com.example.mobilemechanics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MechSignUpActivity extends AppCompatActivity {
    EditText edUsername, edEmail, edPassword, edConfirm;
    Button btn;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mech_sign_up);

        edUsername = findViewById(R.id.editTextUsername);
        edEmail = findViewById(R.id.editTextEmail);
        edPassword = findViewById(R.id.editTextPassword);
        edConfirm = findViewById(R.id.editConfirmPassword);
        btn = findViewById(R.id.sign_up_btn);
        tv = findViewById(R.id.login_back);
    }
    public void sign_in(View v){
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }


    public void check_details(View v){
        String username = edUsername.getText().toString();
        String email = edEmail.getText().toString();
        String password = edPassword.getText().toString();
        String confirm = edConfirm.getText().toString();
        Database db = new Database(getApplicationContext(),"MobileMechanics", null, 1);
        if (username.length() == 0 || email.length() == 0 || password.length() == 0 || confirm.length() == 0){
            Toast.makeText(getApplicationContext(), "Please fill in all details", Toast.LENGTH_SHORT).show();
        }else{
            if(password.compareTo(confirm)==0){
                if(isValid(password)){
                    db.register(username,email,password);
                    Toast.makeText(getApplicationContext(), "Record Inserted!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(this, MechLoginActivity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(getApplicationContext(), "Password must contain at least 8 characters, having letter, digit and a number!", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(getApplicationContext(), "Passwords not similar!", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public static boolean isValid(String passworddhere){
        int f1=0,f2=0,f3=0;
        if(passworddhere.length() < 8){
            return false;
        }else{
            for(int p = 0; p < passworddhere.length(); p++){
                if(Character.isLetter(passworddhere.charAt(p))){
                    f1=1;
                }
            }
            for(int r = 0; r < passworddhere.length(); r++){
                if(Character.isDigit(passworddhere.charAt(r))){
                    f2=1;
                }
            }
            for(int s = 0; s < passworddhere.length(); s++){
                char c = passworddhere.charAt(s);
                if(c>=33&&c<=46 || c==64){
                    f3=1;
                }
            }
            if(f1==1 && f2==1 && f3==1)
                return true;
            return false;

        }
    }
}