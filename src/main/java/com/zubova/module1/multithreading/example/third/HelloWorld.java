package com.zubova.module1.multithreading.example.third;

class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Creating a new thread from : " + Thread.currentThread());
        var myRunnable = new MyRunnable();
        var thread = new Thread(myRunnable);
        thread.start();
        System.out.println("Leaving from: " + Thread.currentThread());
   }
}