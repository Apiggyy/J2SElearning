package com.self.learning.gof.adapter.classpattern.springmvc;

public interface HandlerAdapter {

    boolean support(Controller controller);

    void handle(Controller controller);
}
