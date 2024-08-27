package com.example.myapplication.games;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class Yesterday extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_yesterday);
    }

    public void onRecordTodayClick(View view) {
        Intent intent = new Intent(this, RecordActivity.class);
        startActivity(intent);
    }

    public void onCheckYesterdayClick(View view) {
        Intent intent = new Intent(this, YesterdayActivity.class);
        startActivity(intent);
    }
}