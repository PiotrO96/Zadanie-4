package com.example.ps4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    private TextView textViewWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        setTitle(R.string.welcome);
        textViewWelcome = findViewById(R.id.textViewWelcome);
        Intent intent = getIntent();
        Account account = (Account) intent.getSerializableExtra("account");
        textViewWelcome.setText(getString(R.string.welcome)+ " " + account.getUsername());
    }
}