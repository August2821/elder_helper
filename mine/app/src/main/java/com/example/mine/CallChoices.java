package com.example.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class CallChoices extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call_choices);  // call.xml 레이아웃 파일을 설정합니다.

        // 번호 버튼
        Button buttonNum = findViewById(R.id.call_choices_page_num_button);
        buttonNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // CallByNum 활동으로 이동
                Intent intent = new Intent(CallChoices.this, CallByType.class);
                startActivity(intent);
            }
        });

        // 연락처 버튼
        Button buttonContact = findViewById(R.id.call_choices_page_callNum_button);
        buttonContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // CallByType 활동으로 이동
                Intent intent = new Intent(CallChoices.this, CallByNum.class);
                startActivity(intent);
            }
        });
    }
}
