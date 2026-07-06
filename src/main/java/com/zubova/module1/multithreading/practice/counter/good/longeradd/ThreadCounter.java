package com.zubova.module1.multithreading.practice.counter.good.longeradd;

import java.util.concurrent.atomic.LongAdder;

public class ThreadCounter {

    private final LongAdder counter = new LongAdder();

    public void increment() {
        counter.add(1);
    }

    public int getCounter() {
        return counter.intValue();
    }
}
