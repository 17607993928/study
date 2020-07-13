package com.example.learn.dynamic.jvm;

/**
 * @类描述:jvm类加载过程
 * @创建人:xiejs
 * @创建时间:2020-7-10 13:50:02
 */
public class Demo01 {
    public static void main(String[] args) {
        A a=new A();
        System.out.println(A.width);

    }
}


class A {
    public static int width = 100;

    static {
        System.out.println("静态初始化！");
        width = 300;
    }
}
