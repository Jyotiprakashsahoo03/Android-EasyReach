package com.example.easyreach;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class second extends AppCompatActivity {
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView tvResult = findViewById(R.id.tvResult);

        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                        Intent intent = new Intent(second.this, Home.class);
                        startActivity(intent);
                        finish();

            }
        });

        // Get the extra text from the intent
        String resultText = getIntent().getStringExtra(Intent.EXTRA_TEXT);

        // Display the result text in the TextView
        if (resultText != null) {
            tvResult.setText(resultText);
        }

    }
}