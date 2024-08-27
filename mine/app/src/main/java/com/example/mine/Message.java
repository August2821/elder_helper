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

public class Message extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message);

        // 초기 설명 다이얼로그 표시
        showInitialExplanationDialog();

        // 버튼 및 이미지뷰 참조
        Button createMsgButton = findViewById(R.id.message_create_msg_button);
        Button searchButton = findViewById(R.id.msg_main_search_button);
        Button samjumButton = findViewById(R.id.msg_main_samjum_button);

        // 각 버튼에 클릭 리스너 설정
        createMsgButton.setOnClickListener(v -> navigateToCreateMessagePage());
        searchButton.setOnClickListener(v -> showToast("연락처를 번호나 이름을 통해 찾을 수 있는 기능입니다."));
        samjumButton.setOnClickListener(v -> showImagePopup());

        // 반짝이는 효과와 빨간색 테두리 추가
        startBlinkingEffect(createMsgButton, searchButton, samjumButton);
    }

    // 초기 설명 다이얼로그 표시 메서드
    private void showInitialExplanationDialog() {
        new AlertDialog.Builder(this)
                .setTitle("설명")
                .setMessage("메시지를 보내기 위해서는 메시지 방을 만들거나 이미 대화를 나눈 적이 있는 경우, 해당 방을 눌러서 연락을 주고받을 수 있습니다.\n" +
                        "메시지 방을 만들기 위해서는 아래의 반짝이는 곳을 눌러주세요.\n" +
                        "다른 반짝이는 버튼을 눌러 기능들을 확인할 수 있습니다.")
                .setPositiveButton("확인", (dialog, which) -> dialog.dismiss())
                .show();
    }

    // 메시지 방 만들기 페이지로 이동하는 메서드
    private void navigateToCreateMessagePage() {
        Intent intent = new Intent(Message.this, Message_create.class);
        startActivity(intent);
    }

    // 이미지와 설명이 포함된 팝업 띄우기
    private void showImagePopup() {
        Dialog dialog = new Dialog(Message.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.popup_image_description);

        ImageView imageView = dialog.findViewById(R.id.popup_image);
        imageView.setImageResource(R.drawable.call_samjum); // 표시할 이미지 설정

        TextView descriptionText = dialog.findViewById(R.id.popup_description);
        descriptionText.setText("이미지 설명"); // 설명 텍스트 설정

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
}
