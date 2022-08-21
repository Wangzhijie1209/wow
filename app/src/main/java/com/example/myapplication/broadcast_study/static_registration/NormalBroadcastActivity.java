package com.example.myapplication.broadcast_study.static_registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class NormalBroadcastActivity extends AppCompatActivity {

    private final String NORMAL_ACTION = "com.example.myapplication.broadcast_study.NORMAL_ACTION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_broadcast);
        Button button = findViewById(R.id.normal_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NORMAL_ACTION);
                intent.putExtra("Msg", "Hi");
                intent.setAction("com.example.myapplication.broadcast_study.NORMAL_ACTION");
                intent.setClassName(NormalBroadcastActivity.this,"com.example.myapplication.broadcast_study.static_registration.NormalReceiver");
                sendBroadcast(intent);
            }
        });
    }
}