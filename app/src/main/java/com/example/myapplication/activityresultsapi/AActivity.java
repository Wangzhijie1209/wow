package com.example.myapplication.activityresultsapi;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.R;

public class AActivity extends AppCompatActivity {
    private ActivityResultLauncher<Intent> mIntentActivityResultLauncher;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aactivity);
        mContext = this;

        //只能在onCreate onAttach方法中注册
        mIntentActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                String answer = result.getData().getStringExtra("message");
                Toast.makeText(mContext, answer, Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.a_Button).setOnClickListener(v ->{
            //执行跳转的方法
            jumpToTwoActivity();
        });

    }
    private void jumpToTwoActivity(){
        //封装Intent
        Intent intent = new Intent(mContext, BActivity.class);
        intent.putExtra("message","问:吃饭了吗");
        //跳转
        mIntentActivityResultLauncher.launch(intent);
    }
}