package com.example.learn.DesignPatterns.BuilderPattern;

/**
 * @创建人 xjs
 * @类描述 TODO
 * @创建时间 2020/7/12 0012 下午 12:21
 */
public class AirShip {
    private String orbitalModule;       //轨道舱

    private String engine;              //发动机

    private String escapeTower;         //逃逸塔

    public String getOrbitalModule() {
        return orbitalModule;
    }

    public void setOrbitalModule(String orbitalModule) {
        this.orbitalModule = orbitalModule;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getEscapeTower() {
        return escapeTower;
    }

    public void setEscapeTower(String escapeTower) {
        this.escapeTower = escapeTower;
    }
}
