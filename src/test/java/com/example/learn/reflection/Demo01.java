package com.example.learn.reflection;

import com.example.swagger.user.domain.po.UserPO;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @创建人 xjs
 * @类描述 获取类的信息
 * @创建时间 2020/7/6 0006 下午 21:59
 */
public class Demo01 {

    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("com.example.swagger.user.domain.po.UserPO");




            Method[] methods = clazz.getMethods();

            for (Method method : methods) {
                System.out.println(method.getName());
            }

            Object o = clazz.newInstance();

            Method selectAll = clazz.getMethod("test",String.class);

            Object invoke = selectAll.invoke(o, "xjs");


        } catch (ClassNotFoundException | NoSuchMethodException e) {
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
