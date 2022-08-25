package com.example.broadcasttest.dynamic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class ExampleBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG =ExampleBroadcastReceiver.class.getSimpleName();

    private static final String ACTION_BOOT = "com.example.broadcasttest.dynamic.AAA";

    //当onReceive()方法执行完成之后,ExampleBroadcastReceiver生命周期结束可能会被系统回收,所以
    //onReceive()中不建议进行异步操作,另外 由于ANR限制,哦那Receive()方法必须在10秒内执行完成
    @Override
    public void onReceive(Context context, Intent intent) {
        if(ACTION_BOOT.equals(intent.getAction())){
            Log.e(TAG, "接收启动完成的广播");
            Toast.makeText(context,"system boot completed",Toast.LENGTH_LONG).show();
        }
    }
}
