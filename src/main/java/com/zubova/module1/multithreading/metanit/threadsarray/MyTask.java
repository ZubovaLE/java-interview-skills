package com.zubova.module1.multithreading.metanit.threadsarray;

class MyTask implements Runnable {

    public void run(){
        String name = Thread.currentThread().getName();
        System.out.println(name + " started...");
        System.out.println(name + " finished...");
    }
} 