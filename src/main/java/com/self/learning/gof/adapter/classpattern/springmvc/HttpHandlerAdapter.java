package com.self.learning.gof.adapter.classpattern.springmvc;

public class HttpHandlerAdapter implements HandlerAdapter {
    @Override
    public boolean support(Controller controller) {
        return controller instanceof HttpController;
    }

    @Override
    public void handle(Controller controller) {
        ((HttpController)controller).handleHttpReq();
    }
}
