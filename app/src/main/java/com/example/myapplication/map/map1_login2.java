package com.example.myapplication.map;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class map1_login2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map1_login2);

        Button transparentButton = findViewById(R.id.button2);

        // 빨간 박스에 깜빡이는 애니메이션 추가
        Animation blinkAnimation = new AlphaAnimation(0.0f, 1.0f);
        blinkAnimation.setDuration(500); // 깜빡이는 속도 (500ms)
        blinkAnimation.setRepeatMode(Animation.REVERSE);
        blinkAnimation.setRepeatCount(Animation.INFINITE);
        transparentButton.startAnimation(blinkAnimation);

        // 버튼 클릭 시 map1_login2로 이동
        transparentButton.setOnClickListener(v -> {
            Intent intent = new Intent(map1_login2.this, map1_login3.class);
            startActivity(intent);
        });
    }
}