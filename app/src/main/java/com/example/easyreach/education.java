package com.example.easyreach;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

public class education extends AppCompatActivity {

    CheckBox ed1, ed2, ed3, ed4, ed5, ed6, ed7, ed8, ed9, ed10, ed11;
    Button Order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);
        ed1=findViewById(R.id.ed1);
        ed2=findViewById(R.id.ed2);
        ed3=findViewById(R.id.ed3);
        ed4=findViewById(R.id.ed4);
        ed5=findViewById(R.id.ed5);
        ed6=findViewById(R.id.ed6);
        ed7=findViewById(R.id.ed7);
        ed8=findViewById(R.id.ed8);
        ed9=findViewById(R.id.ed9);
        ed10=findViewById(R.id.ed10);
        ed11=findViewById(R.id.ed11);

        Order= findViewById(R.id.eduorder);

        Order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int TotalAmount = 0;
                StringBuilder result = new StringBuilder();
                result.append("Selected items\n");

                if (ed1.isChecked()) {
                    result.append("\n Subject Specific Tutor 500rs");
                    TotalAmount += 500;
                }
                if (ed2.isChecked()) {
                    result.append("\n Test Preparation Tutors 350rs");
                    TotalAmount += 350;
                }
                if (ed3.isChecked()) {
                    result.append("\n Skill Development Tutors 2000rs");
                    TotalAmount += 2000;
                }
                if (ed4.isChecked()) {
                    result.append("\n Grade-Level Tutors 499rs");
                    TotalAmount += 499;
                }
                if (ed5.isChecked()) {
                    result.append("\n Specialized Education Tutors 350rs");
                    TotalAmount += 350;
                }
                if (ed6.isChecked()) {
                    result.append("\n College and University Tutors 3000rs");
                    TotalAmount += 3000;
                }
                if (ed7.isChecked()) {
                    result.append("\n Exam Specific Tutors 450rs");
                    TotalAmount += 450;
                }
                if (ed8.isChecked()) {
                    result.append("\n Personal Development Tutors 1500rs");
                    TotalAmount += 1500;
                }
                if (ed9.isChecked()) {
                    result.append("\n Technology and Computer Science Tutor 2999rs");
                    TotalAmount += 2999;
                }
                if (ed10.isChecked()) {
                    result.append("\n Language Tutors 799rs");
                    TotalAmount += 799;
                }
                if (ed11.isChecked()) {
                    result.append("\n Hobby and Recreation Tutors 1000rs");
                    TotalAmount += 1000;
                }


                result.append("\nTotal " + TotalAmount + "rs");

                Intent intent = new Intent(education.this, second.class);
                intent.putExtra(Intent.EXTRA_TEXT, result.toString());
                startActivity(intent);
            }
        });
    }
}