package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Success extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.success); // success.xml 레이아웃 연결

        // 버튼에 대한 참조 설정
        Button goToMainButton = findViewById(R.id.success_go_back_button);

        // 버튼 클릭 시 MainActivity로 이동
        goToMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Success.this, phonemain.class);
                startActivity(intent);
                finish(); // 현재 액티비티를 종료
            }
        });
    }
}

