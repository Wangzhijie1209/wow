package com.example.broadcasttest.dynamic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;

import com.example.myapplication.R;

public class ExampleActivity extends AppCompatActivity {

    private ExampleBroadcastReceiver myReceiver;
    private IntentFilter filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        myReceiver = new ExampleBroadcastReceiver();
        filter = new IntentFilter();
        filter.addAction("com.example.broadcasttest.dynamic.AAA");
        //注册广播
        registerReceiver(myReceiver, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //关闭广播监听
        unregisterReceiver(myReceiver);
    }
}