package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class CallByType extends AppCompatActivity {

    private EditText display;
    private Button videoCallButton;
    private Button deleteButton;
    private TextView highlightTextView;
    private Handler handler = new Handler(); // 핸들러 선언
    private Runnable blinkRunnable; // Runnable 변수 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call_by_type);

        display = findViewById(R.id.call_by_type_display);
        videoCallButton = findViewById(R.id.call_by_type_video_call);
        deleteButton = findViewById(R.id.call_by_type_delete);
        highlightTextView = findViewById(R.id.textView);

        // GradientDrawable을 사용하여 빨간 테두리를 생성
        GradientDrawable redBorder = new GradientDrawable();
        redBorder.setShape(GradientDrawable.RECTANGLE);
        redBorder.setStroke(4, Color.RED);  // 테두리 두께와 색상 설정
        redBorder.setCornerRadius(8);  // 선택적으로 모서리 반경 설정

        // TextView에 빨간 테두리를 배경으로 적용
        highlightTextView.setBackground(redBorder);

        // 깜빡임 시작
        startBlinking();

        // 번호 버튼과 액션 설정
        int[] buttonIds = {
                R.id.call_by_type_button1, R.id.call_by_type_button2, R.id.call_by_type_button3,
                R.id.call_by_type_button4, R.id.call_by_type_button5, R.id.call_by_type_button6,
                R.id.call_by_type_button7, R.id.call_by_type_button8, R.id.call_by_type_button9,
                R.id.call_by_type_button_star, R.id.call_by_type_button0, R.id.call_by_type_button_shap
        };

        for (int id : buttonIds) {
            findViewById(id).setOnClickListener(this::onNumberButtonClick);
        }

        Button callButton = findViewById(R.id.call_by_type_button_call);
        callButton.setOnClickListener(v -> onCallButtonClick());

        display.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // 텍스트 변경 전 콜백
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // 텍스트 변경 중 콜백
            }

            @Override
            public void afterTextChanged(Editable s) {
                // 텍스트 변경 후 콜백
                if (s.length() > 0) {
                    videoCallButton.setVisibility(View.VISIBLE);
                    deleteButton.setVisibility(View.VISIBLE);
                } else {
                    videoCallButton.setVisibility(View.GONE);
                    deleteButton.setVisibility(View.GONE);
                }
                if (s.length() > 13) {
                    s.delete(s.length() - 1, s.length());
                }
            }
        });

        videoCallButton.setOnClickListener(v -> onVideoCallButtonClick());
        deleteButton.setOnClickListener(v -> onDeleteButtonClick());

        // 다이얼로그 표시
        showExplanationDialog();
    }

    // 설명 다이얼로그 표시 메서드
    private void showExplanationDialog() {
        new AlertDialog.Builder(this)
                .setTitle("설명")
                .setMessage("전화 번호를 아는 경우, 직접 번호를 입력해서 전화할 수 있어요. 홍길동의 번호를 입력해서 직접 전화 걸어보세요!")
                .setPositiveButton("확인", (dialog, which) -> dialog.dismiss())
                .show();
    }

    // 번호 버튼 클릭 시 호출되는 메서드
    private void onNumberButtonClick(View view) {
        String currentText = display.getText().toString();
        if (currentText.length() >= 13) return;

        int id = view.getId();
        if (id == R.id.call_by_type_button1) {
            currentText += "1";
        } else if (id == R.id.call_by_type_button2) {
            currentText += "2";
        } else if (id == R.id.call_by_type_button3) {
            currentText += "3";
        } else if (id == R.id.call_by_type_button4) {
            currentText += "4";
        } else if (id == R.id.call_by_type_button5) {
            currentText += "5";
        } else if (id == R.id.call_by_type_button6) {
            currentText += "6";
        } else if (id == R.id.call_by_type_button7) {
            currentText += "7";
        } else if (id == R.id.call_by_type_button8) {
            currentText += "8";
        } else if (id == R.id.call_by_type_button9) {
            currentText += "9";
        } else if (id == R.id.call_by_type_button0) {
            currentText += "0";
        } else if (id == R.id.call_by_type_button_star) {
            currentText += "*";
        } else if (id == R.id.call_by_type_button_shap) {
            currentText += "#";
        }

        // 전화번호 형식에 맞게 포맷팅
        currentText = formatPhoneNumber(currentText);

        display.setText(currentText);
    }

    // 전화번호를 포맷팅하는 메서드
    private String formatPhoneNumber(String number) {
        // 포맷팅을 위해 모든 숫자 이외의 문자를 제거
        number = number.replaceAll("[^0-9]", "");

        // 대시를 사용하여 포맷된 번호 생성
        StringBuilder formatted = new StringBuilder();
        int length = number.length();

        if (length >= 10) {
            // 010-1234-5678 형식
            formatted.append(number.substring(0, 3)).append("-");
            formatted.append(number.substring(3, 7)).append("-");
            formatted.append(number.substring(7));
        } else if (length >= 7) {
            // 010-1234 형식
            formatted.append(number.substring(0, 3)).append("-");
            formatted.append(number.substring(3));
        } else if (length >= 4) {
            // 010-123 형식
            formatted.append(number.substring(0, 3)).append("-");
            formatted.append(number.substring(3));
        } else {
            // 대시 없이 숫자만
            formatted.append(number);
        }

        return formatted.toString();
    }

    // 통화 버튼 클릭 시 호출되는 메서드
    private void onCallButtonClick() {
        String currentText = display.getText().toString();
        if (currentText.equals("010-2374-0802")) {
            Intent intent = new Intent(CallByType.this, CallByType_CallPage.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "전화 버튼을 눌러 통화할 수 있어요", Toast.LENGTH_SHORT).show();
        }
    }

    // 영상통화 버튼 클릭 시 호출되는 메서드
    private void onVideoCallButtonClick() {
        Toast.makeText(this, "영상통화를 할 수 있는 버튼이에요", Toast.LENGTH_SHORT).show();
    }

    // 삭제 버튼 클릭 시 호출되는 메서드
    private void onDeleteButtonClick() {
        String currentText = display.getText().toString();
        if (currentText.isEmpty()) {
            Toast.makeText(this, "번호를 지울 수 있는 버튼이에요", Toast.LENGTH_SHORT).show();
        }

        // 텍스트가 비어 있지 않으면 마지막 문자를 제거
        if (!currentText.isEmpty()) {
            // 마지막 문자를 제거
            currentText = currentText.substring(0, currentText.length() - 1);

            // 대시를 사용하여 번호를 다시 포맷팅
            currentText = formatPhoneNumber(currentText);

            display.setText(currentText);
        }
    }

    // 깜빡임 애니메이션 시작 메서드
    private void startBlinking() {
        blinkRunnable = new Runnable() {
            @Override
            public void run() {
                // 테두리의 알파 값을 변경하여 깜빡이는 효과 구현
                GradientDrawable drawable = (GradientDrawable) highlightTextView.getBackground();
                int currentAlpha = drawable.getAlpha();
                drawable.setAlpha(currentAlpha == 255 ? 0 : 255);
                handler.postDelayed(this, 500); // 0.5초 간격으로 반복
            }
        };
        handler.post(blinkRunnable);
    }
}
