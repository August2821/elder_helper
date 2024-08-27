package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class delivery6 extends AppCompatActivity {

    ImageButton button;
    ImageButton button1;
    ImageView imageView;
    ImageView imageView1;
    AlphaAnimation blinkAnimation1;
    AlphaAnimation blinkAnimation2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery6);

        button = findViewById(R.id.agree);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), delivery7.class);
                startActivity(intent);
            }
        });

        imageView = findViewById(R.id.checkfirst);
        imageView1 = findViewById(R.id.agree1);

        blinkAnimation1 = new AlphaAnimation(0.0f, 1.0f);
        blinkAnimation1.setDuration(500); // 애니메이션의 지속 시간 (500ms)
        blinkAnimation1.setRepeatMode(Animation.REVERSE); // 역방향 반복
        blinkAnimation1.setRepeatCount(Animation.INFINITE); // 무한 반복

        imageView.startAnimation(blinkAnimation1);

        button1 = findViewById(R.id.check);
        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                blinkAnimation1.cancel();
                imageView.clearAnimation(); // 애니메이션 제거

                blinkAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                blinkAnimation2.setDuration(500); // 애니메이션의 지속 시간 (500ms)
                blinkAnimation2.setRepeatMode(Animation.REVERSE); // 역방향 반복
                blinkAnimation2.setRepeatCount(Animation.INFINITE); // 무한 반복

                imageView1.startAnimation(blinkAnimation2);
            }
        });
    }
}