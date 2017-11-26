package com.self.learning.gof.proxy;

import java.lang.reflect.Proxy;

public class Client {

    public static void main(String[] args) {
        Star star = new RedStar();
        StarHandler handler = new StarHandler(star);
        Star starProxy = (Star) Proxy.newProxyInstance(star.getClass().getClassLoader(), star.getClass().getInterfaces(),
                handler);
        starProxy.act();
        starProxy.sing();
        starProxy.earnMoney();
        starProxy.endorsement();
    }
}
