package com.example.mine;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Internet_Naver_Search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.internet_naver_search); // R.layout.your_layout는 해당 XML 레이아웃 파일의 이름으로 교체

        // ImageView 및 Button 찾기
        ImageView imageView = findViewById(R.id.itn_naver_search_page_img);
        Button button = findViewById(R.id.itn_naver_search_page_button);

        // 버튼 클릭 시 이미지 변경
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 이미지 리소스를 인터넷_naver_search_word로 변경
                imageView.setImageResource(R.drawable.internet_naver_search_word);
            }
        });
    }
}
