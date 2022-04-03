package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

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
        final LinearLayout quiz =  findViewById(R.id.quizLayout);
        final LinearLayout admin =  findViewById(R.id.amdinLayout);
        //final LinearLayout admin =  findViewById(R.id.amdinLayout);

        final ImageView backBtn = findViewById(R.id.retourBtn);
        final Button startBtn = findViewById(R.id.quizStartBtn);


        java.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sujetChoisi = "java";
                java.setBackgroundResource(R.drawable.round_back_white_stroke10);

                react.setBackgroundResource(R.drawable.round_back_white10);
                unity.setBackgroundResource(R.drawable.round_back_white10);
                html.setBackgroundResource(R.drawable.round_back_white10);
                quiz.setBackgroundResource(R.drawable.round_back_white10);
                admin.setBackgroundResource(R.drawable.round_back_white10);
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
                quiz.setBackgroundResource(R.drawable.round_back_white10);
                admin.setBackgroundResource(R.drawable.round_back_white10);
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
                quiz.setBackgroundResource(R.drawable.round_back_white10);
                admin.setBackgroundResource(R.drawable.round_back_white10);
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
                quiz.setBackgroundResource(R.drawable.round_back_white10);
                admin.setBackgroundResource(R.drawable.round_back_white10);
            }
        });

        quiz.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sujetChoisi = "quiz";
                quiz.setBackgroundResource(R.drawable.round_back_white_stroke10);

                react.setBackgroundResource(R.drawable.round_back_white10);
                unity.setBackgroundResource(R.drawable.round_back_white10);
                java.setBackgroundResource(R.drawable.round_back_white10);
                html.setBackgroundResource(R.drawable.round_back_white10);
                admin.setBackgroundResource(R.drawable.round_back_white10);
            }
        });

        admin.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(MainActivity.this, QuestionForm.class));
                sujetChoisi = "admin";
                admin.setBackgroundResource(R.drawable.round_back_white_stroke10);

                react.setBackgroundResource(R.drawable.round_back_white10);
                unity.setBackgroundResource(R.drawable.round_back_white10);
                java.setBackgroundResource(R.drawable.round_back_white10);
                html.setBackgroundResource(R.drawable.round_back_white10);
                quiz.setBackgroundResource(R.drawable.round_back_white10);
            }
        });

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sujetChoisi.isEmpty()){
                    Toast.makeText(MainActivity.this, "Choisissez votre sujet", Toast.LENGTH_SHORT).show();
                }
                else if(sujetChoisi == "admin"){
                    Intent intent = new Intent(MainActivity.this, ValidationAdmin.class);
                    //intent.putExtra("SujetChoisi", sujetChoisi);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                    intent.putExtra("SujetChoisi", sujetChoisi);
                    startActivity(intent);
                }
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Login.class));
                finish();
            }
        });
    }
}