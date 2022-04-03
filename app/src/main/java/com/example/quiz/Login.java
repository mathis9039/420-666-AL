package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private AppCompatButton connexion, subscribe;
    private EditText password, email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        connexion = findViewById(R.id.connexionBtn);
        subscribe = findViewById(R.id.subscribeBtn);
        password = findViewById(R.id.password);
        email = findViewById(R.id.username);


        connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, MainActivity.class));
                finish();
            }
        });

        subscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, Subscribe.class));
                finish();
            }
        });

        connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(password.getText().toString()) && TextUtils.isEmpty(password.getText().toString())){
                    Toast.makeText(Login.this, "Veuillez saisir vos information", Toast.LENGTH_SHORT).show();
                }else if(password.getText().toString().contains("admin") && email.getText().toString().contains("admin")){
                    Toast.makeText(Login.this, "Bonjour Administrateur", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Login.this, MainActivity.class));
                    finish();
                }
            }
        });
    }
}