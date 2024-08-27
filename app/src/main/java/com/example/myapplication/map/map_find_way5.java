package com.example.myapplication.map;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class map_find_way5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_find_way5);

        Button nextPageButton = findViewById(R.id.button2);

        // 빨간 박스에 깜빡이는 애니메이션 추가
        Animation blinkAnimation = new AlphaAnimation(0.0f, 1.0f);
        blinkAnimation.setDuration(500); // 깜빡이는 속도 (500ms)
        blinkAnimation.setRepeatMode(Animation.REVERSE);
        blinkAnimation.setRepeatCount(Animation.INFINITE);
        nextPageButton.startAnimation(blinkAnimation);

        // nextPageButton 클릭 시 map_find_way4로 이동
        nextPageButton.setOnClickListener(v -> {
            Intent intent = new Intent(map_find_way5.this, map_find_way6.class);
            startActivity(intent);
        });
    }
}
