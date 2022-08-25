package com.example.broadcasttest.dynamic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class DynamicActivity extends AppCompatActivity {

    public final static String ACTION = "com.example.broadcasttest.dynamic.BroadcastService";
    private Button stop_button;
    private Button start_button;
    private Button send_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic);
        send_button = findViewById(R.id.dynamic_send_button);
        start_button = findViewById(R.id.dynamic_start_button);
        stop_button = findViewById(R.id.dynamic_stop_button);

        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startService(view);
            }
        });
        send_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                sendBroadcast(view);
            }
        });
        stop_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                stopService(view);
            }
        });
    }

//    public void startService(View view) {
//        Intent intent = new Intent(this, BroadcastService.class);
//        startService(intent);
//    }
//
//    public void sendBroadcast(View view) {
//        Intent intent = new Intent(ACTION);
//        sendBroadcast(intent);
//    }
//
//    public void stopService(View view) {
//        Intent intent = new Intent(this, BroadcastService.class);
//        stopService(intent);
//    }



}