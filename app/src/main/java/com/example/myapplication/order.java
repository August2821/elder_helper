package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class order extends AppCompatActivity {
    ImageView imageView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order);

        imageView = findViewById(R.id.rbmenu);
        editText = findViewById(R.id.editTextmenu);

        if (imageView != null) {
            AlphaAnimation blinkAnimation = new AlphaAnimation(0.0f, 1.0f);
            blinkAnimation.setDuration(500); // 애니메이션의 지속 시간 (500ms)
            blinkAnimation.setRepeatMode(Animation.REVERSE); // 역방향 반복
            blinkAnimation.setRepeatCount(Animation.INFINITE); // 무한 반복
            imageView.startAnimation(blinkAnimation);
        }

        if (editText != null) {
            editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    // IME_ACTION_DONE만 확인
                    if (actionId == EditorInfo.IME_ACTION_DONE) {
                        String inputText = editText.getText().toString().trim();

                        if ("치킨".equals(inputText)) {
                            Intent intent = new Intent(order.this, order1.class);
                            startActivity(intent);
                            return true;
                        }
                    }
                    return false;
                }
            });
        }
    }
}