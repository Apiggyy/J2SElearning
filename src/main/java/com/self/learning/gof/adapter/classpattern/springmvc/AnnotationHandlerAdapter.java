package com.self.learning.gof.adapter.classpattern.springmvc;

public class AnnotationHandlerAdapter implements HandlerAdapter {
    @Override
    public boolean support(Controller controller) {
        return controller instanceof AnnotationController;
    }

    @Override
    public void handle(Controller controller) {
        ((AnnotationController)controller).handleAnnotationReq();
    }
}
