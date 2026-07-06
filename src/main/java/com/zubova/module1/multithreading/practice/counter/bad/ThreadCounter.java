package com.zubova.module1.multithreading.practice.counter.bad;

public class ThreadCounter {

    private int counter = 0;

    public void increment() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }

}