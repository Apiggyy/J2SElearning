package com.self.learning.gof.singleton;

import java.util.concurrent.CountDownLatch;

public class Client02 {

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        int threadNum = 10;
        final CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        for (int i = 0; i < threadNum; i++) {
            new Thread(new Runnable() {
                public void run() {
                    for (int i = 0; i < 10000000; i++) {
                        HungerSingleton hungerSingleton = HungerSingleton.getInstance();
                        //LazySingleton lazySingleton = LazySingleton.getInstance();
                        //StaticInnerClassSingleton staticInnerClassSingleton = StaticInnerClassSingleton.getInstance();
                        //EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
                    }
                    countDownLatch.countDown();
                }
            }).start();
        }
        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
    }
}
