package com.example.mine;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class BasicCall extends AppCompatActivity {

    private TextView phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call_basic);

        phoneNumber = findViewById(R.id.phone_number);

        Button[] buttons = {
                findViewById(R.id.button1), findViewById(R.id.button2), findViewById(R.id.button3),
                findViewById(R.id.button4), findViewById(R.id.button5), findViewById(R.id.button6),
                findViewById(R.id.button7), findViewById(R.id.button8), findViewById(R.id.button9),
                findViewById(R.id.button0), findViewById(R.id.button_star), findViewById(R.id.button_hash)
        };

        for (Button button : buttons) {
            button.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onClick(View v) {
                    String currentText = phoneNumber.getText().toString();
                    String buttonText = ((Button) v).getText().toString();
                    phoneNumber.setText(currentText + buttonText);
                }
            });
        }

        findViewById(R.id.button_call).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCallDialog();
            }
        });

        findViewById(R.id.button_keypad).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showKeypadDialog();
            }
        });

        findViewById(R.id.button_recent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BasicCall.this, RecentCall.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.button_contacts).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BasicCall.this, CNumCall.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.button_places).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 아무 기능 없음
            }
        });
    }

    private void showCallDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Calling to " + phoneNumber.getText().toString())
                .setPositiveButton("OK", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showKeypadDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("현재 페이지 입니다")
                .setPositiveButton("OK", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
