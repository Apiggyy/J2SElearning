package com.self.learning.gof.builder;

public class Client {
    public static void main(String[] args) {
        AirShipBuilder builder = new ChinaAirShipBuilder();
        Director director = new ChinaDirector(builder);
        AirShip airShip = director.createAirShip();
        System.out.println(airShip);
    }
}
