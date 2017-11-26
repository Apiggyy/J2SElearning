package com.self.learning.gof.adapter.classpattern;

public class Adapter extends Adaptee implements Targetable {
    @Override
    public void method1() {
        super.method1();
    }

    @Override
    public void handle() {
        this.method1();
    }
}
