package com.example.serialize;

import java.io.Serializable;

/**
 * 其中,get set 方法都是用于赋值和读取字段数据的,最重要的部分是 implements Serializable
 * 实现了Serializable接口 这样所有的Person对象就都是可序列化的了
 */
public class Person implements Serializable {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
