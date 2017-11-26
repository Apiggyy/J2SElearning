package com.self.learning.juc;

import java.util.concurrent.*;

public class TestThreadPool {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final int threadNum = 5;
        ThreadPoolDemo td = new ThreadPoolDemo();
        ExecutorService pool = Executors.newFixedThreadPool(threadNum);
        //for (int i = 0; i < 10; i++) {
        //    pool.submit(td);
        //}
        Future<Integer> result = pool.submit(() -> {
            int sum = 0;
            for (int i = 1; i <= 100; i++) {
                sum += i;
            }
            return sum;
        });
        System.out.println(result.get());
        pool.shutdown();
    }
}

class ThreadPoolDemo implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}
