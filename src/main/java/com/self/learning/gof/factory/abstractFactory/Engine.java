package com.self.learning.gof.factory.abstractFactory;

public interface Engine {
    void start();
}

class LuxaryEngine implements Engine {
    public void start() {
        System.out.println("马力大");
    }
}

class LowEngine implements Engine {
    public void start() {
        System.out.println("马力小");
    }
}
