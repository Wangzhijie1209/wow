package com.example.myapplication.brodcastssssss.dynamic_registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import com.example.myapplication.R;

public class BroadcastssActivity extends AppCompatActivity {

    private LockScreenBroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcastss);
        IntentFilter intentFilter = new IntentFilter();

        //添加广播事件(注意:想要接收哪种类型的广播必须再此处添加,否则接收不到)
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);

        receiver = new LockScreenBroadcastReceiver();
        registerReceiver(receiver,intentFilter);
    }

    @Override
    protected void onDestroy() {
        //在Activity销毁的时候解绑广播,防止为解绑照成的内存泄露
        super.onDestroy();
    }
}