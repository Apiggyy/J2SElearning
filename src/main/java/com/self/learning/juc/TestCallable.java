package com.self.learning.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallable {

    public static void main(String[] args) {
        CallableDemo demo = new CallableDemo();
        FutureTask<Integer> task = new FutureTask<>(demo);
        new Thread(task).start();
        try {
            Integer total = task.get();
            System.out.println("总和为：" + total);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class CallableDemo implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            System.out.println(i);
            sum += i;
        }
        return sum;
    }
}
