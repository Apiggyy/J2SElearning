package com.self.learning.gof.factory.abstractFactory;

public class Client {
    public static void main(String[] args) {
        CarFactory factory = new LuxaryCarFactory();
        //CarFactory factory = new LowCarFactory();
        factory.createEngine().start();
        factory.createSeat().feel();
        factory.createTyre().run();

    }
}
