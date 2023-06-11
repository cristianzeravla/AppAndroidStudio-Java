package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private Button buttonUpperBody, buttonLowerBody;
    private TextView textViewUsername;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        textViewUsername = findViewById(R.id.textViewUsername);
        buttonUpperBody = findViewById(R.id.buttonUpperBody);
        buttonLowerBody = findViewById(R.id.buttonLowerBody);

        // Obtener el nombre de usuario del usuario actual y mostrarlo en el TextView
        String currentUserEmail = mAuth.getCurrentUser().getEmail();
        textViewUsername.setText(currentUserEmail);

        buttonUpperBody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UpperBodyActivity.class);
                startActivity(intent);
            }
        });

        buttonLowerBody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LowerBodyActivity.class);
                startActivity(intent);
            }
        });
    }
}