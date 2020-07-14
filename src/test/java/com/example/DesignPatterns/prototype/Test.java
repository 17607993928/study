package com.example.DesignPatterns.prototype;

import java.util.Date;

/**
 * @类描述:
 * @创建人:xiejs
 * @创建时间:
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Sheep s1=new Sheep();
        s1.setAge(19);
        s1.setName("大");
        s1.setDate(new Date());

        Sheep s2 = (Sheep) s1.clone();

        s2.setDate(new Date(1112313215L));

        s1.setDate(new Date());

        System.out.println(s1.getDate());
        System.out.println(s2.getDate());



    }
}
