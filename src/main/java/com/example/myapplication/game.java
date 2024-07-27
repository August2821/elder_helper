package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class game extends AppCompatActivity {
Button button51;
Button button52;
Button button53;
Button button54;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        button51=findViewById(R.id.button51);
        button51.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), game1.class);
                startActivity(intent);
            }
        });

        button52=findViewById(R.id.button52);
        button52.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), game2.class);
                startActivity(intent);
            }
        });
        button53=findViewById(R.id.button53);
        button53.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), game3.class);
                startActivity(intent);
            }
        });

        button54=findViewById(R.id.button54);
        button54.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), game4.class);
                startActivity(intent);
            }
        });
    }
}