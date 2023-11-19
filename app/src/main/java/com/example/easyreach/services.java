package com.example.easyreach;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

public class services extends AppCompatActivity {
    CheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8, cb9;
    Button Order;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);
        cb4 = findViewById(R.id.cb4);
        cb5 = findViewById(R.id.cb5);
        cb6 = findViewById(R.id.cb6);
        cb7 = findViewById(R.id.cb7);
        cb8 = findViewById(R.id.cb8);
        cb9 = findViewById(R.id.cb9);
        Order = findViewById(R.id.Order);

        Order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int TotalAmount = 0;
                StringBuilder result = new StringBuilder();
                result.append("Selected items\n");

                if (cb1.isChecked()) {
                    result.append("\n Food Delivery 85rs");
                    TotalAmount += 85;
                }
                if (cb2.isChecked()) {
                    result.append("\n Grocery Delivery 100rs");
                    TotalAmount += 100;
                }
                if (cb3.isChecked()) {
                    result.append("\n Package & Parcel Delivery 75rs");
                    TotalAmount += 75;
                }
                if (cb4.isChecked()) {
                    result.append("\n Pharmacy Delivery 55rs");
                    TotalAmount += 55;
                }
                if (cb5.isChecked()) {
                    result.append("\n Flower Delivery 50rs");
                    TotalAmount += 50;
                }
                if (cb6.isChecked()) {
                    result.append("\n Retail & merchandise 300rs");
                    TotalAmount += 300;
                }
                if (cb7.isChecked()) {
                    result.append("\n pet Supplies Delivery 150rs");
                    TotalAmount += 150;
                }
                if (cb8.isChecked()) {
                    result.append("\n Beauty & wellness 99rs");
                    TotalAmount += 99;
                }
                if (cb9.isChecked()) {
                    result.append("\n Technology & gadget 250rs");
                    TotalAmount += 250;
                }

                result.append("\nTotal " + TotalAmount + "rs");

                Intent intent = new Intent(services.this, second.class);
                intent.putExtra(Intent.EXTRA_TEXT, result.toString());
                startActivity(intent);
            }
        });
    }
}