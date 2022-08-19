package com.example.myapplication.fragment_package;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

/**
 *在左侧碎片中的按钮注册了一个点击事件,然后调用replaceFragment()方法添加了RightFragment这个碎片,当点击左侧碎片中
 * 的按钮时,又会调用replaceFragment()方法将右侧碎片替换成AnotherRightFragment。
 */
public class Fragment_test_Activity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test);
        Button button = findViewById(R.id.left_fragment_button);
        button.setOnClickListener(this);
        replaceFragment(new RightFragment());

    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.left_fragment_button:
                replaceFragment(new AnotherRightFragment());
                break;
            default:
                break;
        }
    }

    /**
     * 动态添加碎片分为5步:
     * 1.创建待添加的碎片实例
     * 2.获取FragmentManager,在活动中可以直接通过调用getSupportFragmentManager()方法得到
     * 3.开启一个事务,通过调用beginTransaction()方法开启
     * 4.向容器内添加或替换碎片,一般使用replace()方法实现,需要传入容器的id和待添加的碎片实例
     * 5.提交事务,调用commit()方法来完成
     * @param fragment
     */
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.right_fragment,fragment);
        //在fragment中模拟返回栈
        //在事务提交之前调用了FragmentTransaction的addToBackStack()方法,它可以接收一个名字用于描述返回栈
        //的状态,一般传入null即可
        //现在按下back键,程序不会立即退出,而是先回到RightFragment界面 继续按下back键,RightFragment界面也会消失,
        //再次按下Back键,程序才会退出
        transaction.addToBackStack(null);
        transaction.commit();
    }
}