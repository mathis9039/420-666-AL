package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private String sujetChoisi = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout java = findViewById(R.id.javaLayout);
        final LinearLayout unity = findViewById(R.id.unityLayout);
        final LinearLayout html = findViewById(R.id.htmlLayout);
        final LinearLayout react =  findViewById(R.id.reactLayout);


        final Button startBtn = findViewById (R.id.quizStartBtn);


        java.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sujetChoisi = "java";
                java.setBackgroundResource(R.drawable.round_back_white_stroke10);

                react.setBackgroundResource(R.drawable.round_back_white10);
                unity.setBackgroundResource(R.drawable.round_back_white10);
                html.setBackgroundResource(R.drawable.round_back_white10);
            }
        });

        react.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sujetChoisi = "react";
                react.setBackgroundResource(R.drawable.round_back_white_stroke10);

                java.setBackgroundResource(R.drawable.round_back_white10);
                unity.setBackgroundResource(R.drawable.round_back_white10);
                html.setBackgroundResource(R.drawable.round_back_white10);
            }
        });

        unity.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sujetChoisi = "unity";
                unity.setBackgroundResource(R.drawable.round_back_white_stroke10);

                react.setBackgroundResource(R.drawable.round_back_white10);
                java.setBackgroundResource(R.drawable.round_back_white10);
                html.setBackgroundResource(R.drawable.round_back_white10);
            }
        });

        html.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sujetChoisi = "html";
                html.setBackgroundResource(R.drawable.round_back_white_stroke10);

                react.setBackgroundResource(R.drawable.round_back_white10);
                unity.setBackgroundResource(R.drawable.round_back_white10);
                java.setBackgroundResource(R.drawable.round_back_white10);
            }
        });
    }
}