package com.example.DesignPatterns.BuilderPattern;

/**
 * @创建人 xjs
 * @类描述 TODO
 * @创建时间 2020/7/12 0012 下午 12:30
 */
public class XjsAirShipDirector implements AirShipDirector {
    private AirShipBuilder builder;


    public XjsAirShipDirector(AirShipBuilder builder) {
        this.builder = builder;
    }

    @Override
    public AirShip directorAirShip() {
        String engine = builder.builderEngine();
        String escapeTower = builder.builderEscapeTower();
        String orbitalModule = builder.builderOrbitalModule();

        AirShip airShip=new AirShip();

        airShip.setEngine(engine);
        airShip.setEscapeTower(escapeTower);
        airShip.setOrbitalModule(orbitalModule);
        return airShip;
    }
}
