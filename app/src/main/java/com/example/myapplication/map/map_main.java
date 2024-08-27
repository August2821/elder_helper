package com.example.myapplication.map;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;


public class map_main extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_main);

        Button button1 = findViewById(R.id.go_map1);
        Button button2 = findViewById(R.id.go_map2);

        button1.setOnClickListener(v -> {
            Intent intent = new Intent(map_main.this, map1_login1.class);
            startActivity(intent);
        });

        button2.setOnClickListener(v -> {
            Intent intent = new Intent(map_main.this, map_find_way1.class);
            startActivity(intent);
        });
    }

}
