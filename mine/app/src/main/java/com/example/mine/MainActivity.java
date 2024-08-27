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

        Button buttonPhonePage = findViewById(R.id.phone_page_call_button);
        buttonPhonePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Call.class);
                startActivity(intent);
            }
        });

        Button buttonInternet = findViewById(R.id.phone_page_internet_button);
        buttonInternet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Internet.class);
                startActivity(intent);
            }
        });

        Button buttonSettings = findViewById(R.id.phone_page_setting_button);
        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Setting.class);
                startActivity(intent);
            }
        });

        Button buttonTools = findViewById(R.id.phone_page_tool_button);
        buttonTools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Tool.class);
                startActivity(intent);
            }
        });

        Button buttonPhotos = findViewById(R.id.phone_page_picture_button);
        buttonPhotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Picture.class);
                startActivity(intent);
            }
        });

        Button buttonOthers = findViewById(R.id.phone_page_extra_button);
        buttonOthers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Extra.class);
                startActivity(intent);
            }
        });
    }
}
