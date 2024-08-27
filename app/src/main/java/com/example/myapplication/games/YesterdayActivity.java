package com.example.myapplication.games;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.myapplication.R;

import androidx.appcompat.app.AppCompatActivity;

public class YesterdayActivity extends AppCompatActivity {

    private TextView tvQuestionLunch; // 어제 점심 질문을 표시할 TextView
    private TextView tvQuestionShirtColor; // 어제 상의 색상 질문을 표시할 TextView
    private EditText etAnswerLunch; // 어제 점심 답변을 입력할 EditText
    private EditText etAnswerShirtColor; // 어제 상의 색상 답변을 입력할 EditText

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_yesterday_activity);

        // View 요소 초기화
        tvQuestionLunch = findViewById(R.id.tv_question_lunch);
        tvQuestionShirtColor = findViewById(R.id.tv_question_shirt_color);
        etAnswerLunch = findViewById(R.id.et_answer_lunch);
        etAnswerShirtColor = findViewById(R.id.et_answer_shirt_color);

        // SharedPreferences를 사용하여 어제의 기록을 불러옴
        SharedPreferences preferences = getSharedPreferences("daily_record", Context.MODE_PRIVATE);
        String yesterdayLunch = preferences.getString("yesterday_lunch", null);
        String yesterdayShirtColor = preferences.getString("yesterday_shirt_color", null);

        // 어제의 기록이 없으면 메시지를 표시하고 액티비티를 종료
        if (yesterdayLunch == null || yesterdayShirtColor == null) {
            Toast.makeText(this, "어제의 기록이 없습니다.", Toast.LENGTH_SHORT).show();
            finish(); // 액티비티 종료
            return;
        }

        // 어제의 질문을 TextView에 설정
        tvQuestionLunch.setText("어제 점심으로 먹은 음식은?");
        tvQuestionShirtColor.setText("어제 상의 색상은?");
    }

    // 확인 버튼 클릭 시 호출되는 메소드
    public void onCheckClick(View view) {
        // SharedPreferences를 사용하여 어제의 기록을 다시 불러옴
        SharedPreferences preferences = getSharedPreferences("daily_record", Context.MODE_PRIVATE);
        String yesterdayLunch = preferences.getString("yesterday_lunch", null);
        String yesterdayShirtColor = preferences.getString("yesterday_shirt_color", null);

        // 사용자가 입력한 답변을 가져옴
        String answerLunch = etAnswerLunch.getText().toString();
        String answerShirtColor = etAnswerShirtColor.getText().toString();

        // 사용자의 답변이 어제의 기록과 일치하는지 확인
        if (yesterdayLunch.equals(answerLunch) && yesterdayShirtColor.equals(answerShirtColor)) {
            Toast.makeText(this, "정답입니다!", Toast.LENGTH_SHORT).show(); // 정답일 경우 메시지 표시
        } else {
            Toast.makeText(this, "틀렸습니다.", Toast.LENGTH_SHORT).show(); // 오답일 경우 메시지 표시
        }
    }
}
