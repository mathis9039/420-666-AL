package com.example.quiz;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class QuizActivity extends AppCompatActivity {

    private TextView nbquestion;
    private TextView question;

    private final List<AppCompatButton> options = new ArrayList<>();
    private AppCompatButton nextBtn;

    private Timer quizTimer;

    private int timeInMinute = 2;
    private int seconds = 0;

    private final List<Question2> quests = new ArrayList<>();

    private int currentQuestion = 0;

    private boolean played = false;

    private final FirebaseDatabase database = FirebaseDatabase.getInstance();
    private int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        final ImageView retourBtn = findViewById(R.id.retourBtn);
        final TextView timer = findViewById(R.id.timer);
        final TextView nomSujet = findViewById(R.id.nomSujet);

        nbquestion = findViewById(R.id.nbQuestion);
        question = findViewById(R.id.question);

        options.add(findViewById(R.id.option1));
        options.add(findViewById(R.id.option2));
        options.add(findViewById(R.id.option3));
        options.add(findViewById(R.id.option4));

        for (AppCompatButton option : options) {
            option.setOnClickListener(view -> {
                String optionChoisi = option.getText().toString();
                option.setBackgroundResource(R.drawable.round_back_red);
                option.setTextColor(Color.WHITE);
                Question2 question2 = quests.get(currentQuestion);
                String answer = question2.getAnswer();
                if (optionChoisi.equals(answer)) {
                    points++;
                }
                played = true;
                answerReveal();
            });
        }

        nextBtn = findViewById(R.id.nextBtn);

        final String getSujetChoisi = getIntent().getStringExtra("SujetChoisi");
        getData(getSujetChoisi);

        nomSujet.setText(getSujetChoisi);

        startTimer(timer);

        nextBtn.setOnClickListener(view -> {
            if (played){
                nextQuestion();
            }else{
                Toast.makeText(QuizActivity.this, "Veuillez chosir une réponse", Toast.LENGTH_SHORT).show();
            }
        });

        retourBtn.setOnClickListener(view -> {
            quizTimer.purge();
            quizTimer.cancel();

            finish();
        });
    }

    private void nextQuestion() {
        currentQuestion++;
        if (currentQuestion < quests.size()) {
            for (AppCompatButton option : options) {
                option.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
                option.setTextColor(Color.parseColor("#1F6BB8"));
            }
            setQuest();
        } else {
            Intent intent = new Intent(QuizActivity.this, QuizResult.class);
            intent.putExtra("Correct", points);
            intent.putExtra("Incorrect", quests.size() - points);
            startActivity(intent);

            finish();
        }
    }

    private void startTimer(TextView timerTextView) {
        quizTimer = new Timer();

        quizTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (seconds == 0) {
                    timeInMinute--;
                    seconds = 59;
                } else if (seconds == 0 && timeInMinute == 0) {
                    quizTimer.purge();
                    quizTimer.cancel();

                    Toast.makeText(QuizActivity.this, "Fin du compteur", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(QuizActivity.this, QuizResult.class);
                    intent.putExtra("Correct", points);
                    intent.putExtra("Incorrect", quests.size() - points);
                    startActivity(intent);
                    finish();
                } else {
                    seconds--;
                }

                runOnUiThread(() -> {
                    String finalMinute = String.valueOf(timeInMinute);
                    String finalSeconds = String.valueOf(seconds);

                    if (finalMinute.length() == 1) {
                        finalMinute = "0" + finalMinute;
                    }

                    if (finalSeconds.length() == 1) {
                        finalSeconds = "0" + finalSeconds;
                    }
                    timerTextView.setText(finalMinute + ":" + finalSeconds);
                });
            }
        }, 1000, 1000);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    private void answerReveal() {
        final String getAnswer = quests.get(currentQuestion).getAnswer();

        for (AppCompatButton option: options) {
            if (option.getText().toString().equals(getAnswer)){
                option.setBackgroundResource(R.drawable.round_back_green);
                option.setTextColor(Color.WHITE);
            }
        }
    }

    private void getData(String getSujetChoisi) {
        DatabaseReference reference = database.getReference(getSujetChoisi);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.d("nani", "nanichange");
                for (DataSnapshot snap : snapshot.getChildren()) {
                    Question2 value = snap.getValue(Question2.class);
                    quests.add(value);
                }

                if (quests.isEmpty()){
                    Toast.makeText(QuizActivity.this, "La liste de question est vide", Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    setQuest();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void setQuest() {
        Question2 quest = quests.get(currentQuestion);
        nbquestion.setText((currentQuestion + 1) + "/" + quests.size());
        question.setText(quest.getQuestion());
        for (int i = 0; i < options.size(); i++) {
            AppCompatButton option = options.get(i);
            option.setText(quest.getOption(i));
        }
    }
}

