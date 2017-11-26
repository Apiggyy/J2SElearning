package com.self.learning.gof.prototype;

import java.util.Date;

public class Sheep implements Cloneable {
    private String name;
    private Date birthday;

    public Sheep() {

    }

    public Sheep(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object obj = super.clone();
        Sheep sheep = (Sheep) obj;
        sheep.setBirthday((Date) this.getBirthday().clone());
        return obj;
    }
}
