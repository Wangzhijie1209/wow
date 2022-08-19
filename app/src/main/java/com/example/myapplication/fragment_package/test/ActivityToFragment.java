package com.example.myapplication.fragment_package.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.R;

public class ActivityToFragment extends AppCompatActivity {

    private TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_fragment);
        test = findViewById(R.id.activity_to_fragment_text);

        //步骤1:获取fragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();

        //步骤2:获取fragmentTransaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //步骤3:创建需要添加的Fragment
        mFragment mFragment = new mFragment();

        //步骤4:创建bundle对象
        //作用:存储数据,并传递到Fragment中
        Bundle bundle = new Bundle();

        //步骤5:往bundle中添加输入
        bundle.putString("message","I love Google");

        //步骤6:把数据设置到Fragment中
        mFragment.setArguments(bundle);

        //步骤7:动态添加fragment
        //即将创建的fragment添加到Activity布局文件中定义的占位符中(FrameLayout)
        fragmentTransaction.add(R.id.fragment_container,mFragment);
        fragmentTransaction.commit();

    }
}