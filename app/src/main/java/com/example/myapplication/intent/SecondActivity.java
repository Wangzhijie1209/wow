package com.example.myapplication.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button button = findViewById(R.id.btn_2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //构建一个intent
                Intent intent = new Intent();
                //将要传递的数据存放在intent中
                intent.putExtra("data_return", "Hello FirstActivity");
                //调用setResult()方法向上一个活动返回处理结果,一般使用RESULT_OK 或 RESULT_CANCELED这两个值
                //第二个参数则把带有数据的intent传递回去
                setResult(RESULT_OK, intent);
                //调用finish销毁当前活动
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return", "Hello FirstActivity");
        setResult(RESULT_OK, intent);
        finish();
    }
}