package com.example.DesignPatterns.FactoryPattern.SimpleFactory;

/**
 * @创建人 xjs
 * @类描述 T测试简单工厂模式
 * @创建时间 2020/7/11 0011 下午 17:44
 */
public class Test {
    public static void main(String[] args) {
        Car audi = CarFactory.createAudi();
        Car byd = CarFactory.createByd();

        audi.run();;
        byd.run();

    }
}
