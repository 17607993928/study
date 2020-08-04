package com.example.learn.DesignPatterns.ProxyPattern.DynamicProxyPattren;

/**
 * @创建人 xjs
 * @类描述 TODO
 * @创建时间 2020/7/21 0021 下午 22:55
 */
public class RealStar implements Star {
    @Override
    public void confer() {
        System.out.println("面谈");
    }

    @Override
    public void signContract() {
        System.out.println("签合同");
    }

    @Override
    public void bookTicket() {
        System.out.println("订票");
    }

    @Override
    public void sing() {
        System.out.println("爸爸唱歌");
    }

    @Override
    public void collectMoney() {
        System.out.println("收钱");
    }
}
