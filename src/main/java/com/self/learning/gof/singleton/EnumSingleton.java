package com.self.learning.gof.singleton;

/**
 * 缺点：没有延迟加载
 * 优点：enum天然是单例，JVM提供源生保障，避免通过反射和反序列化的漏洞
 */
public enum EnumSingleton {
    INSTANCE;
    public void singletonOperation() {

    }
}
