package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class CallByNum_plusNum extends AppCompatActivity {

    private Handler handler = new Handler();
    private Runnable blinkRunnable;
    private GradientDrawable nameDrawable, numDrawable, picDrawable, moreDrawable;
    private boolean isBlinking = true;
    private boolean hasClicked = false;
    private int currentStrokeColor = Color.RED; // 현재 테두리 색상 상태

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call_by_num_plus_page); // XML 레이아웃 파일

        // 버튼 및 텍스트 초기화
        final Button picButton = findViewById(R.id.call_num_plus_pic_button);
        final Button saveButton = findViewById(R.id.call_num_plus_save_button);
        final Button cancelButton = findViewById(R.id.call_num_plus_cancel_button);
        final Button moreButton = findViewById(R.id.call_num_plus_more_button);
        final TextView nameTextView = findViewById(R.id.call_by_num_plus_page_name_text);
        final TextView numTextView = findViewById(R.id.call_by_num_plus_page_num_text);

        // 설명 다이얼로그 표시
        showExplanationDialog();

        // 모든 버튼 및 텍스트에 빨간 테두리 적용
        nameDrawable = createRedBorderDrawable();
        numDrawable = createRedBorderDrawable();
        picDrawable = createRedBorderDrawable();
        moreDrawable = createRedBorderDrawable();

        applyDrawableToViews(picButton, saveButton, cancelButton, moreButton, nameTextView, numTextView);

        // 초기 텍스트 설정
        nameTextView.setText("이름을 작성하는 곳입니다");
        numTextView.setText("전화번호를 작성하는 곳입니다");

        // 버튼 및 텍스트 클릭 시 동작 설정
        picButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("갤러리나 카메라를 통해 선택한 사진을 함께 저장할 수 있어요.");
                if (!hasClicked) {
                    stopBlinking();
                    hasClicked = true;
                }
            }
        });

        nameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("이름을 작성하는 곳이에요");
                if (!hasClicked) {
                    stopBlinking();
                    hasClicked = true;
                }
            }
        });

        numTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("전화번호를 작성하는 곳이에요");
                if (!hasClicked) {
                    stopBlinking();
                    hasClicked = true;
                }
            }
        });

        moreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("이름과 전화번호 등의 정보들 이외 더 자세한 정보를 저장할 수 있습니다.");
                if (!hasClicked) {
                    stopBlinking();
                    hasClicked = true;
                }
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!hasClicked) {
                    stopBlinking();
                    hasClicked = true;
                }
                Intent intent = new Intent(CallByNum_plusNum.this, CallByNum_plused.class);
                startActivity(intent);
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!hasClicked) {
                    showToast("작성중인 연락처의 저장을 취소하는 버튼입니다.");
                    stopBlinking();
                    hasClicked = true;
                }
                // 취소 버튼 클릭 시의 동작을 추가할 수 있습니다.
            }
        });
    }

    // 설명 다이얼로그 표시 메서드
    private void showExplanationDialog() {
        new AlertDialog.Builder(this)
                .setTitle("설명")
                .setMessage("자 이제 이름과 전화번호 등의 정보를 기입해 연락처를 추가할 수 있습니다. 반짝거리는 부분들을 클릭해 기능을 확인하시고 마지막으로 저장 버튼을 눌러 연락처를 추가해 보세요.")
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }

    // 빨간 테두리 적용을 위한 Drawable 생성 메서드
    private GradientDrawable createRedBorderDrawable() {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.RECTANGLE);
        drawable.setStroke(4, Color.RED); // 빨간 테두리
        drawable.setColor(Color.TRANSPARENT); // 배경은 투명
        drawable.setCornerRadius(8);
        return drawable;
    }

    // 모든 버튼 및 텍스트에 빨간 테두리 적용 메서드
    private void applyDrawableToViews(View... views) {
        for (View view : views) {
            if (view instanceof Button) {
                ((Button) view).setBackground(createRedBorderDrawable());
            } else if (view instanceof TextView) {
                ((TextView) view).setBackground(createRedBorderDrawable());
            }
        }
        startBlinking();
    }

    // 버튼 테두리 깜빡임 시작 메서드
    private void startBlinking() {
        blinkRunnable = new Runnable() {
            @Override
            public void run() {
                if (isBlinking) {
                    // 색상 변경
                    currentStrokeColor = (currentStrokeColor == Color.RED) ? Color.TRANSPARENT : Color.RED;
                    updateDrawableStrokeColor(currentStrokeColor);
                    handler.postDelayed(this, 500);
                }
            }
        };
        handler.post(blinkRunnable);
    }

    // 버튼 테두리 색상 업데이트 메서드
    private void updateDrawableStrokeColor(int color) {
        if (nameDrawable != null) nameDrawable.setStroke(4, color);
        if (numDrawable != null) numDrawable.setStroke(4, color);
        if (picDrawable != null) picDrawable.setStroke(4, color);
        if (moreDrawable != null) moreDrawable.setStroke(4, color);
    }

    // 버튼 테두리 깜빡임 멈추는 메서드
    private void stopBlinking() {
        isBlinking = false;
        handler.removeCallbacks(blinkRunnable);
        updateDrawableStrokeColor(Color.RED); // 깜빡임 중지 시 빨간 테두리 유지
    }

    // 메시지 표시 메서드
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
