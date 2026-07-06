package com.zubova.module1.multithreading.example.first;

class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Creating a new thread from : " + Thread.currentThread());
        var myThread = new MyThread();
        myThread.start();
        System.out.println("Leaving from: " + Thread.currentThread());
    }
}