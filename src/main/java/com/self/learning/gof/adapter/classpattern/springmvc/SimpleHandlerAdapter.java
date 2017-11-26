package com.self.learning.gof.adapter.classpattern.springmvc;

public class SimpleHandlerAdapter implements HandlerAdapter {
    @Override
    public boolean support(Controller controller) {
        return controller instanceof SimpleController;
    }

    @Override
    public void handle(Controller controller) {
        ((SimpleController)controller).handleSimpleReq();
    }
}
