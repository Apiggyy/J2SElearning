package com.self.learning.juc;

import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {

    public static void main(String[] args) {
        final int threadNum = 5;
        CountDownLatch latch = new CountDownLatch(threadNum);
        CountDownLatchDemo cdld = new CountDownLatchDemo(latch);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < threadNum; i++) {
            new Thread(cdld).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("耗费时间：" + (endTime - startTime));

    }
}

class CountDownLatchDemo implements  Runnable {

    private CountDownLatch latch;

    public CountDownLatchDemo(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0) {
                        System.out.println(i);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        }
    }
}
