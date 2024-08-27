package com.example.myapplication.map;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
//import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
//import com.bumptech.glide.load.resource.bitmap.CenterCrop;
//import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import com.example.myapplication.R;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class map_ex_login1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_ex_login1);

        // 블러 효과 적용
        applyBlurEffect();
    }

    private void applyBlurEffect() {
        ImageView blurredBackground = findViewById(R.id.blurred_background);

        Glide.with(this)
                .load(R.drawable.kakao_map_login1)  // 블러 처리할 이미지 리소스
                .transform(new BlurTransformation(25, 3))  // 블러 효과 적용
                .into(blurredBackground);
    }
}
