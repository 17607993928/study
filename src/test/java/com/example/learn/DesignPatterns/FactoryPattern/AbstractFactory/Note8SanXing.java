package com.example.learn.DesignPatterns.FactoryPattern.AbstractFactory;

/**
 * @创建人 xjs
 * @类描述 TODO
 * @创建时间 2020/7/12 0012 上午 0:01
 */
public class Note8SanXing implements SanXing {
    @Override
    public void doSMS() {
        System.out.println("三星note8发短信");
    }
}
