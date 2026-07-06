package com.zubova.module1.multithreading.metanit.longadder;

import java.util.concurrent.atomic.LongAdder;

class Counter {

    private LongAdder counter = new LongAdder();

    long getCounter() {
        return counter.longValue();
    }   // возвращаем сумму всех значений (инкрементов) потоков

    void increment() {
        counter.increment();
    }   //  увеличиваем на 1
}