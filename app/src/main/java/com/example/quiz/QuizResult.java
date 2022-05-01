package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class QuizResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        final AppCompatButton acceuilBtn = findViewById(R.id.acceuilBtn);
        final TextView correctAnswer = findViewById(R.id.correctAnswer);
        final TextView incorrectAnswer = findViewById(R.id.incorrectAnswer);

        final int getCorrectAnswer = getIntent().getIntExtra("Correct", 0);
        final int getIncorrectAnswer = getIntent().getIntExtra("Incorrect", 0);

        String bonneRep = String.valueOf(getCorrectAnswer);
        correctAnswer.setText("Bonne réponse: " + bonneRep);

        String badRep = String.valueOf(getIncorrectAnswer);
        incorrectAnswer.setText("Mauvaise réponse: " + badRep);

        acceuilBtn.setOnClickListener(view -> {
            startActivity(new Intent(QuizResult.this, MainActivity.class));
            finish();
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(QuizResult.this, MainActivity.class));
        finish();
    }
}