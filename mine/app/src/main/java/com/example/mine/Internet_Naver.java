package com.example.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Internet_Naver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.internet_naver); // 현재 XML 레이아웃

        // 버튼을 찾고 클릭 리스너 설정
        Button naverSearchButton = findViewById(R.id.itn_naver_search_button);
        naverSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // InternetNaverSearchActivity로 이동
                Intent intent = new Intent(Internet_Naver.this, Internet_Naver_Search.class);
                startActivity(intent);
            }
        });
    }
}
