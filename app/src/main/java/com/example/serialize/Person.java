package com.example.serialize;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * 其中,get set 方法都是用于赋值和读取字段数据的,最重要的部分是 implements Serializable
 * 实现了Serializable接口 这样所有的Person对象就都是可序列化的了
 */
public class Person implements Parcelable {
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


    @Override
    public int describeContents() {
        return 0;
    }

    //将Person类中的字段一一写出
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(age);
    }
    //定义一个名为CREATOR的常量,这里创建了Parcelable.Creator接口的一个实现,并将泛型指定为Person,
    public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>(){
        //重写createFromParcel()方法
        //我们要去读取刚才写出的name和age字段,并创建一个person对象进行返回
        //注意这里读取的顺序一定要和刚才写入的顺序完全相同
        @Override
        public Person createFromParcel(Parcel parcel) {
            Person person = new Person();
            person.name = parcel.readString();
            person.age = parcel.readInt();
            return person;
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
}
