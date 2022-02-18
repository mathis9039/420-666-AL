package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.os.Trace;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class QuizActivity extends AppCompatActivity {

    private TextView nbquestion;
    private TextView question;

    private AppCompatButton option1, option2, option3, option4, next;

    private Timer quizTimer;

    private int timeInMinute = 1;
    private int seconds = 0;

    private final List<QuestionList> questionLists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        final ImageView retourBtn = findViewById(R.id.retourBtn);
        final TextView timer = findViewById(R.id.timer);
        final TextView nomSujet = findViewById(R.id.nomSujet);

        nbquestion = findViewById(R.id.nbQuestion);
        question = findViewById(R.id.question);

        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);

        next = findViewById(R.id.nextBtn);
        final String getSujetChoisi = getIntent().getStringExtra("SujetChoisi");

        nomSujet.setText(getSujetChoisi);

        startTimer(timer);
    }

    private void startTimer(TextView timerTextView){
        quizTimer = new Timer();

        quizTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (seconds == 0){
                    timeInMinute--;
                    seconds = 59;
                }else if (seconds == 0 && timeInMinute ==0){
                    quizTimer.purge();
                    quizTimer.cancel();

                    Toast.makeText(QuizActivity.this, "Fin du compteur", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(QuizActivity.this, QuizResult.class);
                    intent.putExtra("correct", getCorrectAnswers());
                    intent.putExtra("Incorrect", getIncorrectAnswers());
                    startActivity(intent);
                    finish();
                }else{
                    seconds--;
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String finalMinute = String.valueOf(timeInMinute);
                        String finalSeconds = String.valueOf(seconds);

                        if (finalMinute.length() == 1){
                            finalMinute = "0" + finalMinute;
                        }

                        if (finalSeconds.length() == 1){
                            finalSeconds = "0" + finalSeconds;
                        }
                        timerTextView.setText(finalMinute + ":" + finalSeconds);
                    }
                });
            }
        }, 1000, 1000);
    }

    private int getCorrectAnswers(){
        int correctAnswers = 0;

        for (int i; i<questionLists.size(); i++){
            final String getUserGuess = questionLists.get(i).getReponseUser();
            final String getAnswer = questionLists.get(i).getAnswer();

            if (getUserGuess.equals(getAnswer)){
                correctAnswers ++;
            }
        }
        return correctAnswers;
    }

    private int getIncorrectAnswers(){
        int incorrectAnswers = 0;

        for (int i; i<questionLists.size(); i++){
            final String getUserGuess = questionLists.get(i).getReponseUser();
            final String getAnswer = questionLists.get(i).getAnswer();

            if (!getUserGuess.equals(getAnswer)){
                incorrectAnswers ++;
            }
        }
        return incorrectAnswers;
    }
}