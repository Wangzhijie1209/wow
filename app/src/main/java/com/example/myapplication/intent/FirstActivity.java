package com.example.myapplication.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

/**
 * Intent是Android程序中各组件之间进行交互的一种重要方式,它不仅可以指明当前组件想要执行的动作,还可以在
 * 不同组件之间传递数据.Intent一般可被用于启动活动、启动服务以及发送广播等场景。
 * Intent可以分为两种:显示Intent和隐式Intent
 * <p>
 * 隐式Intent:
 * 相比于显示Intent,隐式Intent则含蓄了许多,它并不明确指出我们想要启动哪一个活动,而是指定了一系列更为抽象
 * 的action 和 category等信息,然后交给系统去分析这个Intent,并帮我们找出合适的活动去启动
 * 1:在AndroidManifest中为目标Activity配置<intent-filter>的内容,可以指定当前活动能够响应的action和category
 * 2:使用Intent的另外一个构造行数,直接将action的字符串传进去,表明我们想要启动能够响应com.example.myapplication.intent.ACTION_START
 * 这个aciton的活动.
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
//                //第一个参数Context要求提供一个启动活动的上下文,第二个参数Class则是指定想要启动的目标活动
//               Intent intent = new Intent("com.example.myapplication.intent.ACTION_START");
//                //startActivity()方法专门用于启动活动,它接收一个Intent参数,直接将构建好的Intent参数传入即可
//                startActivity(intent);

                //首先指定了Intent的action是Intent.ACTION_VIEW,这是一个Android系统内置的动作,其常量值为android.intent.action.View,
                //然后通过Uri.parse()方法,将一个网址字符串解析成一个Uri对象,再调用Intent的setData()方法将这个Uri对象传递进去。
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("http://www.baidu.com"));
//                startActivity(intent);

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });
    }
}