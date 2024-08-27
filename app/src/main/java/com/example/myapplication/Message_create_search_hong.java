package com.example.myapplication;

import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Message_create_search_hong extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_create_search_hong);

        // 초기 설명 다이얼로그 표시
        showInitialExplanationDialog();

        // 버튼 및 이미지뷰 참조
        Button hongButton = findViewById(R.id.msg_create_search_hong_button);

        // 버튼 클릭 리스너 설정
        hongButton.setOnClickListener(v -> {
            // message_created_new_page 액티비티로 이동
            Intent intent = new Intent(Message_create_search_hong.this, Message_created_new_page.class);
            startActivity(intent);
        });

        // 반짝이는 테두리 효과 추가
        startBlinkingEffect(hongButton);
    }

    // 초기 설명 다이얼로그 표시 메서드
    private void showInitialExplanationDialog() {
        new AlertDialog.Builder(this)
                .setTitle("설명")
                .setMessage("검색창에 '홍길동'을 검색하면 아래와 같이 검색 결과가 나오게 됩니다.\n아래 검색 결과를 눌러 메시지 방을 만들 수 있습니다.")
                .setPositiveButton("확인", (dialog, which) -> dialog.dismiss())
                .show();
    }

    // 반짝이는 테두리 효과를 추가하는 메서드
    private void startBlinkingEffect(Button button) {
        ObjectAnimator borderAnimator = ObjectAnimator.ofFloat(button, "translationX", 0f, 10f, 0f);
        borderAnimator.setDuration(500);
        borderAnimator.setRepeatCount(ObjectAnimator.INFINITE);
        borderAnimator.setRepeatMode(ObjectAnimator.REVERSE);
        borderAnimator.start();

        // 버튼의 테두리 색상을 빨간색으로 설정 (Drawable을 통해서)
        button.setBackgroundResource(R.drawable.button_border_red);
    }
}
