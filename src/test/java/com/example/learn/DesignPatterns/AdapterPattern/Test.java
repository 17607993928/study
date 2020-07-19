package com.example.learn.DesignPatterns.AdapterPattern;

/**
 * @创建人 xjs
 * @类描述 TODO
 * @创建时间 2020/7/18 0018 下午 17:10
 */
public class Test {
    public static void main(String[] args) {
        Client client=new Client();
        Adapter adapter=new AdapterImpl();
        client.test(adapter);
    }
}
