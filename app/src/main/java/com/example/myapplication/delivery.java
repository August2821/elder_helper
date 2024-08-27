package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class delivery extends AppCompatActivity {

    ImageButton button;
    ImageButton button42;
    ImageView imageView;
    ImageView imageView1;
    AlphaAnimation blinkAnimation1;
    AlphaAnimation blinkAnimation2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery);

        // button41 클릭 리스너 설정
        button = findViewById(R.id.button41);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), delivery1.class);
                startActivity(intent);
            }
        });

        imageView = findViewById(R.id.redblank1);
        imageView1 = findViewById(R.id.redblank2);

        // redblank1의 깜빡이는 애니메이션 설정
        blinkAnimation1 = new AlphaAnimation(0.0f, 1.0f);
        blinkAnimation1.setDuration(500); // 애니메이션의 지속 시간 (500ms)
        blinkAnimation1.setRepeatMode(Animation.REVERSE); // 역방향 반복
        blinkAnimation1.setRepeatCount(Animation.INFINITE); // 무한 반복

        imageView.startAnimation(blinkAnimation1);

        // button42 클릭 리스너 설정
        button42 = findViewById(R.id.button42);
        button42.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                // redblank1의 애니메이션 멈춤
                blinkAnimation1.cancel();
                imageView.clearAnimation(); // 애니메이션 제거

                // redblank2의 깜빡이는 애니메이션 설정
                blinkAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                blinkAnimation2.setDuration(500); // 애니메이션의 지속 시간 (500ms)
                blinkAnimation2.setRepeatMode(Animation.REVERSE); // 역방향 반복
                blinkAnimation2.setRepeatCount(Animation.INFINITE); // 무한 반복

                imageView1.startAnimation(blinkAnimation2);
            }
        });
    }
}
