package com.example.learn.DesignPatterns.FactoryPattern.SimpleFactory;

/**
 * @创建人 xjs
 * @类描述 TODO
 * @创建时间 2020/7/11 0011 下午 17:41
 */
public class CarFactory {
    public static Car createCar(String type){
        if("Audi".equals(type)){
            return new Audi();
        }
        if("Byd".equals(type)){
            return new Byd();
        }
        return null;
    }

    //------------------或者这样写--------------
    public static Car createByd(){
        return new Byd();
    }
    public static Car createAudi(){
        return new Audi();
    }
}
