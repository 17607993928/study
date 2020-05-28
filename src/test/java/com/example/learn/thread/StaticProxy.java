package com.example.learn.thread;

/**
 * @类描述:静态代理
 * @创建人:xiejs
 * @创建时间:
 */
public class StaticProxy {

    public static void main(String[] args) {
        new Proxy(new You()).happyMarry();
    }

}

interface Marry{
    void happyMarry();
}

class You implements Marry{

    @Override
    public void happyMarry() {
        System.out.println("you and his");
    }
}

class Proxy implements Marry{
    private Marry target;
    public Proxy(Marry target) {
        this.target=target;
    }

    @Override
    public void happyMarry() {
        System.out.println("忙前");
        this.target.happyMarry();
        System.out.println("忙后");
    }

}
