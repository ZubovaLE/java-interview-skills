package com.zubova.module1.multithreading.practice.counter.good.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadCounter {

    private final AtomicInteger counter = new AtomicInteger(0);

    public void increment() {
        counter.incrementAndGet();
    }

    public int getCounter() {
        return counter.get();
    }
}
