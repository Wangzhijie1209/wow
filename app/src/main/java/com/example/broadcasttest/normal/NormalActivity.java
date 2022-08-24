package com.example.broadcasttest.normal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class NormalActivity extends AppCompatActivity {
    private final String NORMAL_ACTION = "com.example.broadcasttest.normal.receiver";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        Button button = findViewById(R.id.send_normal_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NORMAL_ACTION);
                intent.putExtra("Msg", "Hi");
                intent.setAction("com.example.broadcasttest.normal.receiver");
                intent.setClassName(NormalActivity.this, "com.example.broadcasttest.normal.NormalReceiver");
                sendBroadcast(intent);
            }
        });
    }
}