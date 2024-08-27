package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.map.map_main;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1=findViewById(R.id.delivery_instruction);
        Button button2=findViewById(R.id.map_instruction);
        Button button3=findViewById(R.id.suggestion_box);
        Button button4=findViewById(R.id.phone_instruction);

        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, deliverymain.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, map_main.class);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://forms.gle/GKP1AXoouNHA7NDV7"));
            startActivity(intent);
        });

        button4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, phonemain.class);
                startActivity(intent);
            }
        });
    }


}