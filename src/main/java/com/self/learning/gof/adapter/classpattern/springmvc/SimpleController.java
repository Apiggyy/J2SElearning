package com.self.learning.gof.adapter.classpattern.springmvc;

public class SimpleController implements Controller {
    public void handleSimpleReq() {
        System.out.println("handle simple request!");
    }
}
