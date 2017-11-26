package com.self.learning.gof.factory.abstractFactory;

public interface Seat {
    void feel();
}

class LuxarySeat implements Seat {
    public void feel() {
        System.out.println("座位舒适");
    }
}

class LowSeat implements Seat {
    public void feel() {
        System.out.println("座位硬");
    }
}
