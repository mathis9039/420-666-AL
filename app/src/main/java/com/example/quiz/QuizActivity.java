package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Trace;
import android.view.View;
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

    private AppCompatButton option1, option2, option3, option4, nextBtn;

    private Timer quizTimer;

    private int timeInMinute = 2;
    private int seconds = 0;

    private  List<QuestionList> questionLists;

    private int currentQuestion = 0;

    private String optionChoisi = "";

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

        nextBtn = findViewById(R.id.nextBtn);
        final String getSujetChoisi = getIntent().getStringExtra("SujetChoisi");

        nomSujet.setText(getSujetChoisi);

        questionLists = Questions.getQuestions(getSujetChoisi);

        startTimer(timer);

        nbquestion.setText((currentQuestion + 1) + "/" + questionLists.size());
        question.setText(questionLists.get(0).getQuestion());
        option1.setText(questionLists.get(0).getOption1());
        option2.setText(questionLists.get(0).getOption2());
        option3.setText(questionLists.get(0).getOption3());
        option4.setText(questionLists.get(0).getOption4());

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (optionChoisi.isEmpty()){
                    optionChoisi = option1.getText().toString();
                    option1.setBackgroundResource(R.drawable.round_back_red);
                    option1.setTextColor(Color.WHITE);
                    answerReveal();
                    questionLists.get(currentQuestion).setReponseUser(optionChoisi);
                }
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (optionChoisi.isEmpty()){
                    optionChoisi = option2.getText().toString();
                    option2.setBackgroundResource(R.drawable.round_back_red);
                    option2.setTextColor(Color.WHITE);
                    answerReveal();
                    questionLists.get(currentQuestion).setReponseUser(optionChoisi);
                }
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (optionChoisi.isEmpty()){
                    optionChoisi = option3.getText().toString();
                    option3.setBackgroundResource(R.drawable.round_back_red);
                    option3.setTextColor(Color.WHITE);
                    answerReveal();
                    questionLists.get(currentQuestion).setReponseUser(optionChoisi);
                }
            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (optionChoisi.isEmpty()){
                    optionChoisi = option4.getText().toString();
                    option4.setBackgroundResource(R.drawable.round_back_red);
                    option4.setTextColor(Color.WHITE);
                    answerReveal();
                    questionLists.get(currentQuestion).setReponseUser(optionChoisi);
                }
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (optionChoisi.isEmpty()){
                    Toast.makeText(QuizActivity.this, "Veuillez chosir une réponse", Toast.LENGTH_SHORT).show();
                }else{
                    nextQuestion();
                }
            }
        });

        retourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quizTimer.purge();
                quizTimer.cancel();

                startActivity(new Intent(QuizActivity.this, MainActivity.class));
                finish();
            }
        });
    }

    private void nextQuestion(){
        currentQuestion++;

        if ((currentQuestion + 1) == questionLists.size()){
            nextBtn.setText("Envoyer");
        }

        if (currentQuestion < questionLists.size()){
            optionChoisi = "";

            option1.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            option1.setTextColor(Color.parseColor("#1F6BB8"));

            option2.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            option2.setTextColor(Color.parseColor("#1F6BB8"));

            option3.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            option3.setTextColor(Color.parseColor("#1F6BB8"));

            option4.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            option4.setTextColor(Color.parseColor("#1F6BB8"));

            nbquestion.setText((currentQuestion + 1) + "/" + questionLists.size());
            question.setText(questionLists.get(currentQuestion).getQuestion());
            option1.setText(questionLists.get(currentQuestion).getOption1());
            option2.setText(questionLists.get(currentQuestion).getOption2());
            option3.setText(questionLists.get(currentQuestion).getOption3());
            option4.setText(questionLists.get(currentQuestion).getOption4());
        }else{
            Intent intent = new Intent(QuizActivity.this, QuizResult.class);
            intent.putExtra("Correct", getCorrectAnswers());
            intent.putExtra("Incorrect", getIncorrectAnswers());
            startActivity(intent);

            finish();
        }
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

        for (int i = 0; i < questionLists.size(); i++){
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

        for (int i = 0; i < questionLists.size(); i++){
            final String getUserGuess = questionLists.get(i).getReponseUser();
            final String getAnswer = questionLists.get(i).getAnswer();

            if (!getUserGuess.equals(getAnswer)){
                incorrectAnswers ++;
            }
        }
        return incorrectAnswers;
    }

    @Override
    public void onBackPressed(){
        quizTimer.purge();
        quizTimer.cancel();

        startActivity(new Intent(QuizActivity.this, MainActivity.class));
        finish();
    }

    private void answerReveal(){
        final String getAnswer = questionLists.get(currentQuestion).getAnswer();

        if (option1.getText().toString().equals(getAnswer)){
            option1.setBackgroundResource(R.drawable.round_back_green);
            option1.setTextColor(Color.WHITE);
        }else if (option2.getText().toString().equals(getAnswer)){
            option2.setBackgroundResource(R.drawable.round_back_green);
            option2.setTextColor(Color.WHITE);
        }else if (option3.getText().toString().equals(getAnswer)){
            option3.setBackgroundResource(R.drawable.round_back_green);
            option3.setTextColor(Color.WHITE);
        }else if (option4.getText().toString().equals(getAnswer)){
            option4.setBackgroundResource(R.drawable.round_back_green);
            option4.setTextColor(Color.WHITE);
        }
    }
}