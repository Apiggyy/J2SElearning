package com.self.learning.gof.builder;

public interface AirShipBuilder {
    OrbitalModule buildOrbitalModule();
    Engine buildEngine();
    EscapeTower buildEscapeTower();
}
