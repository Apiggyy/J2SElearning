package com.self.learning.gof.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyWeightFactory {

    private static Map<String, FlyWeight> map = new HashMap<>();

    public static FlyWeight getFlyWeight(String color) {
        if (map.get(color) != null) {
            return map.get(color);
        } else {
            FlyWeight flyWeight = new ConcreateFlyWeight(color);
            map.put(color,flyWeight);
            return flyWeight;
        }
    }
}
