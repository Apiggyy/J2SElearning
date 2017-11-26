package com.self.learning.juc;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestReadWriterLock {

    public static void main(String[] args) {
        ReadWriteLockDemo demo = new ReadWriteLockDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.set((int) (Math.random() * 101));
            }
        },"WriteLock").start();
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    demo.get();
                }
            },"ReadLock[" + i + "]").start();
        }
    }
}

class ReadWriteLockDemo {
    private int number = 0;
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public void get() {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "获取[number] ->" + number);
        } finally {
            lock.readLock().unlock();
        }
    }

    public void set(int number) {
        lock.writeLock().lock();
        try {
            this.number = number;
            System.out.println(Thread.currentThread().getName() + "设置[number] ->" + number);
        } finally {
            lock.writeLock().unlock();
        }
    }

}
