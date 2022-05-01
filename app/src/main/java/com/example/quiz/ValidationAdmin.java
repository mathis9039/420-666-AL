package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ValidationAdmin extends AppCompatActivity {

    private Button connexion;
    private EditText password;
    private ImageView retourBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validation_admin);

        password = findViewById(R.id.code);
        connexion = findViewById(R.id.connexionBtn);
        retourBtn = findViewById(R.id.backBtn);

        connexion.setOnClickListener(view -> {
            if(TextUtils.isEmpty(password.getText().toString())){
                Toast.makeText(ValidationAdmin.this, "Veuillez écrire le code", Toast.LENGTH_SHORT).show();
            }else if(!password.getText().toString().contains("admin")){
                Toast.makeText(ValidationAdmin.this, "Code incorrect", Toast.LENGTH_SHORT).show();
            } else if(password.getText().toString().contains("admin")){
                startActivity(new Intent(ValidationAdmin.this, QuestionForm.class));
                finish();
            }
        });

        retourBtn.setOnClickListener(view -> {
            finish();
        });
    }
}