package com.example.learn.DesignPatterns.FactoryPattern.AbstractFactory;

/**
 * @创建人 xjs
 * @类描述 TODO
 * @创建时间 2020/7/12 0012 上午 0:02
 */
public class Note9SanXing implements SanXing {
    @Override
    public void doSMS() {
        System.out.println("三星note9发短信");
    }
}
