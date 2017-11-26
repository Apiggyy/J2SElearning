package com.self.learning.gof.adapter.classpattern.springmvc;

import java.util.ArrayList;
import java.util.List;

public class DispatchServlet {

    private List<HandlerAdapter> adapters = new ArrayList<>();

    public DispatchServlet() {
        this.adapters.add(new HttpHandlerAdapter());
        this.adapters.add(new SimpleHandlerAdapter());
        this.adapters.add(new AnnotationHandlerAdapter());
    }

    public void doDispatch() {
        Controller controller = new AnnotationController();
        HandlerAdapter adapter = getHandler(controller);
        adapter.handle(controller);
    }

    private HandlerAdapter getHandler(Controller controller) {
        for (HandlerAdapter adapter : this.adapters) {
            if (adapter.support(controller)) {
                return adapter;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        new DispatchServlet().doDispatch();
    }
}
