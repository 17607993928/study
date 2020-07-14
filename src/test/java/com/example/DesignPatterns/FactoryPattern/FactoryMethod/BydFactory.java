package com.example.DesignPatterns.FactoryPattern.FactoryMethod;

/**
 * @创建人 xjs
 * @类描述 TODO
 * @创建时间 2020/7/11 0011 下午 18:45
 */
public class BydFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Byd();
    }
}
