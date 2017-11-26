package com.self.learning.innerclass;

public class Demo01 {
    public static void main(String[] args) {
        //静态内部类
        //OutterClass.StaticInnerClass outterClass = new OutterClass.StaticInnerClass();
        //outterClass.sayHello();

        //成员内部类
        //OutterClass outterClass = new OutterClass();
        //OutterClass.FieldInnerClass fieldInnerClass = outterClass.new FieldInnerClass();
        //fieldInnerClass.sayHello();

        //继承式匿名内部类调用
        //OutterClass outterClass = new OutterClass();
        //outterClass.test01();

        //参数式匿名内部类调用
        OutterClass outterClass = new OutterClass();
        outterClass.test02(new Car() {
            @Override
            public void run() {
                System.out.println("ccc车在跑");
            }
        });

    }
}

class OutterClass {

    //静态内部类
    public static class StaticInnerClass {
        private int a = 10;
        private static int b = 10;
        public void sayHello() {
            System.out.println("Hello world!" + a);
            System.out.println("Hello world!" + b);
        }
    }

    //成员内部类
    public class FieldInnerClass {
        private int a = 10;
        private final static int b = 11;
        public void sayHello() {
            System.out.println("Hello world!" + a);
            System.out.println("Hello world!" + b);
        }
    }

    public void test01() {
        final int a = 10;

        //方法内部类
        class localInnerClass {
            public void sayHello() {
                System.out.println(a);
            }
        }

        //方法内部类 + 接口式匿名内部类
        Runnable runnable = new Runnable() {
            public void run() {
            }
        };

        //方法内部类 + 继承式匿名内部类
        Car car = new Car(){
            @Override
            public void run() {
                System.out.println("aaa车在跑");
            }
        };
        car.run();
    }

    public void test02(Car car) {
        car.run();
    }
}

class Car {
    public void run() {
        System.out.println("车在跑");
    }
}

