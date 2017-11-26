package com.self.learning.gof.factory.factoryMethod;

import com.self.learning.gof.factory.simpleFactory.Car;

public class Client {
    public static void main(String[] args) {
        Car audi = new AudiFactory().createCar();
        audi.run();
        Car byd = new BydFactory().createCar();
        byd.run();
    }
}
