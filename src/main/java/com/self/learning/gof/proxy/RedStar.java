package com.self.learning.gof.proxy;

public class RedStar implements Star {

    @Override
    public void endorsement() {
        System.out.println("RedStar.endorsement");
    }

    @Override
    public void sing() {
        System.out.println("RedStar.sing");
    }

    @Override
    public void act() {
        System.out.println("RedStar.act");
    }

    @Override
    public void earnMoney() {
        System.out.println("RedStar.earnMoney");
    }
}
