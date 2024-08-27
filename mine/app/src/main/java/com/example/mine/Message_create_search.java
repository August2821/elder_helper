package com.example.mine;

import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Message_create_search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_create_search);

        // 초기 설명 다이얼로그 표시
        showInitialExplanationDialog();

        // 버튼 및 이미지뷰 참조
        Button searchButton = findViewById(R.id.msg_create_search_button);

        // 버튼 클릭 리스너 설정
        searchButton.setOnClickListener(v -> {
            // message_create_search_hong 액티비티로 이동
            Intent intent = new Intent(Message_create_search.this, Message_create_search_hong.class);
            startActivity(intent);
        });

        // 반짝이는 테두리 효과 추가
        startBlinkingEffect(searchButton);
    }

    // 초기 설명 다이얼로그 표시 메서드
    private void showInitialExplanationDialog() {
        new AlertDialog.Builder(this)
                .setTitle("설명")
                .setMessage("메시지를 나누고자 하는 연락처를 번호나 이름 등의 정보를 검색해 찾을 수 있습니다.\n반짝이는 곳을 눌러서 연락처를 찾아보세요.")
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
