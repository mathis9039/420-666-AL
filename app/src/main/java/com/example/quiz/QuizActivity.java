package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        final ImageView retourBtn = findViewById(R.id.retourBtn);
        final TextView timer = findViewById(R.id.timer);

        final TextView nomSujet = findViewById(R.id.nomSujet);
        final String getSujetChoisi = getIntent().getStringExtra("SujetChoisi");

        nomSujet.setText(getSujetChoisi);
    }
}