package com.example.mine;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class CallByType_CallPage extends AppCompatActivity {

    private Handler handler = new Handler();
    private Button lastClickedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call_by_type_call_page);

        // 각 버튼에 대한 참조를 설정
        Button callNoSoundButton = findViewById(R.id.call_no_sound_button);
        Button callSpeakerButton = findViewById(R.id.call_speaker_button);
        Button faceCallButton = findViewById(R.id.face_call_button);
        Button callBluetoothButton = findViewById(R.id.call_bluetooth_button);
        Button callEndButton = findViewById(R.id.call_end_button);
        Button callRecordButton = findViewById(R.id.call_record_button);
        Button callKeypadButton = findViewById(R.id.call_keypad_button);

        // 버튼 테두리 깜빡임 설정
        startBlinking(callNoSoundButton);
        startBlinking(callSpeakerButton);
        startBlinking(faceCallButton);
        startBlinking(callBluetoothButton);
        startBlinking(callEndButton);
        startBlinking(callRecordButton);
        startBlinking(callKeypadButton);

        // 설명 다이얼로그 표시
        showExplanationDialog();

        // 버튼 클릭 시 토스트 메시지를 표시하고 깜빡임을 멈추는 코드
        callNoSoundButton.setOnClickListener(v -> showToastAndStopBlinking("음소거 버튼이에요", callNoSoundButton));
        callSpeakerButton.setOnClickListener(v -> showToastAndStopBlinking("큰소리로 통화할 수 있는 버튼이에요", callSpeakerButton));
        faceCallButton.setOnClickListener(v -> showToastAndStopBlinking("영상통화로 바꿀 수 있는 버튼이에요", faceCallButton));
        callBluetoothButton.setOnClickListener(v -> showToastAndStopBlinking("블루투스 기능이 연결된 경우 사용하는 버튼이에요", callBluetoothButton));
        callRecordButton.setOnClickListener(v -> showToastAndStopBlinking("통화 내용을 녹음할 수 있는 버튼이에요", callRecordButton));
        callKeypadButton.setOnClickListener(v -> showToastAndStopBlinking("전화 받는동안 사용할 수 있는 숫자 자판이에요", callKeypadButton));

        // 통화 종료 버튼 클릭 시 통화 종료 다이얼로그 표시
        callEndButton.setOnClickListener(v -> showEndCallDialog());
    }

    // 설명 다이얼로그 표시 메서드
    private void showExplanationDialog() {
        new AlertDialog.Builder(this)
                .setTitle("설명")
                .setMessage("홍길동의 번호로 전화를 연결하는데 성공했어요. 밑의 빨간 박스의 기능들을 눌러 사용 방법을 확인하세요.")
                .setPositiveButton("확인", (dialog, which) -> dialog.dismiss())
                .show();
    }

    // 통화 종료 다이얼로그 표시 메서드
    private void showEndCallDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("통화 종료 버튼");
        builder.setMessage("통화 종료 버튼이에요. 통화를 종료하시려면 '종료'를 누르시고 종료하지 않고 싶으시면 '취소' 버튼을 눌러주세요.");

        builder.setPositiveButton("종료", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent intent = new Intent(CallByType_CallPage.this, Success.class);
                startActivity(intent);
                finish(); // 현재 액티비티를 종료 (통화 종료)
            }
        });

        builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss(); // 다이얼로그 닫기 (통화 종료 안 함)
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    // 토스트 메시지를 표시하고 버튼 깜빡임을 멈추는 메서드
    private void showToastAndStopBlinking(String message, Button button) {
        Toast.makeText(CallByType_CallPage.this, message, Toast.LENGTH_SHORT).show();
        stopBlinking(button);
    }

    // 버튼 테두리 깜빡임 시작 메서드
    private void startBlinking(Button button) {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.RECTANGLE);
        drawable.setStroke(4, Color.RED);
        drawable.setCornerRadius(8);
        button.setBackground(drawable);

        Runnable blinkRunnable = new Runnable() {
            @Override
            public void run() {
                int currentAlpha = drawable.getAlpha();
                int newColor = currentAlpha == 255 ? Color.TRANSPARENT : Color.RED;
                drawable.setStroke(4, newColor);
                handler.postDelayed(this, 500);
            }
        };
        handler.post(blinkRunnable);

        button.setTag(blinkRunnable);
    }

    // 버튼 깜빡임을 멈추는 메서드
    private void stopBlinking(Button button) {
        Runnable runnable = (Runnable) button.getTag();
        if (runnable != null) {
            handler.removeCallbacks(runnable);
            GradientDrawable drawable = (GradientDrawable) button.getBackground();
            drawable.setStroke(4, Color.RED); // 깜빡임 중지 시 원래 테두리 색상으로 설정
        }
    }
}
