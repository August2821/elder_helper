package com.example.myapplication.games;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class RecordActivity extends AppCompatActivity {

    // 어제 점심 및 상의 색상 기록을 입력할 EditText 필드
    private EditText etLunch;
    private EditText etShirtColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_record);

        // EditText 뷰 초기화
        etLunch = findViewById(R.id.et_lunch);
        etShirtColor = findViewById(R.id.et_shirt_color);
    }

    // 제출 버튼 클릭 시 호출되는 메소드
    public void onSubmitClick(View view) {
        // EditText에서 입력된 텍스트를 가져옴
        String lunch = etLunch.getText().toString();
        String shirtColor = etShirtColor.getText().toString();

        // 모든 항목이 입력되었는지 확인
        if (lunch.isEmpty() || shirtColor.isEmpty()) {
            Toast.makeText(this, "모든 항목을 입력해주세요.", Toast.LENGTH_SHORT).show();
            return; // 하나라도 비어있으면 메시지를 표시하고 리턴
        }

        // SharedPreferences를 사용하여 오늘의 기록을 저장
        SharedPreferences preferences = getSharedPreferences("daily_record", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        // 이전에 저장된 오늘의 점심과 상의 색상을 어제의 기록으로 저장
        String yesterdayLunch = preferences.getString("today_lunch", null);
        String yesterdayShirtColor = preferences.getString("today_shirt_color", null);
        editor.putString("yesterday_lunch", yesterdayLunch);
        editor.putString("yesterday_shirt_color", yesterdayShirtColor);

        // 오늘의 점심과 상의 색상을 저장
        editor.putString("today_lunch", lunch);
        editor.putString("today_shirt_color", shirtColor);

        // 변경 사항을 적용
        editor.apply();

        // 저장 완료 메시지 표시
        Toast.makeText(this, "기록이 저장되었습니다.", Toast.LENGTH_SHORT).show();

        // 액티비티 종료
        finish();
    }
}
