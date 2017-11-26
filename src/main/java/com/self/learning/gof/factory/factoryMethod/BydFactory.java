package com.self.learning.gof.factory.factoryMethod;

import com.self.learning.gof.factory.simpleFactory.Byd;
import com.self.learning.gof.factory.simpleFactory.Car;

public class BydFactory implements CarFactory {
    public Car createCar() {
        return new Byd();
    }
}
