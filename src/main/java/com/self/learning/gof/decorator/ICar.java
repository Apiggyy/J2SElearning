package com.self.learning.gof.decorator;

public interface ICar {
    void move();
}

class Car implements ICar {
    @Override
    public void move() {
        System.out.println("陆地上跑");
    }
}

class WrapperCar implements ICar {
    protected ICar car;

    public WrapperCar(ICar car) {
        this.car = car;
    }

    @Override
    public void move() {
        car.move();
    }
}

class FlyCar extends WrapperCar {
    public FlyCar(ICar car) {
        super(car);
    }

    public void fly() {
        System.out.println("天上飞");
    }

    @Override
    public void move() {
        System.out.println("---增加新的功能fly");
        super.move();
        fly();
    }
}

class WaterCar extends WrapperCar {
    public WaterCar(ICar car) {
        super(car);
    }

    public void sail() {
        System.out.println("水上游");
    }

    @Override
    public void move() {
        System.out.println("---增加新的功能sail");
        super.move();
        sail();
    }
}


