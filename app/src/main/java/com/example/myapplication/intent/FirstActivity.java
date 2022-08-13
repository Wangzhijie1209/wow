package com.example.myapplication.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

/**
 * Intent是Android程序中各组件之间进行交互的一种重要方式,它不仅可以指明当前组件想要执行的动作,还可以在
 * 不同组件之间传递数据.Intent一般可被用于启动活动、启动服务以及发送广播等场景。
 * Intent可以分为两种:显示Intent和隐式Intent
 */
public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Button button1 = findViewById(R.id.btn_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //第一个参数Context要求提供一个启动活动的上下文,第二个参数Class则是指定想要启动的目标活动
               Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                //startActivity()方法专门用于启动活动,它接收一个Intent参数,直接将构建好的Intent参数传入即可
                startActivity(intent);
            }
        });
    }
}