package com.zubova.module1.multithreading.metanit.atomic;

import java.util.concurrent.atomic.AtomicLong;

class Counter {
    // Правильный, потокобезопасный счетчик
    private AtomicLong counter = new AtomicLong(0);

    long getCounter() {
        return counter.get();
    }

    void increment() {
        counter.getAndIncrement();
    }   //  АТОМАРНАЯ ОПЕРАЦИЯ!
}