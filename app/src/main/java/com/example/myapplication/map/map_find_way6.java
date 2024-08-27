package com.example.myapplication.map;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class map_find_way6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_find_way6);

        ImageButton closeButton = findViewById(R.id.closeButton);

        // X 버튼 클릭 시 실행되는 코드
        closeButton.setOnClickListener(v -> {
            Intent intent = new Intent(map_find_way6.this, map_main.class);
            startActivity(intent);
        });


    }
}