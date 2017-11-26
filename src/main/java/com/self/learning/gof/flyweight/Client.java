package com.self.learning.gof.flyweight;

public class Client {

    public static void main(String[] args) {
        FlyWeight flyWeight1 = FlyWeightFactory.getFlyWeight("black");
        FlyWeight flyWeight2 = FlyWeightFactory.getFlyWeight("black");

        System.out.println(flyWeight1);
        System.out.println(flyWeight2);

        flyWeight1.display(new Coodinate(10, 10));
        flyWeight1.display(new Coodinate(20, 20));
    }
}
