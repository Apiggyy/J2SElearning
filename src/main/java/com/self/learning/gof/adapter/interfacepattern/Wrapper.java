package com.self.learning.gof.adapter.interfacepattern;

public abstract class Wrapper implements Sourceable {
    @Override
    public void method1() {
        System.out.println("this is wrapper's method1");
    }

    @Override
    public void method2() {
        System.out.println("this is wrapper's method2");
    }
}
