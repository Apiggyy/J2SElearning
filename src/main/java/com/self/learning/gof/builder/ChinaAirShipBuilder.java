package com.self.learning.gof.builder;

public class ChinaAirShipBuilder implements AirShipBuilder {
    public OrbitalModule buildOrbitalModule() {
        return new OrbitalModule("中国神舟宇宙飞船轨道舱");
    }

    public Engine buildEngine() {
        return new Engine("中国神舟宇宙飞船发动机");
    }

    public EscapeTower buildEscapeTower() {
        return new EscapeTower("中国神舟宇宙飞船逃逸塔");
    }
}
