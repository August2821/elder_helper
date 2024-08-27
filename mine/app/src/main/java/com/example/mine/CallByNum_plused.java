package com.example.mine;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CallByNum_plused extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call_by_num_plused);

        // 초기 설명 다이얼로그 표시
        showInitialExplanationDialog();

        // 버튼 및 이미지뷰 참조
        Button plusButton = findViewById(R.id.call_plus_button);
        Button lensButton = findViewById(R.id.call_lens_button);
        Button selfProfileButton = findViewById(R.id.call_selfProfile_button);
        Button frequentNumButton = findViewById(R.id.call_frequentNum_button);
        Button groupButton = findViewById(R.id.call_group_button);
        ImageView hongProfile = findViewById(R.id.call_by_num_plused_hong_profile);
        Button samjumButton = findViewById(R.id.call_more_button);
        Button goHomeButton = findViewById(R.id.go_home_button);

        // 각 버튼 및 이미지뷰에 클릭 리스너 설정
        plusButton.setOnClickListener(v -> showToast("연락처를 추가하는 버튼입니다."));
        lensButton.setOnClickListener(v -> showToast("연락처를 번호나 이름을 통해 찾을 수 있습니다."));
        selfProfileButton.setOnClickListener(v -> showToast("본인의 전화번호나 이름 등의 정보를 저장하고 있는 개인 정보공간 입니다."));
        frequentNumButton.setOnClickListener(v -> showToast("자주 찾는 연락처를 따로 묶어서 분류할 수 있는 기능입니다."));
        groupButton.setOnClickListener(v -> showToast("연락처들마다 묶어서 분류할 수 있는 기능입니다."));
        hongProfile.setOnClickListener(v -> showToast("새로 생성한 연락처 입니다."));
        samjumButton.setOnClickListener(v -> showImagePopup());
        goHomeButton.setOnClickListener(v -> goToSuccessPage());

        // 반짝이는 효과와 빨간색 테두리 추가
        startBlinkingEffect(plusButton, lensButton, selfProfileButton, frequentNumButton, groupButton, hongProfile, samjumButton, goHomeButton);
    }

    // 초기 설명 다이얼로그 표시 메서드
    private void showInitialExplanationDialog() {
        new AlertDialog.Builder(this)
                .setTitle("설명")
                .setMessage("홍길동의 연락처 추가를 성공했습니다! 반짝이는 곳들을 눌러서 기능들을 확인해 보세요.")
                .setPositiveButton("확인", (dialog, which) -> dialog.dismiss())
                .show();
    }

    // 이미지와 설명이 포함된 팝업 띄우기
    private void showImagePopup() {
        Dialog dialog = new Dialog(CallByNum_plused.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.popup_image_description);

        ImageView imageView = dialog.findViewById(R.id.popup_image);
        imageView.setImageResource(R.drawable.call_samjum); // 표시할 이미지 설정

        TextView descriptionText = dialog.findViewById(R.id.popup_description);
        descriptionText.setText("위와 같이 다양한 기능들을 모아놓은 곳입니다."); // 설명 텍스트 설정

        Button buttonClose = dialog.findViewById(R.id.button_close_image_popup);
        buttonClose.setOnClickListener(v -> dialog.dismiss());

        dialog.show();
    }

    // 간단한 토스트 메시지 표시 메서드
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    // 반짝이는 효과를 추가하는 메서드
    private void startBlinkingEffect(View... views) {
        for (View view : views) {
            // 빨간색 테두리 추가
            view.setBackgroundResource(R.drawable.red_border);

            // 반짝이는 애니메이션 설정
            ObjectAnimator fadeOut = ObjectAnimator.ofFloat(view, "alpha", 1f, 0f);
            fadeOut.setDuration(500);
            fadeOut.setRepeatCount(ObjectAnimator.INFINITE);
            fadeOut.setRepeatMode(ObjectAnimator.REVERSE);

            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(fadeOut);
            animatorSet.start();
        }
    }

    // 성공 페이지로 이동하는 메서드
    private void goToSuccessPage() {
        Intent intent = new Intent(CallByNum_plused.this, Success.class);
        startActivity(intent);
    }
}
