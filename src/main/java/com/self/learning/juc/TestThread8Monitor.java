package com.self.learning.juc;

public class TestThread8Monitor {

    public static void main(String[] args) {
        Number number = new Number();
        Number number1 = new Number();
        new Thread(new Runnable() {
            @Override
            public void run() {
                number.getOne();
            }
        },"A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                //number.getTwo();
                number1.getTwo();
            }
        },"B").start();

/*        new Thread(new Runnable() {
            @Override
            public void run() {
                number.getThree();
            }
        },"C").start();*/
    }
}

class Number {

    public static synchronized void getOne() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("one");
    }

    public static synchronized void getTwo() {
        System.out.println("two");
    }

    public void getThree() {
        System.out.println("three");
    }
}
