package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Subscribe extends AppCompatActivity {

    private AppCompatButton subscribe, login;
    private EditText password, email;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscribe);

        subscribe = findViewById(R.id.subscribeBtn);
        login = findViewById(R.id.loginBtn);
        password = findViewById(R.id.password);
        email = findViewById(R.id.email);

        firebaseAuth = FirebaseAuth.getInstance();
        subscribe.setOnClickListener(view -> {
            if (email.getText().toString().isEmpty()){
                email.setError("Entrer votre courriel");
                return;
            }else {
                email.setError(null);
            }
            if (password.getText().toString().isEmpty()){
                password.setError("Entrer votre mot de passe");
                return;
            }else {
                password.setError(null);
            } firebaseLogin();
        });

        login.setOnClickListener(view -> {
            startActivity(new Intent(Subscribe.this, Login.class));
            finish();
        });
    }

    private void firebaseLogin(){
        firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(Subscribe.this, "Création de compte réussi", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Subscribe.this, Login.class));
                        finish();
                    } else {
                        Toast.makeText(Subscribe.this, "Échec de création de compte", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}