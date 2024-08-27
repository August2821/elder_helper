package com.example.myapplication.map;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class map_find_way1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_find_way1);

        // 요소들 가져오기
        ImageButton closeButton = findViewById(R.id.closeButton);
        final FrameLayout textBoxContainer = findViewById(R.id.textBoxContainer);
        final View darkOverlay = findViewById(R.id.darkOverlay);
        final View redBlinkingBox = findViewById(R.id.redBlinkingBox);
        final Button nextPageButton = findViewById(R.id.nextPageButton);
        final TextView newTextBox = findViewById(R.id.newTextBox);
        final TextView textView = findViewById(R.id.textView);

        // 초기 상태에서 어두운 배경 표시
        darkOverlay.setVisibility(View.VISIBLE);

        // X 버튼 클릭 시 실행되는 코드
        closeButton.setOnClickListener(v -> {
            // 텍스트 박스와 X 버튼이 포함된 레이아웃을 숨김
            textBoxContainer.setVisibility(View.GONE);

            // 깜빡이는 빨간 박스와 새로운 텍스트 박스를 표시
            redBlinkingBox.setVisibility(View.VISIBLE);
            newTextBox.setVisibility(View.VISIBLE);
            nextPageButton.setVisibility(View.VISIBLE);
            textView.setVisibility(View.VISIBLE);

            // 어두운 배경은 계속 유지되며, 깜빡이는 박스 및 텍스트 박스를 제외한 부분이 어두워짐
            darkOverlay.setVisibility(View.VISIBLE);

            // 빨간 박스에 깜빡이는 애니메이션 추가
            Animation blinkAnimation = new AlphaAnimation(0.0f, 1.0f);
            blinkAnimation.setDuration(500); // 깜빡이는 속도 (500ms)
            blinkAnimation.setRepeatMode(Animation.REVERSE);
            blinkAnimation.setRepeatCount(Animation.INFINITE);
            redBlinkingBox.startAnimation(blinkAnimation);
        });

        // nextPageButton 클릭 시 map_find_way2로 이동
        nextPageButton.setOnClickListener(v -> {
            Intent intent = new Intent(map_find_way1.this, map_find_way2.class);
            startActivity(intent);
        });
    }
}
