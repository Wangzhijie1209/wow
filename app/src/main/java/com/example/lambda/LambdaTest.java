package com.example.lambda;

import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Lambda表达式的一些案例
 */
public class LambdaTest {
    private Button a;
    public static void main(String[] args) {
        //1.开启一个子线程,传统写法:
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
        //使用Lambda表达式
        new Thread(() -> {

        }).start();
        //为什么可以使用这种写法? 因为Thread类的构造函数接收的参数是一个Runnable接口,并且该接口中只有一个待实现方法。也就是run()方法
        //凡是这种只有一个待实现方法的接口,都可以使用Lambda表达式的写法,比如说,通常创建一个类似与上述接口的匿名实现需要这样写:
        new Runnable() {
            @Override
            public void run() {
                //具体的实现
            }
        };
        //而有了Lambda表达式之后就可以这样写:
        Runnable runnable = () -> {
            //添加具体的实现
        };

        //带参数的匿名实现写法
        MyListener myListener = (String a, int b) -> {
            String result = a + b;
            return result;
        };
        //另外,Java还可以根据上下文自动推断出Lambda表达式中的参数类型,因此上面的写法也可以简化成如下写法:
        MyListener listener = (a, b) -> {
            String result = a + b;
            return result;
        };
        //java将会自动推断出参数a是String类型,b是int类型,从而使我们的带啊吗变得更加简简洁了


        //调用hello()方法的时候可以这样写:
        hello((a, b) -> {
            String result = a + b;
            return result;
        });
        //那么DoSomething()方法就会将a和b两个参数进行相加,从而最终的打印结果就会是Hello Lambda1024

        //只要是符合接口中只有一个待实现方法这个规则的功能,都是可以使用Lambda表达式来编写的,比如设置点击事件:
        //传统写法
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //而使用Lambda 就可以简化为这样:
        a.setOnClickListener((v)->{
            //处理点击事件
        });

        //另外,当接口的待实现方法有且只有一个参数的时候,我们还可以进一步简化,将参数外面的括号去掉
        a.setOnClickListener(v->{
            //处理点击事件
        });


    }

    //接下来举个例子,比如说现在有一个方法是接收MyListener参数的,
    public static void hello(MyListener listener) {
        String a = "Hello Lambda";
        int b = 1024;
        String result = listener.doSomething(a, b);
        Log.d("TAG", result);
    }
}
