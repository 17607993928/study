package com.example.learn.DesignPatterns.ProxyPattern.staticProxyPattren;

/**
 * @创建人 xjs
 * @类描述 TODO
 * @创建时间 2020/7/21 0021 下午 23:15
 */
public class Test {
    public static void main(String[] args) {
        Star real=new RealStar();
        Star proxy=new ProxyStar(real);
        proxy.sing();
        proxy.collectMoney();
    }
}
