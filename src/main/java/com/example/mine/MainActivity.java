package com.example.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonPhonePage = findViewById(R.id.button2);
        buttonPhonePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CallActivity.class);
                startActivity(intent);
            }
        });

        Button buttonInternet = findViewById(R.id.button);
        buttonInternet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InternetActivity.class);
                startActivity(intent);
            }
        });

        Button buttonSettings = findViewById(R.id.button3);
        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });

        Button buttonTools = findViewById(R.id.button4);
        buttonTools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ToolActivity.class);
                startActivity(intent);
            }
        });

        Button buttonPhotos = findViewById(R.id.button5);
        buttonPhotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PictureActivity.class);
                startActivity(intent);
            }
        });

        Button buttonOthers = findViewById(R.id.button6);
        buttonOthers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ExtraActivity.class);
                startActivity(intent);
            }
        });
    }
}
