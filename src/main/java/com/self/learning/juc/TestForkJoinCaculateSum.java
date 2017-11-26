package com.self.learning.juc;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class TestForkJoinCaculateSum {

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinCaculateSum(0L, 100000000);
        Long result = pool.invoke(task);
        System.out.println(result);
    }
}

class ForkJoinCaculateSum extends RecursiveTask<Long> {

    private static final long serialVersionUID = -8085381153700062320L;
    private static final long THRESHOLD = 10000L;
    private long start;
    private long end;

    public ForkJoinCaculateSum(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if ((end - start) <= THRESHOLD) {
            long sum = 0L;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            long middle = (start + end) / 2;
            ForkJoinCaculateSum left = new ForkJoinCaculateSum(start, middle);
            left.fork();

            ForkJoinCaculateSum right = new ForkJoinCaculateSum(middle + 1, end);
            right.fork();

            return left.join() + right.join();
        }
    }
}
