package com.example.DesignPatterns.BuilderPattern;

/**
 * @创建人 xjs
 * @类描述 TODO
 * @创建时间 2020/7/12 0012 下午 12:32
 */
public class Test {
    public static void main(String[] args) {
        AirShipBuilder builder=new XjsAirShipBuilder();

        AirShipDirector airShipDirector=new XjsAirShipDirector(builder);

        AirShip airShip = airShipDirector.directorAirShip();
        String engine = airShip.getEngine();
        System.out.println(engine);


    }
}
