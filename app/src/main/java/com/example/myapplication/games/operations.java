package com.example.myapplication.games;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.myapplication.R;
import java.util.Random;

public class operations extends AppCompatActivity {

    private TextView scoreTextView;
    private Button questionButton1, questionButton2;
    private int correctAnswer, otherAnswer;
    private int correctCount = 0, wrongCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_operations);

        // UI 컴포넌트 초기화
        scoreTextView = findViewById(R.id.scoreTextView);
        questionButton1 = findViewById(R.id.questionButton1);
        questionButton2 = findViewById(R.id.questionButton2);

        // 문제 생성
        generateQuestion();

        // 버튼 클릭 리스너 설정
        // 버튼 1 클릭 시, 정답이 다른 답보다 크거나 같은지 체크
        questionButton1.setOnClickListener(v -> checkAnswer(correctAnswer >= otherAnswer));
        // 버튼 2 클릭 시, 다른 답이 정답보다 큰지 체크
        questionButton2.setOnClickListener(v -> checkAnswer(otherAnswer > correctAnswer));
    }

    @SuppressLint("SetTextI18n")
    private void generateQuestion() {
        Random random = new Random();
        // 1부터 10까지의 난수 생성
        int result1 = random.nextInt(10) + 1;
        // result1보다 1에서 3 큰 값 생성
        int result2 = result1 + (random.nextInt(3) + 1);

        // 정답과 다른 답을 랜덤하게 설정
        if (random.nextBoolean()) {
            correctAnswer = result1;
            otherAnswer = result2;
        } else {
            correctAnswer = result2;
            otherAnswer = result1;
        }

        // 버튼에 문제 표시
        questionButton1.setText(generateExpression(correctAnswer));
        questionButton2.setText(generateExpression(otherAnswer));
    }

    private String generateExpression(int result) {
        Random random = new Random();
        int operation = random.nextInt(4); // 0부터 3까지의 난수 생성 (연산 종류)
        int num1, num2;
        String expression = "";

        // 결과와 숫자가 30 미만이 되도록 설정
        int maxNumber = 30;

        switch (operation) {
            case 0: // 덧셈
                do {
                    num1 = random.nextInt(maxNumber - 1) + 1; // 1부터 maxNumber - 1까지의 난수
                    num2 = result - num1;
                } while (num2 <= 0 || num2 >= maxNumber); // num2가 0 이하이거나 maxNumber 이상이면 다시 시도
                expression = num1 + " + " + num2 + " = ?";
                break;

            case 1: // 뺄셈
                do {
                    num2 = random.nextInt(maxNumber - 1) + 1; // 1부터 maxNumber - 1까지의 난수
                    num1 = num2 + result;
                } while (num1 >= maxNumber || num2 >= maxNumber); // num1이나 num2가 maxNumber 이상이면 다시 시도
                expression = num1 + " - " + num2 + " = ?";
                break;

            case 2: // 곱셈
                do {
                    num1 = random.nextInt(maxNumber - 1) + 1; // 1부터 maxNumber - 1까지의 난수
                    num2 = result / num1;
                } while (num1 >= maxNumber || num2 >= maxNumber || result % num1 != 0); // 조건에 맞지 않으면 다시 시도
                expression = num1 + " * " + num2 + " = ?";
                break;

            case 3: // 나눗셈
                do {
                    num2 = random.nextInt(maxNumber - 1) + 1; // 1부터 maxNumber - 1까지의 난수
                    num1 = result * num2;
                } while (num1 >= maxNumber || num2 >= maxNumber); // num1이나 num2가 maxNumber 이상이면 다시 시도
                expression = num1 + " / " + num2 + " = ?";
                break;
        }

        return expression;
    }

    @SuppressLint("SetTextI18n")
    private void checkAnswer(boolean isCorrect) {
        if (isCorrect) {
            correctCount++;
            Toast.makeText(this, "정답입니다!", Toast.LENGTH_SHORT).show();
        } else {
            wrongCount++;
            Toast.makeText(this, "틀렸습니다.", Toast.LENGTH_SHORT).show();
        }
        // 점수 업데이트
        scoreTextView.setText("정답: " + correctCount + " | 오답: " + wrongCount);
        // 새 문제 생성
        generateQuestion();
    }
}
