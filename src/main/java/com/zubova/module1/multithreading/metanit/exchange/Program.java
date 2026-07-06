package com.zubova.module1.multithreading.metanit.exchange;

import java.util.concurrent.Exchanger;

public class Program {

    public static void main(String[] args) {
        Exchanger<String> ex = new Exchanger<String>();
        new Thread(new PutThread(ex)).start();
        new Thread(new GetThread(ex)).start();
    }
}