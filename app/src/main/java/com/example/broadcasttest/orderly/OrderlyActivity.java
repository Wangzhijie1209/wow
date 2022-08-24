package com.example.broadcasttest.orderly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.broadcasttest.normal.NormalActivity;
import com.example.myapplication.R;

public class OrderlyActivity extends AppCompatActivity {
    private final String NORMAL_ACTION = "com.example.broadcasttest.normal.receiver";
    private final String ORDER_ACTION = "com.example.broadcasttest.orderly.receiver";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderly);
        Button button = findViewById(R.id.orderly_button);
        Button button2 = findViewById(R.id.orderly_button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //发送标准广播
                Intent intent = new Intent(NORMAL_ACTION);
                intent.putExtra("Msg", "Hi");
                intent.setAction("com.example.broadcasttest.normal.receiver");
                intent.setClassName(OrderlyActivity.this,"com.example.broadcasttest.normal.NormalReceiver");
                sendBroadcast(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ORDER_ACTION);
                intent.putExtra("Msg", "Hi");
                intent.setAction("com.example.broadcasttest.orderly.receiver");
                //静态注册发送有序广播 添加一个flag
                intent.addFlags(0x01000000);
                sendOrderedBroadcast(intent, null);
            }
        });

    }
}