package com.self.learning.gof.factory.simpleFactory;

public class Client {
    public static void main(String[] args) {
        Car audi = CarFactory.createAudi();
        audi.run();
        Car byd = CarFactory.createByd();
        byd.run();
    }
}
