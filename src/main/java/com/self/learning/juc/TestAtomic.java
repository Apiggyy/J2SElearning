package com.self.learning.juc;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomic {
    public static void main(String[] args) {
        AtomicDemo ad = new AtomicDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(ad).start();
        }
    }
}

class AtomicDemo implements Runnable {
    private AtomicInteger serialNumber = new AtomicInteger();

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " : " + getSerialNumber());
    }

    public int getSerialNumber() {
        return serialNumber.getAndIncrement();
    }
}
