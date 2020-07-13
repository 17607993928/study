package com.example.DesignPatterns.BuilderPattern;

/**
 * @创建人 xjs
 * @类描述 TODO
 * @创建时间 2020/7/12 0012 下午 12:28
 */
public class XjsAirShipBuilder implements AirShipBuilder {
    @Override
    public String builderEngine() {
        System.out.println("构建发动机");
        return "构建发动机";
    }

    @Override
    public String builderOrbitalModule() {
        System.out.println("构建机舱");
        return "构建机舱";
    }

    @Override
    public String builderEscapeTower() {
        System.out.println("构建逃逸仓");
        return "构建逃逸仓";
    }
}
