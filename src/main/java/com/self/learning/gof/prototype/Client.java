package com.self.learning.gof.prototype;

import java.util.Date;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Date birthday = new Date(1231231231113L);
        Sheep sheep1 = new Sheep("Dorry", birthday);
        System.out.println("#############sheep1##############");
        System.out.println(sheep1.getName());
        System.out.println(sheep1.getBirthday());

        Sheep sheep2 = (Sheep) sheep1.clone();
        System.out.println("#############sheep2##############");
        System.out.println(sheep2.getName());
        System.out.println(sheep2.getBirthday());

        birthday.setTime(333333333333L);

        System.out.println("#############sheep1##############");
        System.out.println(sheep1.getName());
        System.out.println(sheep1.getBirthday());

        System.out.println("#############sheep2##############");
        System.out.println(sheep2.getName());
        System.out.println(sheep2.getBirthday());
    }
}
