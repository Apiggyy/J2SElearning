package com.self.learning.gof.decorator;

public class Client {

    public static void main(String[] args) {
        ICar car = new Car();
        FlyCar flyCar = new FlyCar(car);
        flyCar.move();
        WaterCar waterCar = new WaterCar(flyCar);
        waterCar.move();
    }
}
