package com.self.learning.gof.adapter.objectpattern;

public class Wrapper implements Targetable {

    private Source source;

    public Wrapper() {
    }

    public Wrapper(Source source) {
        this.source = source;
    }

    @Override
    public void method1() {
        source.method1();
    }

    @Override
    public void method2() {
        System.out.println("this is targetable method!");
    }
}
