package com.example.learn.DesignPatterns.ProxyPattern.DynamicProxyPattren;

import java.lang.reflect.Proxy;

/**
 * @创建人 xjs
 * @类描述 TODO
 * @创建时间 2020/7/26 0026 上午 10:49
 */
public class Test {
    public static void main(String[] args) {
        Star realStar=new RealStar();

        StarHandler starHandler=new StarHandler(realStar);

        Star instance = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Star.class}, starHandler);

        instance.sing();
    }
}
