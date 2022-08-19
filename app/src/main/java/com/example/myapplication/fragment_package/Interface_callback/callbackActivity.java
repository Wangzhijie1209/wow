package com.example.myapplication.fragment_package.Interface_callback;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;

public class callbackActivity extends AppCompatActivity {

    private Button button;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_callback);
        button = findViewById(R.id.callback_button);
        text = findViewById(R.id.callback_text);

        //步骤1:获取FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();

        //步骤2:获取FragmentTransaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //步骤3:创建需要添加的Fragment
        CallbackFragment callbackFragment = new CallbackFragment();

        //步骤4:动态添加fragment
        //即将穿甲拿到fragment添加到Activity布局文件中定义的占位符中(FrameLayout)
        fragmentTransaction.add(R.id.callback_frameLayout,callbackFragment);
        fragmentTransaction.commit();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                callbackFragment.sendMessage(new ICallBack() {
                    @Override
                    public void get_message_from_Fragment(String string) {
                        text.setText(string);
                    }
                });
            }
        });
    }
}