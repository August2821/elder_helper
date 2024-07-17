package com.example.mypart;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Internet extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton imageButton1 = findViewById(R.id.imageButton1);
        imageButton1.setImageResource(R.drawable.samsung_internet);

        ImageButton imageButton2 = findViewById(R.id.imageButton2);
        imageButton2.setImageResource(R.drawable.google);
    }

}
