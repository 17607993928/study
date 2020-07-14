package com.example.DesignPatterns.FactoryPattern.AbstractFactory;

/**
 * @创建人 xjs
 * @类描述 TODO
 * @创建时间 2020/7/11 0011 下午 23:57
 */
public class Mix3XiaoMi implements XiaoMi {
    @Override
    public void playGame() {
        System.out.println("小米MIX3打游戏");
    }

    @Override
    public void callPhone() {
        System.out.println("小米MIX3打电话");
    }
}
