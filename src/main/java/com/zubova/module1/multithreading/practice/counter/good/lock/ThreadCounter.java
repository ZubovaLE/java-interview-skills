package com.zubova.module1.multithreading.practice.counter.good.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadCounter {
    private final Lock lockObject = new ReentrantLock();

    private int counter = 0;

    public void increment() {
        lockObject.lock();
        try {
            counter++;
        } finally {
            lockObject.unlock();
        }
    }

    public int getCounter() {
        return counter;
    }

}