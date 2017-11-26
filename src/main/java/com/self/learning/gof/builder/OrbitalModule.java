package com.self.learning.gof.builder;

public class OrbitalModule {
    private String name;

    public OrbitalModule() {
    }

    public OrbitalModule(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "OrbitalModule{" +
                "name='" + name + '\'' +
                '}';
    }
}
