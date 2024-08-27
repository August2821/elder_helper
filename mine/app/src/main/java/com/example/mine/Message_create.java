package com.example.mine;

import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Message_create extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_create);

        // 초기 설명 다이얼로그 표시
        showInitialExplanationDialog();

        // 버튼 및 이미지뷰 참조
        Button create1by1Button = findViewById(R.id.msg_create_1by1_button);

        // 버튼 클릭 리스너 설정
        create1by1Button.setOnClickListener(v -> {
            // 1:1 대화 버튼 클릭 시 처리
            // Message_create_search 액티비티로 이동
            Intent intent = new Intent(Message_create.this, Message_create_search.class);
            startActivity(intent);
        });

        // 반짝이는 효과 추가
        startBlinkingEffect(create1by1Button);
    }

    // 초기 설명 다이얼로그 표시 메서드
    private void showInitialExplanationDialog() {
        new AlertDialog.Builder(this)
                .setTitle("설명")
                .setMessage("메시지 방을 만들기 위해 아래 1:1 대화 부분을 눌러주세요.")
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
    }
}

