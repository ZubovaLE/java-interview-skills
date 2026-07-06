package com.zubova.module1.multithreading.example.first;

class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("Executing code from: " + Thread.currentThread());
        System.out.println("Hello world");
    }
}
