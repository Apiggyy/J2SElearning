package com.self.learning.gof.factory.factoryMethod;

import com.self.learning.gof.factory.simpleFactory.Audi;
import com.self.learning.gof.factory.simpleFactory.Car;

public class AudiFactory implements CarFactory {
    public Car createCar() {
        return new Audi();
    }
}
