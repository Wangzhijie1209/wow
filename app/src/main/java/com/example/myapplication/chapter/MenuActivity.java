package com.example.myapplication.chapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.myapplication.R;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //通过getMenuInflater()方法能够得到MenuInflater对象,再调用它的inflate()方法
        //就可以给当前活动创建菜单了。
        //inflate()方法接收两个参数,第一个参数用于指定我们通过哪一个资源文件来创建菜单,
        //第二个 参数用于指定我们的菜单项将添加到哪一个Menu对象当中
        //这里直接使用onCreateOptionsMenu()方法中传入的menu参数
        getMenuInflater().inflate(R.menu.main, menu);

        //给这个方法返回true,表示允许创建的菜单显示出来,如果返回了false,创建的菜单将无法显示。
        return true;
    }

    //菜单响应事件
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //通过调用item.getItemId来判断我们点击的是哪一个菜单项
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }
}