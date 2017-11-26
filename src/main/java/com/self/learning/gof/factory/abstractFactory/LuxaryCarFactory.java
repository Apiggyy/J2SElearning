package com.self.learning.gof.factory.abstractFactory;

public class LuxaryCarFactory implements CarFactory {
    public Engine createEngine() {
        return new LuxaryEngine();
    }

    public Seat createSeat() {
        return new LuxarySeat();
    }

    public Tyre createTyre() {
        return new LuxaryTyre();
    }
}
