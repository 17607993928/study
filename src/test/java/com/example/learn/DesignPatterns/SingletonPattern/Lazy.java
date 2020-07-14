package com.example.learn.DesignPatterns.SingletonPattern;

/**
 * @创建人 xjs
 * @类描述 懒汉模式
 * @创建时间 2020/7/10 0010 下午 22:53
 */
public class Lazy {
    private static Lazy lazy;

    private Lazy(){

    }

    public static Lazy getInstance(){
        if(lazy==null){
            lazy= new Lazy();
        }
        return lazy;
    }
}
