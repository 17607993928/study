package com.example.DesignPatterns.FactoryPattern.AbstractFactory;

/**
 * @创建人 xjs
 * @类描述 TODO
 * @创建时间 2020/7/11 0011 下午 23:55
 */
public class Mi10XiaoMi implements XiaoMi {
    @Override
    public void playGame() {
        System.out.println("小米10手机打游戏");
    }

    @Override
    public void callPhone() {
        System.out.println("小米10手机打电话");
    }
}
