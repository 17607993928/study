package com.example.learn.DesignPatterns.SingletonPattern;

/**
 * @创建人 xjs
 * @类描述 枚举单例模式
 * @创建时间 2020/7/10 0010 下午 23:01
 */
public enum  EnumSingleton {
    INSTANCE;

    public void singletonOperation(){

    }

}

class test{
    public static void main(String[] args) {
        EnumSingleton instance = EnumSingleton.INSTANCE;
        EnumSingleton instance1=EnumSingleton.INSTANCE;
        System.out.println(instance+" --  "+instance1);

    }
}
