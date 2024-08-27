package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class order4 extends AppCompatActivity {

    private ImageView rb1, rb2, rb3;
    private ImageButton selectButton1, selectButton2,button;
    private AlphaAnimation blinkAnimation;
    private ImageView currentBlinkingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order4);

        // ImageView와 ImageButton 초기화
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        selectButton1 = findViewById(R.id.selectbutton1);
        selectButton2 = findViewById(R.id.selectbutton2);

        // AlphaAnimation 설정
        blinkAnimation = new AlphaAnimation(0.0f, 1.0f);
        blinkAnimation.setDuration(500); // 깜빡임 속도 (500ms)
        blinkAnimation.setRepeatMode(Animation.REVERSE); // 역방향 반복
        blinkAnimation.setRepeatCount(Animation.INFINITE); // 무한 반복

        // 초기 깜빡임 설정
        startBlinking(rb1);

        // selectButton1 클릭 리스너 설정
        selectButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopBlinking(rb1);
                startBlinking(rb2);
            }
        });

        // selectButton2 클릭 리스너 설정
        selectButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopBlinking(rb2);
                startBlinking(rb3);
            }
        });

        // Button 초기화
        button = findViewById(R.id.cart);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), order5.class);
            startActivity(intent);
        });
    }

    // 깜빡임 애니메이션 시작 메서드
    private void startBlinking(ImageView imageView) {
        if (currentBlinkingView != null) {
            currentBlinkingView.clearAnimation();
        }
        currentBlinkingView = imageView;
        currentBlinkingView.startAnimation(blinkAnimation);
    }

    // 깜빡임 멈추는 메서드
    private void stopBlinking(ImageView imageView) {
        if (imageView != null) {
            imageView.clearAnimation();
        }
    }
}
