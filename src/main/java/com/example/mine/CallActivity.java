package com.example.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class CallActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call);

        Button buttonPhone = findViewById(R.id.button7);
        buttonPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CallActivity.this, BasicCall.class);
                startActivity(intent);
            }
        });

        Button buttonTPhone = findViewById(R.id.button8);
        buttonTPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CallActivity.this, TCall.class);
                startActivity(intent);
            }
        });

        Button buttonContacts = findViewById(R.id.button9);
        buttonContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CallActivity.this, Call_num.class);
                startActivity(intent);
            }
        });

        Button buttonMessages = findViewById(R.id.button10);
        buttonMessages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CallActivity.this, Message.class);
                startActivity(intent);
            }
        });
    }
}
