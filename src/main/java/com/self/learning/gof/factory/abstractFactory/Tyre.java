package com.self.learning.gof.factory.abstractFactory;

public interface Tyre {
    void run();
}

class LuxaryTyre implements Tyre {
    public void run() {
        System.out.println("耐磨损");
    }
}

class LowTyre implements Tyre {
    public void run() {
        System.out.println("易磨损");
    }
}
