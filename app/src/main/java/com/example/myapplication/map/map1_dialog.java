package com.example.myapplication.map;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;

public class map1_dialog extends AppCompatActivity {

    private int currentPage = 0; // 현재 페이지 인덱스
    private final String[] descriptions = {
            "빨간 테두리의 직사각형을 클릭하세요. (카카오계정으로 로그인)",
            "빨간 테두리의 직사각형을 클릭하세요. (카카오계정으로 로그인)",
            "카카오톡이 실행되면서 자동으로 로그인이 됩니다!"
    };
    private final int[] images = {
            R.drawable.kakaotalk1,
            R.drawable.kakaotalk2,
            R.drawable.kakaotalk3
    };

    private ImageView mainImageView;
    private TextView instructionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_1);

        // ImageView 및 TextView를 찾고 변수에 저장
        mainImageView = findViewById(R.id.kakao1);
        instructionText = findViewById(R.id.instruction_text);

        // drawable 폴더의 이미지를 설정
        mainImageView.setImageResource(R.drawable.kakaotalk1);

        // ImageView 클릭 시 팝업 다이얼로그를 표시
        mainImageView.setOnClickListener(v -> {
            // TextView를 숨김
            instructionText.setVisibility(View.GONE);
            showDescriptionDialog();
        });
    }

    private void showDescriptionDialog() {
        // 다이얼로그 인스턴스 생성
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.map_1_dialog);

        // 다이얼로그의 UI 요소를 찾음
        TextView dialogDescription = dialog.findViewById(R.id.dialog_description_text);
        Button btnPrevious = dialog.findViewById(R.id.btn_previous);
        Button btnNext = dialog.findViewById(R.id.btn_next);

        // 다이얼로그의 설명 설정
        dialogDescription.setText(descriptions[currentPage]);

        // 다이얼로그 위치를 상단에 설정하고 배경 어두워짐 제거
        if (dialog.getWindow() != null) {
            WindowManager.LayoutParams layoutParams = dialog.getWindow().getAttributes();
            layoutParams.gravity = Gravity.TOP;
            layoutParams.y = 20; // 다이얼로그의 Y 좌표를 20dp로 설정
            layoutParams.flags &= ~WindowManager.LayoutParams.FLAG_DIM_BEHIND; // 배경 어두워짐 제거
            dialog.getWindow().setAttributes(layoutParams);
        }

        // 이전 버튼 클릭 리스너
        btnPrevious.setOnClickListener(v -> {
            if (currentPage > 0) {
                currentPage--;
                mainImageView.setImageResource(images[currentPage]);
                dialogDescription.setText(descriptions[currentPage]);
            }
        });

        // 다음 버튼 클릭 리스너
        btnNext.setOnClickListener(v -> {
            if (currentPage < descriptions.length - 1) {
                currentPage++;
                mainImageView.setImageResource(images[currentPage]);
                dialogDescription.setText(descriptions[currentPage]);
            }
        });

        dialog.show();
    }
}
