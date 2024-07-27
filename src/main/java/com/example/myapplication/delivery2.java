package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class delivery2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery2);

        TextView textView = findViewById(R.id.textView43);
        String userInput = getIntent().getStringExtra("user_input");

        textView.setText(userInput);}


}