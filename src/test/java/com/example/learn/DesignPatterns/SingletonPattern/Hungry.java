package com.example.learn.DesignPatterns.SingletonPattern;

/**
 * @创建人 xjs
 * @类描述 饿汉模式
 * @创建时间 2020/7/10 0010 下午 23:06
 */
public class Hungry {
    private static Hungry instance=new Hungry();

    private Hungry(){

    }

    public static Hungry getInstance(){
        return instance;
    }
}
