package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class delivery2 extends AppCompatActivity {
    Button button;
    ImageView redblank4, redblank5, redblank6, redblank7;
    EditText juso, rider, number;
    Handler handler = new Handler();
    Runnable blinkRunnable;
    ImageView currentBlinkingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery2);

        TextView textView = findViewById(R.id.textView43);
        String userInput = getIntent().getStringExtra("user_input");
        textView.setText(userInput);

        // EditText 초기화
        juso = findViewById(R.id.juso);
        rider = findViewById(R.id.rider);
        number = findViewById(R.id.number);

        // ImageView 초기화
        redblank4 = findViewById(R.id.redblank4);
        redblank5 = findViewById(R.id.redblank5);
        redblank6 = findViewById(R.id.redblank6);
        redblank7 = findViewById(R.id.redblank7);

        // 첫 번째 redblank 깜빡이기 시작
        startBlinking(redblank4);

        // juso EditText에 Enter 키 입력 처리
        juso.setOnEditorActionListener((TextView v, int actionId, KeyEvent event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE || (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
                stopBlinking(); // 현재 깜빡임 멈추기
                startBlinking(redblank5); // 다음 redblank 깜빡이기 시작
                rider.requestFocus(); // 다음 EditText로 포커스 이동
                return true;
            }
            return false;
        });

        // rider EditText에 Enter 키 입력 처리
        rider.setOnEditorActionListener((TextView v, int actionId, KeyEvent event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE || (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
                stopBlinking(); // 현재 깜빡임 멈추기
                startBlinking(redblank6); // 다음 redblank 깜빡이기 시작
                number.requestFocus(); // 다음 EditText로 포커스 이동
                return true;
            }
            return false;
        });

        // number EditText에 Enter 키 입력 처리
        number.setOnEditorActionListener((TextView v, int actionId, KeyEvent event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE || (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
                stopBlinking(); // 현재 깜빡임 멈추기
                startBlinking(redblank7); // 마지막 redblank 깜빡이기 시작
                return true;
            }
            return false;
        });

        // Button 초기화
        button = findViewById(R.id.address);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), delivery3.class);
            startActivity(intent);
        });
    }

    // 깜빡임 애니메이션 시작 메서드
    private void startBlinking(ImageView imageView) {
        currentBlinkingView = imageView;
        blinkRunnable = new Runnable() {
            @Override
            public void run() {
                if (currentBlinkingView != null) {
                    imageView.setAlpha(imageView.getAlpha() == 1f ? 0f : 1f);
                    handler.postDelayed(this, 500);
                }
            }
        };
        handler.post(blinkRunnable);
    }

    // 깜빡임 멈추는 메서드
    private void stopBlinking() {
        if (currentBlinkingView != null) {
            handler.removeCallbacks(blinkRunnable);
            currentBlinkingView.setAlpha(1f); // 깜빡임 중지 시 보이게 설정
            currentBlinkingView = null;
        }
    }
}
