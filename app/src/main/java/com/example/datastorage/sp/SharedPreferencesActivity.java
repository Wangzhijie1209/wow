package com.example.datastorage.sp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

/**
 * 三种用于得到SharedPreferences对象的方式
 * 1.Context类中的getSharedPreferences()方法
 * 此方法接收两个参数,第一个参数用于指定SharedPreferences文件的名称,如果指定的文件不存在则会创建一个,SharedPreferences
 * 文件都是存放在 /data/data/<package name>/shared_prefs/ 目录下的。第二个参数用于指定操作模式，目前只有MODE_PRIVATE
 * 这一种模式可选,他是默认的操作模式,和直接传入0效果是相同的,表示只有当前的应用程序才可以对这个文件进行读写
 * <p>
 * 2.Activity类中的getPreferences()方法
 * 这个方法和Context中的getSharedPreferences()方法很相似,不过它只接收一个操作模式参数,因为使用这个方法时会自动将当前
 * 活动的类名作为SharedPreferences的文件名
 * <p>
 * 3.PreferenceManager类中的getDefaultSharedPreferences()方法
 * 这是一个静态方法,它接收一个Context参数,并自动使用当前应用程序的包名作为前缀来命名SharedPreferences文件,得到了SharedPreferences
 * 对象之后,就可以开始向SharedPreferences文件中存储数据了,主要可分为3步实现
 * 3.1 调用SharedPreferences 对象的edit()方法来获取一个 SharedPreferences.Editor对象
 * 3.2 向SharedPreferences.Editor对象中添加数据,比如添加一个布尔型数据就使用putBoolean()方法,添加一个字符串就使用putString()方法
 * 3.3 调用apply()方法将添加的数据提交,从而完成数据存储操作
 */
public class SharedPreferencesActivity extends AppCompatActivity {

    private static final String TAG = SharedPreferencesActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        Button button = findViewById(R.id.input_button);
        Button write_button = findViewById(R.id.write_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
                editor.putString("name", "Tom");
                editor.putInt("age", 28);
                editor.putBoolean("married", false);
                editor.apply();
            }
        });

        write_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getSharedPreferences("data", MODE_PRIVATE);
                String name = pref.getString("name", "");
                int age = pref.getInt("age", 0);
                boolean married = pref.getBoolean("married", false);
                Log.e(TAG, "name is " + name);
                Log.e(TAG, "age is " + age);
                Log.e(TAG, "married is " + married);
            }
        });
    }
}