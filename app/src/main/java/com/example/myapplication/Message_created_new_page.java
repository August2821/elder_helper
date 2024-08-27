package com.example.myapplication;

import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Message_created_new_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_created_new_page);

        // 초기 설명 다이얼로그 표시
        showInitialExplanationDialog();

        // 버튼 참조
        Button backButton = findViewById(R.id.back_button);

        // 버튼 클릭 리스너 설정
        backButton.setOnClickListener(v -> {
            // success.xml 페이지로 이동
            Intent intent = new Intent(Message_created_new_page.this, Success.class);
            startActivity(intent);
        });

        // 반짝이는 테두리 효과 추가
        startBlinkingEffect(backButton);
    }

    // 초기 설명 다이얼로그 표시 메서드
    private void showInitialExplanationDialog() {
        new AlertDialog.Builder(this)
                .setTitle("설명")
                .setMessage("홍길동과의 메시지 방이 성공적으로 만들어 졌습니다.\n삭제하지 않는 이상 이 방은 사라지지 않고 사용할 수 있습니다.\n확인하셨다면 옆쪽의 돌아가기 버튼을 눌러 다양한 기능을 둘러보세요.")
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
