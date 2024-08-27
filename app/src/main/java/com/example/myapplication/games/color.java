package com.example.myapplication.games;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.RecognitionListener;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import com.example.myapplication.R;

public class color extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_RECORD_AUDIO = 1001;
    private static final String TAG = "GameColorActivity";

    private TextView colorText;
    private TextView correctAnswerText;
    private TextView recognizedText;
    private Button recordButton;
    private Random random;
    private SpeechRecognizer speechRecognizer;
    private Intent speechRecognizerIntent;
    private boolean isListening = false;

    private final String[] colorNames = {"빨강", "검정", "초록"};
    private final int[] colorValues = {Color.RED, Color.BLACK, Color.GREEN};
    private int currentColorIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_color);

        // UI 요소 초기화
        colorText = findViewById(R.id.color_text);
        correctAnswerText = findViewById(R.id.correct_answer);
        recognizedText = findViewById(R.id.recognized_text);
        recordButton = findViewById(R.id.record_button);
        random = new Random();

        // 오디오 권한 확인
        checkAudioPermission();

        // 녹음 버튼 클릭 리스너 설정
        recordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isListening) {
                    stopListening();
                } else {
                    startListening();
                }
                isListening = !isListening;
            }
        });

        // 랜덤 색상 텍스트 설정
        setRandomColorText();
    }

    // 랜덤 색상 텍스트 설정
    private void setRandomColorText() {
        int textIndex = random.nextInt(colorNames.length);
        do {
            currentColorIndex = random.nextInt(colorValues.length);
        } while (currentColorIndex == textIndex);

        colorText.setText(colorNames[textIndex]);
        colorText.setTextColor(colorValues[currentColorIndex]);
        correctAnswerText.setVisibility(View.GONE);
        recognizedText.setText("인식된 텍스트"); // 새 색상이 설정될 때 인식된 텍스트 초기화
    }

    // 오디오 권한 확인 및 요청
    private void checkAudioPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, PERMISSION_REQUEST_RECORD_AUDIO);
        } else {
            setupSpeechRecognizer();
        }
    }

    // 음성 인식기 설정
    private void setupSpeechRecognizer() {
        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
        speechRecognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_PARTIAL_RESULTS, true);

        speechRecognizer.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle params) {
                Log.d(TAG, "onReadyForSpeech");
            }

            @Override
            public void onBeginningOfSpeech() {
                Log.d(TAG, "onBeginningOfSpeech");
            }

            @Override
            public void onRmsChanged(float rmsdB) {
            }

            @Override
            public void onBufferReceived(byte[] buffer) {
            }

            @Override
            public void onEndOfSpeech() {
                Log.d(TAG, "onEndOfSpeech");
            }

            @Override
            public void onError(int error) {
                Log.d(TAG, "onError: " + error);
            }

            @Override
            public void onResults(Bundle results) {
                // 음성 인식 결과가 도착했을 때 호출
                ArrayList<String> matches = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                if (matches != null && !matches.isEmpty()) {
                    recognizedText.setText(matches.get(0)); // 최종 인식된 텍스트 표시
                    handleResults(matches.get(0));
                }
            }

            @Override
            public void onPartialResults(Bundle partialResults) {
                // 부분적인 음성 인식 결과가 도착했을 때 호출
                ArrayList<String> partialMatches = partialResults.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                if (partialMatches != null && !partialMatches.isEmpty()) {
                    recognizedText.setText(partialMatches.get(0)); // 부분적으로 인식된 텍스트 업데이트
                }
            }

            @Override
            public void onEvent(int eventType, Bundle params) {
            }
        });
    }

    // 음성 인식 시작
    private void startListening() {
        speechRecognizer.startListening(speechRecognizerIntent);
        recordButton.setText("녹음 중지");
    }

    // 음성 인식 중지
    private void stopListening() {
        speechRecognizer.stopListening();
        recordButton.setText("녹음 시작");
    }

    // 음성 인식 결과 처리
    private void handleResults(String result) {
        if (result.equalsIgnoreCase(getColorNameFromValue(colorValues[currentColorIndex]))) {
            correctAnswerText.setVisibility(View.VISIBLE);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    correctAnswerText.setVisibility(View.GONE);
                    setRandomColorText();
                }
            }, 2000);
        }
    }

    // 색상 값으로 색상 이름 가져오기
    private String getColorNameFromValue(int colorValue) {
        for (int i = 0; i < colorValues.length; i++) {
            if (colorValues[i] == colorValue) {
                return colorNames[i];
            }
        }
        return "";
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (speechRecognizer != null) {
            speechRecognizer.destroy();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_RECORD_AUDIO && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            setupSpeechRecognizer();
        } else {
            Toast.makeText(this, "음성 인식 권한이 필요합니다.", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
