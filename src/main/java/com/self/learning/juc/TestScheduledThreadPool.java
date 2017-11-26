package com.self.learning.juc;

import java.util.concurrent.*;

public class TestScheduledThreadPool {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Future<Integer> future = service.schedule(() -> {
                int number = (int) (Math.random() * 101);
                System.out.println(Thread.currentThread().getName() + " : " + number);
                return number;
            }, 3, TimeUnit.SECONDS);
            System.out.println("result : " + future.get());
        }
        service.shutdown();
    }
}