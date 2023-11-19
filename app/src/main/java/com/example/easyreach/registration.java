package com.example.easyreach;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class registration extends AppCompatActivity {
    //Variables
    TextInputLayout regName, regUsername, regEmail, regPhoneNo, regPassword;
    Button regBtn, regToLoginBtn;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        //Hooks to all xml elements in activity_sign_up.xml
        regName = findViewById(R.id.name);
        regUsername = findViewById(R.id.username);
        regPhoneNo = findViewById(R.id.phoneno);
        regEmail = findViewById(R.id.email);
        regPassword = findViewById(R.id.password);
        regBtn = findViewById(R.id.regBtn);
        regToLoginBtn = findViewById(R.id.regToLoginBtn);
        //Save data in FireBase on button click
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");

                // Get all the values
                final String name = regName.getEditText().getText().toString();
                final String username = regUsername.getEditText().getText().toString();
                final String phoneNo = regPhoneNo.getEditText().getText().toString();
                final String email = regEmail.getEditText().getText().toString();
                final String password = regPassword.getEditText().getText().toString();

                // Check if phone number or username already exists
                reference.child(phoneNo).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {

                            Toast.makeText(registration.this, "Phone number already exists", Toast.LENGTH_SHORT).show();
                        } else {
                            // Check if username already exists
                            reference.orderByChild("username").equalTo(username).addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    if (dataSnapshot.exists()) {

                                        Toast.makeText(registration.this, "Username already exists", Toast.LENGTH_LONG).show();
                                    } else {

                                        UserHelperClass helperClass = new UserHelperClass(name, username, phoneNo, email, password);
                                        reference.child(phoneNo).setValue(helperClass);


                                        Toast.makeText(registration.this, "Registration successful", Toast.LENGTH_LONG).show();


                                        Intent intent = new Intent(registration.this, Login.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        regToLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(registration.this, Login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
