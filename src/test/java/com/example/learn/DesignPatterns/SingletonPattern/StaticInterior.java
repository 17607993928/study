package com.example.learn.DesignPatterns.SingletonPattern;

/**
 * @创建人 xjs
 * @类描述 静态内部实现
 * @创建时间 2020/7/10 0010 下午 23:09
 */
public class StaticInterior {
    private static class SingletonClassInstance{
        private static final StaticInterior instance=new StaticInterior();
    }

    private StaticInterior(){

    }

    public StaticInterior getInstance(){
        return SingletonClassInstance.instance;
    }
}
