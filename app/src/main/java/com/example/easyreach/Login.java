package com.example.easyreach;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    TextInputLayout regEmail, regPassword;
    Button Signupbutton, Loginbutton;
    private FirebaseAuth mAuth;
    //mAuth = FirebaseAuth.getInstance();


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);


        regEmail = findViewById(R.id.email);
        regPassword = findViewById(R.id.password);
        Signupbutton = findViewById(R.id.Signupbutton);
        Loginbutton = findViewById(R.id.Loginbutton);
        mAuth= FirebaseAuth.getInstance();

        Loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Replace "jps@gmail.com" and "jps123" with the actual values you want to check against
                String email = regEmail.getEditText().getText().toString();
                String password = regPassword.getEditText().getText().toString();

                if (email.equals("jps@gmail.com") && password.equals("jps123")) {
                    Toast.makeText(Login.this, "Login successful!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Login.this, Home.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(Login.this, "Invalid username or password!", Toast.LENGTH_LONG).show();
                }
            }
        });



        Signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Login.this, registration.class);
                startActivity(intent);
                finish();
            }
        });
    }
}





