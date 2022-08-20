package com.example.myapplication.brodcastssssss.dynamic_registration;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * 接收两种类型的广播:
 * 锁屏广播和解锁广播,广播的事件可以通过形参的intent.getAction()获取到
 */
public class LockScreenBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = LockScreenBroadcastReceiver.class.getSimpleName();

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if(Intent.ACTION_SCREEN_OFF.equals(action)){
            Log.e(TAG, "锁屏了");
        }

        if(Intent.ACTION_SCREEN_ON.equals(action)){
            Log.e(TAG, "解锁了");
        }
    }
}
