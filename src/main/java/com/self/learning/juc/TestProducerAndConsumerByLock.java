package com.self.learning.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestProducerAndConsumerByLock {

    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        Consumer consumer = new Consumer(clerk);
        new Thread(producer, "生产者A").start();
        new Thread(producer, "生产者B").start();
        new Thread(consumer, "消费者A").start();
        new Thread(consumer, "消费者B").start();
    }
}

//店员
class Clerk {
    private int product = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void get() { //product=0 ->product=1,loop=2 ->loop=1
        lock.lock();
        try {
            while (product >= 1) { //为了避免虚假唤醒情况，wait方法应总是使用在循环中
                System.out.println("产品已满!");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ":" + ++product);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void sale() { //product=0 ->wait() -> product=1, loop=1-> loop=0
        lock.lock();
        try {
            while (product <= 0) {  //为了避免虚假唤醒情况，wait方法应总是使用在循环中
                System.out.println("缺货!");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ":" + --product);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}

//生产者
class Producer implements Runnable {
    private Clerk clerk ;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.get();
        }
    }
}

class Consumer implements Runnable {
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            clerk.sale();
        }
    }
}

