package com.zubova.module1.multithreading.example.third;

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Using Runnable from: " +  Thread.currentThread());
        System.out.println("Hello world");
    }
}