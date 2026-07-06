package com.zubova.module1.multithreading.practice.counter.good.sync;

public class ThreadCounter {

    private int counter = 0;

    public synchronized void increment() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }

}