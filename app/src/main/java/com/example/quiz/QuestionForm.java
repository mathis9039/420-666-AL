package com.example.quiz;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

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

public class QuestionForm extends AppCompatActivity {

    private EditText question;
    private EditText reponse;
    private Button ajoutQuestion;
    private String strQuestion, strReponse;
    private Dialog loadingDialog;
    private final List<EditText> options = new ArrayList<>();
    public final List<String> strOptions = new ArrayList<>();
    private final FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_form);

        question = findViewById(R.id.question);
        options.add(findViewById(R.id.option1));
        options.add(findViewById(R.id.option2));
        options.add(findViewById(R.id.option3));
        options.add(findViewById(R.id.option4));
        reponse = findViewById(R.id.answer);
        ajoutQuestion = findViewById(R.id.addQuestionBtn);

        loadingDialog = new Dialog(QuestionForm.this);
        loadingDialog.setCancelable(false);

        ajoutQuestion.setOnClickListener(view -> {
            strOptions.clear();

            strQuestion = question.getText().toString();
            if (strQuestion.isEmpty()) {
                question.setError("Écrivez une question");
                return;
            }

            strReponse = reponse.getText().toString();
            if (strReponse.isEmpty()) {
                reponse.setError("Écrivez la réponse");
                return;
            }

            for (EditText option : options) {
                String str = option.getText().toString();
                if (str.isEmpty()) {
                    option.setError("Écrivez une proposition");
                    return;
                }
                strOptions.add(str);
            }
            Question2 question2 = new Question2(strQuestion, strOptions, strReponse);

            DatabaseReference reference = database.getReference("custom");
            reference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    long childrenCount = snapshot.getChildrenCount();
                    reference.child("" + childrenCount).setValue(question2);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        });

        final ImageView backBtn = findViewById(R.id.retourBtn);

        backBtn.setOnClickListener(view -> {
            startActivity(new Intent(QuestionForm.this, MainActivity.class));
            finish();
        });
    }
}

