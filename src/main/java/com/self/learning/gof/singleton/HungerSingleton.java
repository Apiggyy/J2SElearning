package com.self.learning.gof.singleton;

public class HungerSingleton {

    public static int a = 10;

    private static HungerSingleton instance = new HungerSingleton();

    private HungerSingleton() {
        System.out.println("构造方法调用");
    }

    public static HungerSingleton getInstance() {
        return instance;
    }
}
