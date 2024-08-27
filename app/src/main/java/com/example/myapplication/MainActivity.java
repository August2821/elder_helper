package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.games.game;
import com.example.myapplication.map.map_main;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.kiosk);
        Button button2 = findViewById(R.id.suggestion_box);
        Button button3 = findViewById(R.id.game);
        Button button4 = findViewById(R.id.map1);

        button1.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, kiosk.class);
            startActivity(intent);
        });

        button2.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://forms.gle/GKP1AXoouNHA7NDV7"));
            startActivity(intent);
        });

        button3.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, game.class);
            startActivity(intent);
        });

        button4.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, map_main.class);
            startActivity(intent);
        });
    }
}
