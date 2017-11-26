package com.self.learning.gof.singleton;

/**
 * StaticInnerClassSingleton类初始化时不会初始化静态内部类，只会初始化类变量（静态变量和静态语句块）
 * 1.外部类没有static属性，不会像饿汉式那样立即加载对象
 * 2.只有真正调用getInstance()，才会加载静态内部类,实现延迟加载。
 * 3.类初始化是线程安全的
 */
public class StaticInnerClassSingleton {

    public static int a = 10;

    private StaticInnerClassSingleton(){
        System.out.println("构造方法调用");
    }

    private static class StaticInnerClass {
        private static final StaticInnerClassSingleton instance = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance() {
        return StaticInnerClass.instance;
    }
}

