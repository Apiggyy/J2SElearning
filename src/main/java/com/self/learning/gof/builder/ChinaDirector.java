package com.self.learning.gof.builder;

public class ChinaDirector implements Director {

    private AirShipBuilder builder;

    public ChinaDirector(AirShipBuilder builder) {
        this.builder = builder;
    }

    public AirShip createAirShip() {
        OrbitalModule orbitalModule = builder.buildOrbitalModule();
        Engine engine = builder.buildEngine();
        EscapeTower escapeTower = builder.buildEscapeTower();
        return new AirShip(orbitalModule, engine, escapeTower);
    }
}
