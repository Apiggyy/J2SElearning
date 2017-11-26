package com.self.learning.gof.adapter.classpattern;

public class Client {

    public void request(Targetable targetable) {
        targetable.handle();
    }

    public static void main(String[] args) {
        Client client = new Client();
        Targetable targetable = new Adapter();
        client.request(targetable);
    }
}
