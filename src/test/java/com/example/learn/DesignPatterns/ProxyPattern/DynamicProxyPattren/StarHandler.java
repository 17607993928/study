package com.example.learn.DesignPatterns.ProxyPattern.DynamicProxyPattren;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @创建人 xjs
 * @类描述 动态代理
 * @创建时间 2020/7/26 0026 上午 10:44
 */
public class StarHandler implements InvocationHandler {
    private Star star;

    public StarHandler(Star star){
        this.star=star;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("哈哈哈");
        method.invoke(star,args);


        return null;
    }
}
