package com.example.learn.DesignPatterns.ProxyPattern.staticProxyPattren;

/**
 * @创建人 xjs
 * @类描述 TODO
 * @创建时间 2020/7/21 0021 下午 22:56
 */
public class ProxyStar implements Star {

    private Star star;

    public ProxyStar(Star realStar){
        this.star=realStar;
    }

    @Override
    public void confer() {

    }

    @Override
    public void signContract() {

    }

    @Override
    public void bookTicket() {

    }

    @Override
    public void sing() {
        star.sing();
    }

    @Override
    public void collectMoney() {

    }
}
