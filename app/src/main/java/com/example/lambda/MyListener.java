package com.example.lambda;

//MyListener接口中也只有一个待实现方法,这和Runnable接口的构造是基本一致的。
//唯一不同的是 MyListener中的doSomething()方法是有参数并且有返回值的,这种情况下如何使用Lambda进行实现呢?
public interface MyListener {
    String doSomething(String a,int b);
}
