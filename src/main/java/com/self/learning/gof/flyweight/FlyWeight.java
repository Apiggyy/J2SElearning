package com.self.learning.gof.flyweight;

public interface FlyWeight {
    String getColor();
    void SetColor(String Color);
    void display(Coodinate coodinate);
}

class ConcreateFlyWeight implements FlyWeight {
    private String color;

    public ConcreateFlyWeight(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public void SetColor(String Color) {
        this.color = color;
    }

    @Override
    public void display(Coodinate coodinate) {
        System.out.println("棋子颜色" + this.color);
        System.out.println("棋子坐标" + coodinate);
    }
}
