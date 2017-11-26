package com.self.learning.gof.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StarHandler implements InvocationHandler {

    private Object target;

    public StarHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object object = null;
        if (method.getName().equals("sing")) {
            System.out.println("+++++++ before：" + method.getName() + "+++++++");
            object = method.invoke(target, args);
            System.out.println("+++++++ after：" + method.getName() + "+++++++");
        } else {
            object = method.invoke(target, args);
        }
        return object;
    }
}
