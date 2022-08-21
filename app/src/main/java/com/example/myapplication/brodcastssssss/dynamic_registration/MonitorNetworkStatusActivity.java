package com.example.myapplication.brodcastssssss.dynamic_registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.R;

public class MonitorNetworkStatusActivity extends AppCompatActivity {

    private NetworkChangeReceiver networkChangeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor_network_status);
        IntentFilter intentFilter = new IntentFilter();
        //当网络状态发生变化时,系统发出的正是一条值为android.net.conn.CONNECTIVITY_CHANGE的广播,
        //也就是说我们的广播接收器想要监听什么广播,就在这里添加相应的action
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        //创建了一个NetworkChangeReceiver的实例,然后调用registerReceiver()方法进行注册,将
        //NetworkChangeReceiver 和 intentFilter的实例都传进去了,这样 NetworkChangeReceiver
        //就会收到所有值为android.net.conn.CONNECTIVITY_CHANGE 的广播了
        networkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //动态注册的广播接收器一定要取消注册才行,通过调用unregisterReceiver()方法来实现的
        unregisterReceiver(networkChangeReceiver);

    }
}

/**
 * 内部类 继承自BroadcastReceiver 并重写了父类的onReceive()方法 每当网络状态发生变化时,onReceive()方法就会
 * 得到执行
 */
class NetworkChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo network = connectivityManager.getActiveNetworkInfo();
        if(network != null && network.isAvailable()){
            Toast.makeText(context, "network is available", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "network is unavailable", Toast.LENGTH_SHORT).show();
        }


    }
}