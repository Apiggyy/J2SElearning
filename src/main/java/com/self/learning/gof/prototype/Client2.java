package com.self.learning.gof.prototype;

/**
 * 测试Clone模式和New方式的效率
 */
public class Client2 {

    public static void testNew(int size) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            Computer computer = new Computer();
        }
        long end = System.currentTimeMillis();
        System.out.println("new方式耗时：" + (end - start));
    }

    public static void testClone(int size) throws CloneNotSupportedException {
        long start = System.currentTimeMillis();
        Computer computer = new Computer();
        for (int i = 0; i < size; i++) {
            computer.clone();
        }
        long end = System.currentTimeMillis();
        System.out.println("clone方式耗时：" + (end - start));
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        int size = 1000;
        testNew(size);
        testClone(size);
    }
}

class Computer implements Cloneable {
    public Computer() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
