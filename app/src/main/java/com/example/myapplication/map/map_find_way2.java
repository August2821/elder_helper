package com.example.myapplication.map;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class map_find_way2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_find_way2);

        final EditText inputBox = findViewById(R.id.inputBox);
        final TextView newTextBox = findViewById(R.id.newTextBox);
        final TextView invalidInputTextBox = findViewById(R.id.invalidInputTextBox);
        final View redBlinkingBox = findViewById(R.id.redBlinkingBox);

        // 빨간 박스에 깜빡이는 애니메이션 추가
        Animation blinkAnimation = new AlphaAnimation(0.0f, 1.0f);
        blinkAnimation.setDuration(500); // 깜빡이는 속도 (500ms)
        blinkAnimation.setRepeatMode(Animation.REVERSE);
        blinkAnimation.setRepeatCount(Animation.INFINITE);
        redBlinkingBox.startAnimation(blinkAnimation);

        // 입력 박스에서 완료 버튼 클릭 시 행동 처리
        inputBox.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                // 완료 버튼 클릭 시 키보드 숨기기
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }

                // 입력된 텍스트 확인
                String inputText = inputBox.getText().toString().trim();
                if ("스타벅스".equals(inputText)) {
                    // 입력이 "스타벅스"이면 다음 페이지로 이동
                    Intent intent = new Intent(map_find_way2.this, map_find_way3.class);
                    startActivity(intent);
                } else {
                    // 새로운 텍스트 박스와 잘못된 입력 메시지 보이게 함
                    newTextBox.setVisibility(View.GONE);
                    invalidInputTextBox.setVisibility(View.VISIBLE);
                }

                return true;
            }
            return false;
        });
    }
}