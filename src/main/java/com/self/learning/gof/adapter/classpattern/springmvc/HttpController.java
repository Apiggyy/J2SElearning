package com.self.learning.gof.adapter.classpattern.springmvc;

public class HttpController implements Controller {
    public void handleHttpReq() {
        System.out.println("handle http request!");
    }
}
