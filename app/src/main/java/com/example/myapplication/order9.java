package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class order9 extends AppCompatActivity {

    private ImageView rb91, rb92, rb93;
    private ImageButton paymentButton, creditPaymentButton, selectEndButton;
    private AlphaAnimation blinkAnimation;
    private ImageView currentBlinkingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order9);

        // ImageView와 ImageButton 초기화
        rb91 = findViewById(R.id.rb91);
        rb92 = findViewById(R.id.rb92);
        rb93 = findViewById(R.id.rb93);
        paymentButton = findViewById(R.id.payment);
        creditPaymentButton = findViewById(R.id.creditpayment);
        selectEndButton = findViewById(R.id.selectend);

        // AlphaAnimation 설정
        blinkAnimation = new AlphaAnimation(0.0f, 1.0f);
        blinkAnimation.setDuration(500); // 깜빡임 속도 (500ms)
        blinkAnimation.setRepeatMode(Animation.REVERSE); // 역방향 반복
        blinkAnimation.setRepeatCount(Animation.INFINITE); // 무한 반복

        // 초기 깜빡임 설정 (rb91부터 시작)
        startBlinking(rb91);

        // paymentButton 클릭 리스너 설정
        paymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopBlinking(rb91);
                startBlinking(rb92);
            }
        });

        // creditPaymentButton 클릭 리스너 설정
        creditPaymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopBlinking(rb92);
                startBlinking(rb93);
            }
        });

        // selectEndButton 클릭 리스너 설정
        selectEndButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopBlinking(rb93);
                // 다음 액티비티로 이동
                Intent intent = new Intent(getApplicationContext(), order10.class);
                startActivity(intent);
            }
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
