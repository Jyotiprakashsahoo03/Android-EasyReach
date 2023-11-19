package com.example.easyreach;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

public class repairs extends AppCompatActivity {

    CheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7;
    Button Order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repairs);
        cb1 = findViewById(R.id.rc1);
        cb2 = findViewById(R.id.rc2);
        cb3 = findViewById(R.id.rc3);
        cb4 = findViewById(R.id.rc4);
        cb5 = findViewById(R.id.rc5);
        cb6 = findViewById(R.id.rc6);
        cb7 = findViewById(R.id.rc7);

        Order= findViewById(R.id.order1);

        Order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int TotalAmount = 0;
                StringBuilder result = new StringBuilder();
                result.append("Selected items\n");

                if (cb1.isChecked()) {
                    result.append("\n Home Appliances 250rs");
                    TotalAmount += 250;
                }
                if (cb2.isChecked()) {
                    result.append("\n Plumbing Repairs 100rs");
                    TotalAmount += 100;
                }
                if (cb3.isChecked()) {
                    result.append("\n Home improvement 200rs");
                    TotalAmount += 200;
                }
                if (cb4.isChecked()) {
                    result.append("\n Automative Repairs 499rs");
                    TotalAmount += 499;
                }
                if (cb5.isChecked()) {
                    result.append("\n jewelery and Watch repairs 350rs");
                    TotalAmount += 350;
                }
                if (cb6.isChecked()) {
                    result.append("\n Fitness Equipment Service 300rs");
                    TotalAmount += 300;
                }
                if (cb7.isChecked()) {
                    result.append("\n Computer repairs 150rs");
                    TotalAmount += 150;
                }


                result.append("\nTotal " + TotalAmount + "rs");

                Intent intent = new Intent(repairs.this, second.class);
                intent.putExtra(Intent.EXTRA_TEXT, result.toString());
                startActivity(intent);
            }
        });
    }
}