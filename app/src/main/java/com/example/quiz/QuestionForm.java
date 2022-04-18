package com.example.quiz;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.ArrayMap;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QuestionForm extends AppCompatActivity {

    private EditText question, option1, option2, option3, option4, reponse;
    private Button ajoutQuestion;
    private String strQuestion, strOption1, strOption2, strOption3, strOption4, strReponse;
    private Dialog loadingDialog;
    private FirebaseFirestore firestore;
    public static List<QuestionList> questionLists = new ArrayList<QuestionList>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_form);

        question = findViewById(R.id.question);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        reponse = findViewById(R.id.answer);
        ajoutQuestion = findViewById(R.id.addQuestionBtn);

        loadingDialog = new Dialog(QuestionForm.this);
        //loadingDialog.setContentView(R.layout.loading_progressbar);
        loadingDialog.setCancelable(false);
        //loadingDialog.getWindow().setBackgroundDrawableResource(R.drawable.progress_background);
        //loadingDialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);

        firestore = FirebaseFirestore.getInstance();

        ajoutQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                strQuestion = question.getText().toString();
                strOption1 = option1.getText().toString();
                strOption2 = option2.getText().toString();
                strOption3 = option3.getText().toString();
                strOption4 = option4.getText().toString();
                strReponse = reponse.getText().toString();



                if (strQuestion.isEmpty()){
                    question.setError("Écrivez une question");
                    return;
                }
                if (strOption1.isEmpty()){
                    option1.setError("Écrivez une proposition");
                    return;
                }
                if (strOption2.isEmpty()){
                    option2.setError("Écrivez une proposition");
                    return;
                }
                if (strOption3.isEmpty()){
                    option3.setError("Écrivez une proposition");
                    return;
                }
                if (strOption4.isEmpty()){
                    option4.setError("Écrivez une proposition");
                    return;
                }

                if (strReponse.isEmpty()){
                    reponse.setError("Écrivez la réponse");
                    return;
                }

                addNewQuestion();
            }
        });

        final ImageView backBtn = findViewById(R.id.retourBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuestionForm.this, MainActivity.class));
                finish();
            }
        });
    }

    private void addNewQuestion(){
        loadingDialog.show();

        Map<String,Object> quesData = new ArrayMap<>();

        quesData.put("QUESTION",strQuestion);
        quesData.put("OPTION1", strOption1);
        quesData.put("OPTION2", strOption2);
        quesData.put("OPTION3", strOption3);
        quesData.put("OPTION4", strOption4);
        quesData.put("ANSWER", strReponse);

        final String doc_id = firestore.collection("question").document("dI5TE342cgDbYB0Ed3mi").collection("list").document().getId();

        firestore.collection("question").document("dI5TE342cgDbYB0Ed3mi").collection("list").document(doc_id)
                .set(quesData)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {

                        Map<String,Object> quesDoc = new ArrayMap<>();
                        quesDoc.put("Q" + String.valueOf(questionLists.size() + 1) + "_ID", doc_id);
                        quesDoc.put("COUNT",String.valueOf(questionLists.size() + 1));

                        firestore.collection("question").document("dI5TE342cgDbYB0Ed3mi").collection("list").document("QUESTIONS_LIST")
                                .update(quesDoc)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Toast.makeText(QuestionForm.this, " Question Added Successfully", Toast.LENGTH_SHORT).show();

                                        questionLists.add(new QuestionList(
                                                doc_id,
                                                strQuestion,strOption1,strOption2,strOption3,strOption4, strReponse
                                        ));

                                        loadingDialog.dismiss();
                                        QuestionForm.this.finish();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(QuestionForm.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                                        loadingDialog.dismiss();
                                    }
                                });


                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(QuestionForm.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                        loadingDialog.dismiss();
                    }
                });
    }
}

