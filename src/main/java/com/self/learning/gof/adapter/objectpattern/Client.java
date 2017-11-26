package com.self.learning.gof.adapter.objectpattern;

public class Client {

    public static void main(String[] args) {
        Source source = new Source();
        Targetable targetable = new Wrapper(source);
        targetable.method1();
        targetable.method2();
    }
}
