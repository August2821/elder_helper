package com.example.myapplication.map;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import com.example.myapplication.R;
import androidx.appcompat.app.AppCompatActivity;

public class map_ex_find_way1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_ex_find_way1);

        // 요소들 가져오기
        ImageButton closeButton = findViewById(R.id.closeButton);
        final FrameLayout textBoxContainer = findViewById(R.id.textBoxContainer);
        final View darkOverlay = findViewById(R.id.darkOverlay);
        final View redBlinkingBox = findViewById(R.id.redBlinkingBox);
        final EditText inputBox = findViewById(R.id.inputBox);
        final TextView newTextBox = findViewById(R.id.newTextBox);
        final TextView invalidInputTextBox = findViewById(R.id.invalidInputTextBox);

        // 초기 상태에서 어두운 배경 표시
        darkOverlay.setVisibility(View.VISIBLE);

        // X 버튼 클릭 시 실행되는 코드
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 텍스트 박스와 X 버튼이 포함된 레이아웃을 숨김
                textBoxContainer.setVisibility(View.GONE);

                // 깜빡이는 빨간 박스와 새로운 텍스트 박스를 표시
                redBlinkingBox.setVisibility(View.VISIBLE);
                newTextBox.setVisibility(View.VISIBLE);
                inputBox.setVisibility(View.VISIBLE);

                // 어두운 배경은 계속 유지되며, 깜빡이는 박스 및 텍스트 박스를 제외한 부분이 어두워짐
                darkOverlay.setVisibility(View.VISIBLE);

                // 빨간 박스에 깜빡이는 애니메이션 추가
                Animation blinkAnimation = new AlphaAnimation(0.0f, 1.0f);
                blinkAnimation.setDuration(500); // 깜빡이는 속도 (500ms)
                blinkAnimation.setRepeatMode(Animation.REVERSE);
                blinkAnimation.setRepeatCount(Animation.INFINITE);
                redBlinkingBox.startAnimation(blinkAnimation);
            }
        });

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
                    Intent intent = new Intent(map_ex_find_way1.this, map_find_way2.class);
                    startActivity(intent);
                } else {
                    // 입력이 "스타벅스"가 아니면 UI 조정
                    inputBox.setVisibility(View.VISIBLE);
                    redBlinkingBox.setVisibility(View.VISIBLE);
                    darkOverlay.setVisibility(View.VISIBLE);

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
