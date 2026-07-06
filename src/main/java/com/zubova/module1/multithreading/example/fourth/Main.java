package com.zubova.module1.multithreading.example.fourth;

public class Main {

    public static void main(String[] args) {
        var thread = new Thread(() -> {
            System.out.println("Using Runnable from: " + Thread.currentThread());
            System.out.println("Hello world");
        });
        thread.start();
    }
}
