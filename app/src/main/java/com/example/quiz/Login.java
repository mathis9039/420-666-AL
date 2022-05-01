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

public class Login extends AppCompatActivity {

    private AppCompatButton connexion, subscribe;
    private EditText password, email;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        connexion = findViewById(R.id.connexionBtn);
        subscribe = findViewById(R.id.subscribeBtn);
        password = findViewById(R.id.password);
        email = findViewById(R.id.username);

        firebaseAuth = FirebaseAuth.getInstance();
        connexion.setOnClickListener(view -> {
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

        subscribe.setOnClickListener(view -> {
            startActivity(new Intent(Login.this, Subscribe.class));
            finish();
        });
    }

    private void firebaseLogin(){
        firebaseAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                       Toast.makeText(Login.this, "Connexion réussi", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Login.this, MainActivity.class));
                        finish();
                    } else {
                        Toast.makeText(Login.this, "Échec de la connexion", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}