package com.example.myapplication.games;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

//import com.example.myapplication.games.operations;
//import com.example.myapplication.games.game;
//import com.example.myapplication.games.game2;
//import com.example.myapplication.games.game3;
import com.example.myapplication.R;


public class game extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        Button button1 = findViewById(R.id.operations_game);
        Button button2 = findViewById(R.id.other_game2);
        Button button3 = findViewById(R.id.other_game3);

        button1.setOnClickListener(v -> {
            Intent intent = new Intent(game.this, operations.class);
            startActivity(intent);
        });

        button2.setOnClickListener(v -> {
            Intent intent = new Intent(game.this, color.class);
            startActivity(intent);
        });

        button3.setOnClickListener(v -> {
            Intent intent = new Intent(game.this, Yesterday.class);
            startActivity(intent);
        });
    }

}