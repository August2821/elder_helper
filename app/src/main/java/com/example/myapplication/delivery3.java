package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class delivery3 extends AppCompatActivity {
ImageButton button;
ImageView iv8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery3);

        button=findViewById(R.id.MyPage);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), delivery4.class);
                startActivity(intent);
            }
        });

        iv8 = findViewById(R.id.redblank8);

        AlphaAnimation blinkAnimation = new AlphaAnimation(0.0f, 1.0f);
        blinkAnimation.setDuration(500); // 애니메이션의 지속 시간 (500ms)
        blinkAnimation.setRepeatMode(Animation.REVERSE); // 역방향 반복
        blinkAnimation.setRepeatCount(Animation.INFINITE); // 무한 반복

        iv8.startAnimation(blinkAnimation);

    }
}