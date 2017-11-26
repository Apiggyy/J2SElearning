package com.self.learning.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestABCAlternate {

    public static void main(String[] args) {
        ABCAlternate alternate = new ABCAlternate();
        final int totalLoop = 10;
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= totalLoop; i++) {
                    alternate.loopA(i);
                }
            }
        },"A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= totalLoop; i++) {
                    alternate.loopB(i);
                }
            }
        },"B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= totalLoop; i++) {
                    alternate.loopC(i);
                }
            }
        },"C").start();
    }
}

class ABCAlternate {

    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void loopA(int loop) {
        lock.lock();
        try {
            while (number != 1) {
                try {
                    condition1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 1; i <=10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + loop);
            }
            number = 2;
            condition2.signal();
        } finally {
           lock.unlock();
        }
    }

    public void loopB(int loop) {
        lock.lock();
        try {
            while (number != 2) {
                try {
                    condition2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 1; i <=10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + loop);
            }
            number = 3;
            condition3.signal();
        } finally {
            lock.unlock();
        }
    }

    public void loopC(int loop) {
        lock.lock();
        try {
            while (number != 3) {
                try {
                    condition3.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 1; i <=10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + loop);
            }
            System.out.println("---------------------------------------------");
            number = 1;
            condition1.signal();
        } finally {
            lock.unlock();
        }
    }
}
