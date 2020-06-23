package com.example.learn.annotation.study;

/**
 * @类描述:注解
 * @创建人:xiejs
 * @创建时间:2020-6-19 10:26:27
 */
public class Demo01 extends Object {


    @Override
    public String toString() {
        return super.toString();
    }

//    @Info(studentName = "我是你爸爸",age = 19,id = 10086)
    public void test(){
        System.out.println("用于注解作用范围");
    }
}

