package com.example.DesignPatterns;

/**
 * @类描述:单例  懒汉式  +  并发
 * @创建人:xiejs
 * @创建时间:
 */
public class DoubleCheckedLocking {
    //私有化实例
    private static volatile DoubleCheckedLocking instance;

    //私有化构造
    private DoubleCheckedLocking() {

    }

    public static DoubleCheckedLocking getInstance() {
        //双重检索
        if(instance!=null){
            return instance;
        }
        synchronized(DoubleCheckedLocking.class){
            if(instance==null){
                new DoubleCheckedLocking();
            }
            return instance;
        }

    }
}
