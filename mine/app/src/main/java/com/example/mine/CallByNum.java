package com.example.mine;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class CallByNum extends AppCompatActivity {

    private Handler handler = new Handler();
    private Runnable blinkRunnable;
    private Button callPlusButton;
    private GradientDrawable buttonDrawable;

    private static final int BLINK_DURATION = 500; // 깜빡임 간격 (500ms)
    private boolean isBlinking = true; // 깜빡임 상태를 나타내는 플래그

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call_by_num); // XML 레이아웃 파일

        // + 버튼 초기화
        callPlusButton = findViewById(R.id.call_plus_button);

        // 버튼 테두리 설정
        buttonDrawable = new GradientDrawable();
        buttonDrawable.setShape(GradientDrawable.RECTANGLE);
        buttonDrawable.setStroke(4, Color.RED); // 빨간 테두리
        buttonDrawable.setColor(Color.TRANSPARENT); // 배경은 투명
        buttonDrawable.setCornerRadius(8);
        callPlusButton.setBackground(buttonDrawable);

        // 설명 다이얼로그 표시
        showExplanationDialog();

        // + 버튼 깜빡임 시작
        startBlinking();

        // + 버튼 클릭 시
        callPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopBlinking(); // 버튼 깜빡임 멈추기
                Intent intent = new Intent(CallByNum.this, CallByNum_plusNum.class); // CallByNumPlusPage로 이동
                startActivity(intent);
            }
        });
    }

    // 설명 다이얼로그 표시 메서드
    private void showExplanationDialog() {
        new AlertDialog.Builder(this)
                .setTitle("설명")
                .setMessage("현재 연락처에 저장된 연락처가 존재하지 않습니다. 먼저 연락처를 생성하기 위해 + 버튼을 눌러주세요.")
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }

    // 버튼 테두리 깜빡임 시작 메서드
    private void startBlinking() {
        blinkRunnable = new Runnable() {
            @Override
            public void run() {
                // 현재 테두리 색상에 따라 변경
                int currentColor = isBlinking ? Color.TRANSPARENT : Color.RED;
                buttonDrawable.setStroke(4, currentColor);
                isBlinking = !isBlinking; // 상태 반전
                handler.postDelayed(this, BLINK_DURATION); // 500ms 간격으로 깜빡임
            }
        };
        handler.post(blinkRunnable);
    }

    // 버튼 깜빡임 멈추는 메서드
    private void stopBlinking() {
        handler.removeCallbacks(blinkRunnable);
        buttonDrawable.setStroke(4, Color.RED); // 깜빡임 중지 시 빨간 테두리 유지
        isBlinking = false; // 깜빡임 상태 업데이트
    }
}
